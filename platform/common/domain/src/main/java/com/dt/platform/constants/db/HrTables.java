package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2024-03-04 07:43:06
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class HrTables {
	
	/**
	 * 年假规则
	*/
	public static class HR_ANNUAL_LEAVE_RULE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_annual_leave_rule";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 起始年限
		*/
		public static final DBField START = new DBField(DBDataType.INTEGER , "start","start","起始年限","起始年限",false,false,true);
		
		/**
		 * 截止年限
		*/
		public static final DBField END = new DBField(DBDataType.INTEGER , "end","end","截止年限","截止年限",false,false,true);
		
		/**
		 * 年假天数
		*/
		public static final DBField DAYS = new DBField(DBDataType.INTEGER , "days","days","年假天数","年假天数",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ANNUAL_LEAVE_RULE() {
			this.init($NAME,"年假规则" , ID , START , END , DAYS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ANNUAL_LEAVE_RULE $TABLE=new HR_ANNUAL_LEAVE_RULE();
	}
	
	/**
	 * 考核单据
	*/
	public static class HR_ASSESSMENT_BILL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_bill";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 考核
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","考核","考核",false,false,true);
		
		/**
		 * 考核名称
		*/
		public static final DBField TASK_NAME = new DBField(DBDataType.STRING , "task_name","taskName","考核名称","考核名称",false,false,true);
		
		/**
		 * 状态,待下发，考评中，考评结束，取消
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","待下发，考评中，考评结束，取消",false,false,true);
		
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
		
		public HR_ASSESSMENT_BILL() {
			this.init($NAME,"考核单据" , ID , TASK_ID , TASK_NAME , STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_ASSESSMENT_BILL $TABLE=new HR_ASSESSMENT_BILL();
	}
	
	/**
	 * 考核周期
	*/
	public static class HR_ASSESSMENT_CYCLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_cycle";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 考核主题
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","考核主题","考核主题",false,false,true);
		
		/**
		 * 考核说明
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","考核说明","考核说明",false,false,true);
		
		/**
		 * 年份
		*/
		public static final DBField YEAR = new DBField(DBDataType.STRING , "year","year","年份","年份",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField SDATE = new DBField(DBDataType.DATE , "sdate","sdate","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField EDATE = new DBField(DBDataType.DATE , "edate","edate","结束时间","结束时间",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 提及人
		*/
		public static final DBField RCD_USER_ID = new DBField(DBDataType.STRING , "rcd_user_id","rcdUserId","提及人","提及人",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_CYCLE() {
			this.init($NAME,"考核周期" , ID , NAME , INFO , YEAR , SDATE , EDATE , LABEL , RCD_USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_CYCLE $TABLE=new HR_ASSESSMENT_CYCLE();
	}
	
	/**
	 *  考核评级
	*/
	public static class HR_ASSESSMENT_GRADE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_grade";
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_GRADE() {
			this.init($NAME," 考核评级" , ID , CODE , NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_GRADE $TABLE=new HR_ASSESSMENT_GRADE();
	}
	
	/**
	 * 考核指标
	*/
	public static class HR_ASSESSMENT_INDICATOR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_indicator";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 考核主题
		*/
		public static final DBField ASSESSMENT_ID = new DBField(DBDataType.STRING , "assessment_id","assessmentId","考核主题","考核主题",false,false,true);
		
		/**
		 * 指标库
		*/
		public static final DBField TPL_INDICATOR_ID = new DBField(DBDataType.STRING , "tpl_indicator_id","tplIndicatorId","指标库","指标库",false,false,true);
		
		/**
		 * 指标名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","指标名称","指标名称",false,false,true);
		
		/**
		 * 权重(%)
		*/
		public static final DBField WEIGHT = new DBField(DBDataType.DECIMAL , "weight","weight","权重","%)",false,false,true);
		
		/**
		 * 最小评分值
		*/
		public static final DBField TARGET_MIN_VALUE = new DBField(DBDataType.DECIMAL , "target_min_value","targetMinValue","最小评分值","最小评分值",false,false,true);
		
		/**
		 * 最大评分值
		*/
		public static final DBField TARGET_MAX_VALUE = new DBField(DBDataType.DECIMAL , "target_max_value","targetMaxValue","最大评分值","最大评分值",false,false,true);
		
		/**
		 * 默认评分值
		*/
		public static final DBField DEFAULT_VALUE = new DBField(DBDataType.DECIMAL , "default_value","defaultValue","默认评分值","默认评分值",false,false,true);
		
		/**
		 * 定性/定量指标
		*/
		public static final DBField PROPERTY = new DBField(DBDataType.STRING , "property","property","定性/定量指标","定性/定量指标",false,false,true);
		
		/**
		 * 计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","计量单位","计量单位",false,false,true);
		
		/**
		 * 指标定义
		*/
		public static final DBField DEF = new DBField(DBDataType.STRING , "def","def","指标定义","指标定义",false,false,true);
		
		/**
		 * 评分标准
		*/
		public static final DBField SCORING_BASE = new DBField(DBDataType.STRING , "scoring_base","scoringBase","评分标准","评分标准",false,false,true);
		
		/**
		 * 评分依据
		*/
		public static final DBField SCORING_BY = new DBField(DBDataType.STRING , "scoring_by","scoringBy","评分依据","评分依据",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SN = new DBField(DBDataType.INTEGER , "sn","sn","排序","排序",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_INDICATOR() {
			this.init($NAME,"考核指标" , ID , ASSESSMENT_ID , TPL_INDICATOR_ID , NAME , WEIGHT , TARGET_MIN_VALUE , TARGET_MAX_VALUE , DEFAULT_VALUE , PROPERTY , UNIT , DEF , SCORING_BASE , SCORING_BY , SN , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_INDICATOR $TABLE=new HR_ASSESSMENT_INDICATOR();
	}
	
	/**
	 * 考核结果
	*/
	public static class HR_ASSESSMENT_INDICATOR_VALUE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_indicator_value";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_ID = new DBField(DBDataType.STRING , "indicator_id","indicatorId","指标","指标",false,false,true);
		
		/**
		 * 评分人类型
		*/
		public static final DBField OWNER = new DBField(DBDataType.STRING , "owner","owner","评分人类型","评分人类型",false,false,true);
		
		/**
		 * 评分人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","评分人","评分人",false,false,true);
		
		/**
		 * 评分
		*/
		public static final DBField VALUE = new DBField(DBDataType.DECIMAL , "value","value","评分","评分",false,false,true);
		
		/**
		 * 说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","说明","说明",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_INDICATOR_VALUE() {
			this.init($NAME,"考核结果" , ID , INDICATOR_ID , OWNER , USER_ID , VALUE , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_INDICATOR_VALUE $TABLE=new HR_ASSESSMENT_INDICATOR_VALUE();
	}
	
	/**
	 * 考核方式
	*/
	public static class HR_ASSESSMENT_METHOD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_method";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 考核方式
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","考核方式","考核方式",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_METHOD() {
			this.init($NAME,"考核方式" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_METHOD $TABLE=new HR_ASSESSMENT_METHOD();
	}
	
	/**
	 * 考核计划
	*/
	public static class HR_ASSESSMENT_PLAN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_plan";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 考核名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","考核名称","考核名称",false,false,true);
		
		/**
		 * 岗位
		*/
		public static final DBField POS_ID = new DBField(DBDataType.STRING , "pos_id","posId","岗位","岗位",false,false,true);
		
		/**
		 * 周期
		*/
		public static final DBField CYCLE = new DBField(DBDataType.STRING , "cycle","cycle","周期","周期",false,false,true);
		
		/**
		 * 考核方式
		*/
		public static final DBField METHOD = new DBField(DBDataType.STRING , "method","method","考核方式","考核方式",false,false,true);
		
		/**
		 * 被考核人
		*/
		public static final DBField ASSESSEE_ID = new DBField(DBDataType.STRING , "assessee_id","assesseeId","被考核人","被考核人",false,false,true);
		
		/**
		 * 考核人
		*/
		public static final DBField ASSESSOR_ID = new DBField(DBDataType.STRING , "assessor_id","assessorId","考核人","考核人",false,false,true);
		
		/**
		 * 二级考核人
		*/
		public static final DBField ASSESSOR_SECOND_ID = new DBField(DBDataType.STRING , "assessor_second_id","assessorSecondId","二级考核人","二级考核人",false,false,true);
		
		/**
		 * 指标总权重（%）
		*/
		public static final DBField TOTAL_WEIGHT = new DBField(DBDataType.DECIMAL , "total_weight","totalWeight","指标总权重","%）",false,false,true);
		
		/**
		 * 考勤模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","考勤模版","考勤模版",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_PLAN() {
			this.init($NAME,"考核计划" , ID , STATUS , BUSINESS_CODE , NAME , POS_ID , CYCLE , METHOD , ASSESSEE_ID , ASSESSOR_ID , ASSESSOR_SECOND_ID , TOTAL_WEIGHT , TPL_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_PLAN $TABLE=new HR_ASSESSMENT_PLAN();
	}
	
	/**
	 * 考核任务
	*/
	public static class HR_ASSESSMENT_TASK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_task";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER = new DBField(DBDataType.STRING , "owner","owner","所属","所属",false,false,true);
		
		/**
		 * 考核状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","考核状态","考核状态",false,false,true);
		
		/**
		 * 考核名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","考核名称","考核名称",false,false,true);
		
		/**
		 * 岗位
		*/
		public static final DBField POS_ID = new DBField(DBDataType.STRING , "pos_id","posId","岗位","岗位",false,false,true);
		
		/**
		 * 周期
		*/
		public static final DBField CYCLE = new DBField(DBDataType.STRING , "cycle","cycle","周期","周期",false,false,true);
		
		/**
		 * 全部人员
		*/
		public static final DBField IS_ALL_PERSON = new DBField(DBDataType.STRING , "is_all_person","isAllPerson","全部人员","全部人员",false,false,true);
		
		/**
		 * 同级评分人
		*/
		public static final DBField SAME_LEVEL_USER_ID = new DBField(DBDataType.STRING , "same_level_user_id","sameLevelUserId","同级评分人","同级评分人",false,false,true);
		
		/**
		 * 考核方式
		*/
		public static final DBField ASSESSMEN_METHOD = new DBField(DBDataType.STRING , "assessmen_method","assessmenMethod","考核方式","考核方式",false,false,true);
		
		/**
		 * 指标总权重（%）
		*/
		public static final DBField TOTAL_WEIGHT = new DBField(DBDataType.DECIMAL , "total_weight","totalWeight","指标总权重","%）",false,false,true);
		
		/**
		 * 自评
		*/
		public static final DBField HAS_SELF_ASSESSMENT = new DBField(DBDataType.STRING , "has_self_assessment","hasSelfAssessment","自评","自评",false,false,true);
		
		/**
		 * 同级评分
		*/
		public static final DBField HAS_SAME_ASSESSMENT = new DBField(DBDataType.STRING , "has_same_assessment","hasSameAssessment","同级评分","同级评分",false,false,true);
		
		/**
		 * 直接领导评分
		*/
		public static final DBField HAS_LEADER_ASSESSMENT = new DBField(DBDataType.STRING , "has_leader_assessment","hasLeaderAssessment","直接领导评分","直接领导评分",false,false,true);
		
		/**
		 * 领导评分
		*/
		public static final DBField HAS_SECOND_LEADER_ASSESSMENT = new DBField(DBDataType.STRING , "has_second_leader_assessment","hasSecondLeaderAssessment","领导评分","领导评分",false,false,true);
		
		/**
		 * HR复核
		*/
		public static final DBField HAS_HR_CONFIRM = new DBField(DBDataType.STRING , "has_hr_confirm","hasHrConfirm","HR复核","HR复核",false,false,true);
		
		/**
		 * 绩效模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","绩效模版","绩效模版",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","来源",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_TASK() {
			this.init($NAME,"考核任务" , ID , OWNER , STATUS , NAME , POS_ID , CYCLE , IS_ALL_PERSON , SAME_LEVEL_USER_ID , ASSESSMEN_METHOD , TOTAL_WEIGHT , HAS_SELF_ASSESSMENT , HAS_SAME_ASSESSMENT , HAS_LEADER_ASSESSMENT , HAS_SECOND_LEADER_ASSESSMENT , HAS_HR_CONFIRM , TPL_ID , SOURCE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_TASK $TABLE=new HR_ASSESSMENT_TASK();
	}
	
	/**
	 * 考核任务单
	*/
	public static class HR_ASSESSMENT_TASK_DTL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_task_dtl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 任务
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","任务","任务",false,false,true);
		
		/**
		 * 单据
		*/
		public static final DBField BILL_ID = new DBField(DBDataType.STRING , "bill_id","billId","单据","单据",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 被考核人
		*/
		public static final DBField ASSESSEE_ID = new DBField(DBDataType.STRING , "assessee_id","assesseeId","被考核人","被考核人",false,false,true);
		
		/**
		 * 考核人
		*/
		public static final DBField ASSESSOR_ID = new DBField(DBDataType.STRING , "assessor_id","assessorId","考核人","考核人",false,false,true);
		
		/**
		 * 得分
		*/
		public static final DBField SCORE_VALUE = new DBField(DBDataType.DECIMAL , "score_value","scoreValue","得分","得分",false,false,true);
		
		/**
		 * 综合评价
		*/
		public static final DBField EVALUATE_CONTENT = new DBField(DBDataType.STRING , "evaluate_content","evaluateContent","综合评价","综合评价",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField RCD_TIME = new DBField(DBDataType.DATE , "rcd_time","rcdTime","操作时间","操作时间",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_TASK_DTL() {
			this.init($NAME,"考核任务单" , ID , TASK_ID , BILL_ID , NAME , STATUS , ASSESSEE_ID , ASSESSOR_ID , SCORE_VALUE , EVALUATE_CONTENT , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_TASK_DTL $TABLE=new HR_ASSESSMENT_TASK_DTL();
	}
	
	/**
	 * 考核模版
	*/
	public static class HR_ASSESSMENT_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_tpl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模版名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","模版名称","模版名称",false,false,true);
		
		/**
		 * 部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","部门","部门",false,false,true);
		
		/**
		 * 指标总权重（%）
		*/
		public static final DBField TOTAL_WEIGHT = new DBField(DBDataType.DECIMAL , "total_weight","totalWeight","指标总权重","%）",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_TPL() {
			this.init($NAME,"考核模版" , ID , NAME , ORG_ID , TOTAL_WEIGHT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_TPL $TABLE=new HR_ASSESSMENT_TPL();
	}
	
	/**
	 * 考勤汇总
	*/
	public static class HR_ATTENDANCE_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 考勤组
		*/
		public static final DBField ATTENDANCE_TPL_CODE = new DBField(DBDataType.STRING , "attendance_tpl_code","attendanceTplCode","考勤组","考勤组",false,false,true);
		
		/**
		 * 是否工作日
		*/
		public static final DBField IS_WORK_DAY = new DBField(DBDataType.STRING , "is_work_day","isWorkDay","是否工作日","是否工作日",false,false,true);
		
		/**
		 * 考勤日期
		*/
		public static final DBField ATTENDANCE_DATE = new DBField(DBDataType.DATE , "attendance_date","attendanceDate","考勤日期","考勤日期",false,false,true);
		
		/**
		 * 考勤日期
		*/
		public static final DBField ATTENDANCE_DATE_STR = new DBField(DBDataType.STRING , "attendance_date_str","attendanceDateStr","考勤日期","考勤日期",false,false,true);
		
		/**
		 * 结果
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","结果","结果",false,false,true);
		
		/**
		 * 上班天数
		*/
		public static final DBField NORMAL_DAY = new DBField(DBDataType.DECIMAL , "normal_day","normalDay","上班天数","上班天数",false,false,true);
		
		/**
		 * 应上班天数
		*/
		public static final DBField NEED_DAY = new DBField(DBDataType.DECIMAL , "need_day","needDay","应上班天数","应上班天数",false,false,true);
		
		/**
		 * 上班打卡
		*/
		public static final DBField ON_WORK_TIME = new DBField(DBDataType.DATE , "on_work_time","onWorkTime","上班打卡","上班打卡",false,false,true);
		
		/**
		 * 最早打卡
		*/
		public static final DBField ON_WORK_TIME2 = new DBField(DBDataType.DATE , "on_work_time2","onWorkTime2","最早打卡","最早打卡",false,false,true);
		
		/**
		 * 下班打卡
		*/
		public static final DBField OFF_WORK_TIME = new DBField(DBDataType.DATE , "off_work_time","offWorkTime","下班打卡","下班打卡",false,false,true);
		
		/**
		 * 最晚打卡
		*/
		public static final DBField OFF_WORK_TIME2 = new DBField(DBDataType.DATE , "off_work_time2","offWorkTime2","最晚打卡","最晚打卡",false,false,true);
		
		/**
		 * 迟到(次)
		*/
		public static final DBField LEAVE_EARLY = new DBField(DBDataType.INTEGER , "leave_early","leaveEarly","迟到","次)",false,false,true);
		
		/**
		 * 迟到(分)
		*/
		public static final DBField LEAVE_EARLY_TIME = new DBField(DBDataType.DECIMAL , "leave_early_time","leaveEarlyTime","迟到","分)",false,false,true);
		
		/**
		 * 早退(次)
		*/
		public static final DBField LEAVE_LATE = new DBField(DBDataType.INTEGER , "leave_late","leaveLate","早退","次)",false,false,true);
		
		/**
		 * 早退(分)
		*/
		public static final DBField LEAVE_LATE_TIME = new DBField(DBDataType.DECIMAL , "leave_late_time","leaveLateTime","早退","分)",false,false,true);
		
		/**
		 * 上班缺卡(次)
		*/
		public static final DBField LOSS_EARLY = new DBField(DBDataType.INTEGER , "loss_early","lossEarly","上班缺卡","次)",false,false,true);
		
		/**
		 * 下班却卡(次)
		*/
		public static final DBField LOSS_LATE = new DBField(DBDataType.INTEGER , "loss_late","lossLate","下班却卡","次)",false,false,true);
		
		/**
		 * 缺卡处理(次)
		*/
		public static final DBField LOSS_PROCESS = new DBField(DBDataType.INTEGER , "loss_process","lossProcess","缺卡处理","次)",false,false,true);
		
		/**
		 * 工作日加班(小时)
		*/
		public static final DBField JB_GZR = new DBField(DBDataType.DECIMAL , "jb_gzr","jbGzr","工作日加班","小时)",false,false,true);
		
		/**
		 * 休息日加班(小时)
		*/
		public static final DBField JB_XXR = new DBField(DBDataType.DECIMAL , "jb_xxr","jbXxr","休息日加班","小时)",false,false,true);
		
		/**
		 * 节假日加班(小时)
		*/
		public static final DBField JB_JJR = new DBField(DBDataType.DECIMAL , "jb_jjr","jbJjr","节假日加班","小时)",false,false,true);
		
		/**
		 * 出差(天)
		*/
		public static final DBField CC = new DBField(DBDataType.DECIMAL , "cc","cc","出差","天)",false,false,true);
		
		/**
		 * 年假(天)
		*/
		public static final DBField QJ_NJ = new DBField(DBDataType.DECIMAL , "qj_nj","qjNj","年假","天)",false,false,true);
		
		/**
		 * 工伤假(天)
		*/
		public static final DBField QJ_GSJ = new DBField(DBDataType.DECIMAL , "qj_gsj","qjGsj","工伤假","天)",false,false,true);
		
		/**
		 * 产假(天)
		*/
		public static final DBField QJ_CJ = new DBField(DBDataType.DECIMAL , "qj_cj","qjCj","产假","天)",false,false,true);
		
		/**
		 * 婚假(天)
		*/
		public static final DBField QJ_HJ = new DBField(DBDataType.DECIMAL , "qj_hj","qjHj","婚假","天)",false,false,true);
		
		/**
		 * 病假(天)
		*/
		public static final DBField QJ_BJ = new DBField(DBDataType.DECIMAL , "qj_bj","qjBj","病假","天)",false,false,true);
		
		/**
		 * 事假(天)
		*/
		public static final DBField QJ_SJ = new DBField(DBDataType.DECIMAL , "qj_sj","qjSj","事假","天)",false,false,true);
		
		/**
		 * 调休假(天)
		*/
		public static final DBField QJ_TXJ = new DBField(DBDataType.DECIMAL , "qj_txj","qjTxj","调休假","天)",false,false,true);
		
		/**
		 * 哺乳假(天)
		*/
		public static final DBField QJ_PLJ = new DBField(DBDataType.DECIMAL , "qj_plj","qjPlj","哺乳假","天)",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 关联
		*/
		public static final DBField REL_ID = new DBField(DBDataType.STRING , "rel_id","relId","关联","关联",false,false,true);
		
		/**
		 * 说明
		*/
		public static final DBField DAY_INFO = new DBField(DBDataType.STRING , "day_info","dayInfo","说明","说明",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_DATA() {
			this.init($NAME,"考勤汇总" , ID , PERSON_ID , ATTENDANCE_TPL_CODE , IS_WORK_DAY , ATTENDANCE_DATE , ATTENDANCE_DATE_STR , RESULT , NORMAL_DAY , NEED_DAY , ON_WORK_TIME , ON_WORK_TIME2 , OFF_WORK_TIME , OFF_WORK_TIME2 , LEAVE_EARLY , LEAVE_EARLY_TIME , LEAVE_LATE , LEAVE_LATE_TIME , LOSS_EARLY , LOSS_LATE , LOSS_PROCESS , JB_GZR , JB_XXR , JB_JJR , CC , QJ_NJ , QJ_GSJ , QJ_CJ , QJ_HJ , QJ_BJ , QJ_SJ , QJ_TXJ , QJ_PLJ , BATCH_CODE , NOTES , REL_ID , DAY_INFO , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_DATA $TABLE=new HR_ATTENDANCE_DATA();
	}
	
	/**
	 * 处理记录
	*/
	public static class HR_ATTENDANCE_DATA_PROCESS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_data_process";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 考勤日期
		*/
		public static final DBField KQ_RQ = new DBField(DBDataType.DATE , "kq_rq","kqRq","考勤日期","考勤日期",false,false,true);
		
		/**
		 * 处理时间
		*/
		public static final DBField PROCESS_DATE = new DBField(DBDataType.DATE , "process_date","processDate","处理时间","处理时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HR_ATTENDANCE_DATA_PROCESS() {
			this.init($NAME,"处理记录" , ID , STATUS , PERSON_ID , KQ_RQ , PROCESS_DATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_ATTENDANCE_DATA_PROCESS $TABLE=new HR_ATTENDANCE_DATA_PROCESS();
	}
	
	/**
	 * 考勤日期
	*/
	public static class HR_ATTENDANCE_DATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_date";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 年份
		*/
		public static final DBField YEAR = new DBField(DBDataType.STRING , "year","year","年份","年份",false,false,true);
		
		/**
		 * 日期
		*/
		public static final DBField DATE_STR = new DBField(DBDataType.STRING , "date_str","dateStr","日期","日期",false,false,true);
		
		/**
		 * 周
		*/
		public static final DBField WEEK = new DBField(DBDataType.STRING , "week","week","周","周",false,false,true);
		
		/**
		 * 法定假日
		*/
		public static final DBField STATUTORY_HOLIDAY = new DBField(DBDataType.STRING , "statutory_holiday","statutoryHoliday","法定假日","法定假日",false,false,true);
		
		/**
		 * 节日
		*/
		public static final DBField HOLIDAY = new DBField(DBDataType.STRING , "holiday","holiday","节日","节日",false,false,true);
		
		/**
		 * 考勤签到
		*/
		public static final DBField ATTENDANC_SIGN = new DBField(DBDataType.STRING , "attendanc_sign","attendancSign","考勤签到","考勤签到",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_DATE() {
			this.init($NAME,"考勤日期" , ID , YEAR , DATE_STR , WEEK , STATUTORY_HOLIDAY , HOLIDAY , ATTENDANC_SIGN , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_DATE $TABLE=new HR_ATTENDANCE_DATE();
	}
	
	/**
	 * 休假管理
	*/
	public static class HR_ATTENDANCE_HOLIDAY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_holiday";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 休假类型
		*/
		public static final DBField ACTION_TYPE = new DBField(DBDataType.STRING , "action_type","actionType","休假类型","休假类型",false,false,true);
		
		/**
		 * 休假日期
		*/
		public static final DBField ACTION_DATE = new DBField(DBDataType.DATE , "action_date","actionDate","休假日期","休假日期",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField ACTION_S_TIME = new DBField(DBDataType.DATE , "action_s_time","actionSTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField ACTION_E_TIME = new DBField(DBDataType.DATE , "action_e_time","actionETime","结束时间","结束时间",false,false,true);
		
		/**
		 * 休假天数
		*/
		public static final DBField ACTION_DAYS = new DBField(DBDataType.DECIMAL , "action_days","actionDays","休假天数","休假天数",false,false,true);
		
		/**
		 * 休假备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","休假备注","休假备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_HOLIDAY() {
			this.init($NAME,"休假管理" , ID , PERSON_ID , ACTION_TYPE , ACTION_DATE , ACTION_S_TIME , ACTION_E_TIME , ACTION_DAYS , NOTES , FILE_ID , BATCH_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_HOLIDAY $TABLE=new HR_ATTENDANCE_HOLIDAY();
	}
	
	/**
	 * 出差管理
	*/
	public static class HR_ATTENDANCE_OFFICIAL_BUSI extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_official_busi";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 出差类型
		*/
		public static final DBField ACTION_TYPE = new DBField(DBDataType.STRING , "action_type","actionType","出差类型","出差类型",false,false,true);
		
		/**
		 * 出差日期
		*/
		public static final DBField ACTION_DATE = new DBField(DBDataType.DATE , "action_date","actionDate","出差日期","出差日期",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField ACTION_S_TIME = new DBField(DBDataType.DATE , "action_s_time","actionSTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField ACTION_E_TIME = new DBField(DBDataType.DATE , "action_e_time","actionETime","结束时间","结束时间",false,false,true);
		
		/**
		 * 出差天数
		*/
		public static final DBField ACTION_DAYS = new DBField(DBDataType.DECIMAL , "action_days","actionDays","出差天数","出差天数",false,false,true);
		
		/**
		 * 出差备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","出差备注","出差备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_OFFICIAL_BUSI() {
			this.init($NAME,"出差管理" , ID , PERSON_ID , ACTION_TYPE , ACTION_DATE , ACTION_S_TIME , ACTION_E_TIME , ACTION_DAYS , NOTES , FILE_ID , BATCH_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_OFFICIAL_BUSI $TABLE=new HR_ATTENDANCE_OFFICIAL_BUSI();
	}
	
	/**
	 * 加班管理
	*/
	public static class HR_ATTENDANCE_OVERTIME extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_overtime";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 加班日期
		*/
		public static final DBField ACTION_DATE = new DBField(DBDataType.DATE , "action_date","actionDate","加班日期","加班日期",false,false,true);
		
		/**
		 * 加班类型
		*/
		public static final DBField ACTION_TYPE = new DBField(DBDataType.STRING , "action_type","actionType","加班类型","加班类型",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField ACTION_S_TIME = new DBField(DBDataType.DATE , "action_s_time","actionSTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField ACTION_E_TIME = new DBField(DBDataType.DATE , "action_e_time","actionETime","结束时间","结束时间",false,false,true);
		
		/**
		 * 加班小时
		*/
		public static final DBField ACTION_HOUR = new DBField(DBDataType.DECIMAL , "action_hour","actionHour","加班小时","加班小时",false,false,true);
		
		/**
		 * 加班备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","加班备注","加班备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_OVERTIME() {
			this.init($NAME,"加班管理" , ID , PERSON_ID , ACTION_DATE , ACTION_TYPE , ACTION_S_TIME , ACTION_E_TIME , ACTION_HOUR , NOTES , FILE_ID , BATCH_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_OVERTIME $TABLE=new HR_ATTENDANCE_OVERTIME();
	}
	
	/**
	 * 考勤跑批
	*/
	public static class HR_ATTENDANCE_PROCESS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_process";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 所有人员
		*/
		public static final DBField IS_ALL_PERSON = new DBField(DBDataType.STRING , "is_all_person","isAllPerson","所有人员","所有人员",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField SDATE = new DBField(DBDataType.DATE , "sdate","sdate","开始时间","开始时间",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField EDATE = new DBField(DBDataType.DATE , "edate","edate","开始时间","开始时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_PROCESS() {
			this.init($NAME,"考勤跑批" , ID , NAME , IS_ALL_PERSON , SDATE , EDATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_PROCESS $TABLE=new HR_ATTENDANCE_PROCESS();
	}
	
	/**
	 * 考勤原始记录
	*/
	public static class HR_ATTENDANCE_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 打卡时间
		*/
		public static final DBField RCD_TIME = new DBField(DBDataType.DATE , "rcd_time","rcdTime","打卡时间","打卡时间",false,false,true);
		
		/**
		 * 打卡位置
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","打卡位置","打卡位置",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","来源",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 处理状态
		*/
		public static final DBField PROCESS_STATUS = new DBField(DBDataType.STRING , "process_status","processStatus","处理状态","处理状态",false,false,true);
		
		/**
		 * 处理时间
		*/
		public static final DBField PROCESS_TIME = new DBField(DBDataType.DATE , "process_time","processTime","处理时间","处理时间",false,false,true);
		
		/**
		 * 处理结果
		*/
		public static final DBField PROCESS_RESULT = new DBField(DBDataType.STRING , "process_result","processResult","处理结果","处理结果",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_RECORD() {
			this.init($NAME,"考勤原始记录" , ID , PERSON_ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , RCD_TIME , ADDRESS , SOURCE , BATCH_CODE , PROCESS_STATUS , PROCESS_TIME , PROCESS_RESULT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_RECORD $TABLE=new HR_ATTENDANCE_RECORD();
	}
	
	/**
	 * 考勤导入
	*/
	public static class HR_ATTENDANCE_RECORD_IMPORT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_record_import";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","人员","人员",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_RECORD_IMPORT() {
			this.init($NAME,"考勤导入" , ID , SOURCE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_RECORD_IMPORT $TABLE=new HR_ATTENDANCE_RECORD_IMPORT();
	}
	
	/**
	 * 考勤模版
	*/
	public static class HR_ATTENDANCE_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_tpl";
		
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
		 * 类型
		*/
		public static final DBField TPL_TYPE = new DBField(DBDataType.STRING , "tpl_type","tplType","类型","类型",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_TPL() {
			this.init($NAME,"考勤模版" , ID , CODE , NAME , TPL_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_TPL $TABLE=new HR_ATTENDANCE_TPL();
	}
	
	/**
	 * 考勤组
	*/
	public static class HR_ATTENDANCE_TPL_DTL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_tpl_dtl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","编码","编码",false,false,true);
		
		/**
		 * 周
		*/
		public static final DBField WEEK = new DBField(DBDataType.STRING , "week","week","周","周",false,false,true);
		
		/**
		 * 是否上班
		*/
		public static final DBField IS_WORK_DAY = new DBField(DBDataType.STRING , "is_work_day","isWorkDay","是否上班","是否上班",false,false,true);
		
		/**
		 * 上班类型
		*/
		public static final DBField DAY_TYPE = new DBField(DBDataType.STRING , "day_type","dayType","上班类型","上班类型",false,false,true);
		
		/**
		 * 1天1次
		*/
		public static final DBField FIRST_WORK = new DBField(DBDataType.STRING , "first_work","firstWork","1天1次","1天1次",false,false,true);
		
		/**
		 * 1天2次
		*/
		public static final DBField SECOND_WORK = new DBField(DBDataType.STRING , "second_work","secondWork","1天2次","1天2次",false,false,true);
		
		/**
		 * 临时班次
		*/
		public static final DBField TMP_WORK = new DBField(DBDataType.STRING , "tmp_work","tmpWork","临时班次","临时班次",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HR_ATTENDANCE_TPL_DTL() {
			this.init($NAME,"考勤组" , ID , OWNER_ID , WEEK , IS_WORK_DAY , DAY_TYPE , FIRST_WORK , SECOND_WORK , TMP_WORK , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_ATTENDANCE_TPL_DTL $TABLE=new HR_ATTENDANCE_TPL_DTL();
	}
	
	/**
	 * 考勤班组
	*/
	public static class HR_ATTENDANCE_TPL_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_tpl_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,false);
		
		/**
		 * 上班时间
		*/
		public static final DBField ON_WORK_TIME = new DBField(DBDataType.DATE , "on_work_time","onWorkTime","上班时间","上班时间",false,false,false);
		
		/**
		 * 上班打卡上限
		*/
		public static final DBField ON_WORK_TIME_UP = new DBField(DBDataType.DATE , "on_work_time_up","onWorkTimeUp","上班打卡上限","上班打卡上限",false,false,false);
		
		/**
		 * 上班打卡下限
		*/
		public static final DBField ON_WORK_TIME_DOWN = new DBField(DBDataType.DATE , "on_work_time_down","onWorkTimeDown","上班打卡下限","上班打卡下限",false,false,false);
		
		/**
		 * 下班时间
		*/
		public static final DBField OFF_WORK_TIME = new DBField(DBDataType.DATE , "off_work_time","offWorkTime","下班时间","下班时间",false,false,false);
		
		/**
		 * 下班打卡上限
		*/
		public static final DBField OFF_WORK_TIME_UP = new DBField(DBDataType.DATE , "off_work_time_up","offWorkTimeUp","下班打卡上限","下班打卡上限",false,false,false);
		
		/**
		 * 下班打卡下限
		*/
		public static final DBField OFF_WORK_TIME_DOWN = new DBField(DBDataType.DATE , "off_work_time_down","offWorkTimeDown","下班打卡下限","下班打卡下限",false,false,false);
		
		/**
		 * 上班打卡
		*/
		public static final DBField HALF_WORK_UP = new DBField(DBDataType.STRING , "half_work_up","halfWorkUp","上班打卡","上班打卡",false,false,true);
		
		/**
		 * 下班打卡
		*/
		public static final DBField HALF_WORK_DOWN = new DBField(DBDataType.STRING , "half_work_down","halfWorkDown","下班打卡","下班打卡",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_TPL_GROUP() {
			this.init($NAME,"考勤班组" , ID , NAME , ON_WORK_TIME , ON_WORK_TIME_UP , ON_WORK_TIME_DOWN , OFF_WORK_TIME , OFF_WORK_TIME_UP , OFF_WORK_TIME_DOWN , HALF_WORK_UP , HALF_WORK_DOWN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_TPL_GROUP $TABLE=new HR_ATTENDANCE_TPL_GROUP();
	}
	
	/**
	 * 考勤类型
	*/
	public static class HR_ATTENDANCE_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_type";
		
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
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_ATTENDANCE_TYPE() {
			this.init($NAME,"考勤类型" , ID , CODE , NAME , STATUS , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_TYPE $TABLE=new HR_ATTENDANCE_TYPE();
	}
	
	/**
	 * 年假记录
	*/
	public static class HR_ATTENDANCE_YEAR_DAY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_year_day";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 开始日期
		*/
		public static final DBField SDATE = new DBField(DBDataType.DATE , "sdate","sdate","开始日期","开始日期",false,false,true);
		
		/**
		 * 结束日期
		*/
		public static final DBField EDATE = new DBField(DBDataType.STRING , "edate","edate","结束日期","结束日期",false,false,true);
		
		/**
		 * 本周期
		*/
		public static final DBField DAYS = new DBField(DBDataType.DECIMAL , "days","days","本周期","本周期",false,false,true);
		
		/**
		 * 上一周期
		*/
		public static final DBField LAST_DAYS = new DBField(DBDataType.DECIMAL , "last_days","lastDays","上一周期","上一周期",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
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
		
		public HR_ATTENDANCE_YEAR_DAY() {
			this.init($NAME,"年假记录" , ID , PERSON_ID , SDATE , EDATE , DAYS , LAST_DAYS , NOTES , BATCH_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_YEAR_DAY $TABLE=new HR_ATTENDANCE_YEAR_DAY();
	}
	
	/**
	 * 年假规则
	*/
	public static class HR_ATTENDANCE_YEAR_RULE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_year_rule";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 起始年限
		*/
		public static final DBField START_YEAR = new DBField(DBDataType.DECIMAL , "start_year","startYear","起始年限","起始年限",false,false,true);
		
		/**
		 * 截止年限
		*/
		public static final DBField END_YEAR = new DBField(DBDataType.DECIMAL , "end_year","endYear","截止年限","截止年限",false,false,true);
		
		/**
		 * 年假天数
		*/
		public static final DBField DAYS = new DBField(DBDataType.DECIMAL , "days","days","年假天数","年假天数",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_YEAR_RULE() {
			this.init($NAME,"年假规则" , ID , START_YEAR , END_YEAR , DAYS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_YEAR_RULE $TABLE=new HR_ATTENDANCE_YEAR_RULE();
	}
	
	/**
	 * 人员出差
	*/
	public static class HR_BUSINESS_TRAVEL_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_business_travel_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","时长","时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_BUSINESS_TRAVEL_DATA() {
			this.init($NAME,"人员出差" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_BUSINESS_TRAVEL_DATA $TABLE=new HR_BUSINESS_TRAVEL_DATA();
	}
	
	/**
	 * 证书管理
	*/
	public static class HR_CERTIFICATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_certificate";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 级别
		*/
		public static final DBField CERT_LEVEL = new DBField(DBDataType.STRING , "cert_level","certLevel","级别","级别",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_CERTIFICATE() {
			this.init($NAME,"证书管理" , ID , TYPE , CERT_LEVEL , NAME , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CERTIFICATE $TABLE=new HR_CERTIFICATE();
	}
	
	/**
	 * 证书级别
	*/
	public static class HR_CERTIFICATE_LEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_certificate_level";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
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
		
		public HR_CERTIFICATE_LEVEL() {
			this.init($NAME,"证书级别" , ID , NAME , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CERTIFICATE_LEVEL $TABLE=new HR_CERTIFICATE_LEVEL();
	}
	
	/**
	 * 证书类型
	*/
	public static class HR_CERTIFICATE_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_certificate_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_CERTIFICATE_TYPE() {
			this.init($NAME,"证书类型" , ID , NAME , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CERTIFICATE_TYPE $TABLE=new HR_CERTIFICATE_TYPE();
	}
	
	/**
	 * 合同签订方
	*/
	public static class HR_CONTRACT_ORG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_contract_org";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		
		public HR_CONTRACT_ORG() {
			this.init($NAME,"合同签订方" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CONTRACT_ORG $TABLE=new HR_CONTRACT_ORG();
	}
	
	/**
	 * 人事调动
	*/
	public static class HR_EMPLOYEE_TRANSFER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_employee_transfer";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","员工","员工",false,false,true);
		
		/**
		 * 调出部门
		*/
		public static final DBField FROM_ORG_ID = new DBField(DBDataType.STRING , "from_org_id","fromOrgId","调出部门","调出部门",false,false,true);
		
		/**
		 * 调动日期
		*/
		public static final DBField OPER_DATE = new DBField(DBDataType.DATE , "oper_date","operDate","调动日期","调动日期",false,false,true);
		
		/**
		 * 调入部门
		*/
		public static final DBField IN_ORG_ID = new DBField(DBDataType.STRING , "in_org_id","inOrgId","调入部门","调入部门",false,false,true);
		
		/**
		 * 岗位
		*/
		public static final DBField POS_ID = new DBField(DBDataType.STRING , "pos_id","posId","岗位","岗位",false,false,true);
		
		/**
		 * 说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","说明","说明",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_EMPLOYEE_TRANSFER() {
			this.init($NAME,"人事调动" , ID , STATUS , USER_ID , FROM_ORG_ID , OPER_DATE , IN_ORG_ID , POS_ID , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_EMPLOYEE_TRANSFER $TABLE=new HR_EMPLOYEE_TRANSFER();
	}
	
	/**
	 * 评价关系
	*/
	public static class HR_EVALUATION_RELATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_evaluation_relation";
		
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
		
		public HR_EVALUATION_RELATION() {
			this.init($NAME,"评价关系" , ID , CODE , NAME , STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_EVALUATION_RELATION $TABLE=new HR_EVALUATION_RELATION();
	}
	
	/**
	 * 指标库
	*/
	public static class HR_INDICATOR_LIB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_indicator_lib";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 指标分类
		*/
		public static final DBField TYPE_CODE = new DBField(DBDataType.STRING , "type_code","typeCode","指标分类","指标分类",false,false,true);
		
		/**
		 * 指标名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","指标名称","指标名称",false,false,true);
		
		/**
		 * 定性/定量指标
		*/
		public static final DBField PROPERTY = new DBField(DBDataType.STRING , "property","property","定性/定量指标","定性/定量指标",false,false,true);
		
		/**
		 * 计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","计量单位","计量单位",false,false,true);
		
		/**
		 * 指标定义
		*/
		public static final DBField DEF = new DBField(DBDataType.STRING , "def","def","指标定义","指标定义",false,false,true);
		
		/**
		 * 评分标准
		*/
		public static final DBField SCORING_BASE = new DBField(DBDataType.STRING , "scoring_base","scoringBase","评分标准","评分标准",false,false,true);
		
		/**
		 * 评分依据
		*/
		public static final DBField SCORING_BY = new DBField(DBDataType.STRING , "scoring_by","scoringBy","评分依据","评分依据",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_INDICATOR_LIB() {
			this.init($NAME,"指标库" , ID , TYPE_CODE , NAME , PROPERTY , UNIT , DEF , SCORING_BASE , SCORING_BY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_INDICATOR_LIB $TABLE=new HR_INDICATOR_LIB();
	}
	
	/**
	 * 招聘面试
	*/
	public static class HR_INTERVIEW extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_interview";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 标题
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标题","标题",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 面试日期
		*/
		public static final DBField INTERVIEW_DATE = new DBField(DBDataType.DATE , "interview_date","interviewDate","面试日期","面试日期",false,false,true);
		
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
		 * 登记人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","登记人","登记人",false,false,true);
		
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
		
		public HR_INTERVIEW() {
			this.init($NAME,"招聘面试" , ID , NAME , STATUS , INTERVIEW_DATE , CONTENT , FILE_ID , NOTES , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_INTERVIEW $TABLE=new HR_INTERVIEW();
	}
	
	/**
	 * 考核等级
	*/
	public static class HR_PERFORMANCE_LEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_performance_level";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 等级编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","等级编码","等级编码",false,false,true);
		
		/**
		 * 等级名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","等级名称","等级名称",false,false,true);
		
		/**
		 * 成绩下限
		*/
		public static final DBField LOWER_LIMIT = new DBField(DBDataType.STRING , "lower_limit","lowerLimit","成绩下限","成绩下限",false,false,true);
		
		/**
		 * 成绩上限
		*/
		public static final DBField UPPER_LIMIT = new DBField(DBDataType.STRING , "upper_limit","upperLimit","成绩上限","成绩上限",false,false,true);
		
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
		
		public HR_PERFORMANCE_LEVEL() {
			this.init($NAME,"考核等级" , ID , CODE , NAME , LOWER_LIMIT , UPPER_LIMIT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERFORMANCE_LEVEL $TABLE=new HR_PERFORMANCE_LEVEL();
	}
	
	/**
	 * 考核维护
	*/
	public static class HR_PERFORMANCE_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_performance_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField PERSON_NAME = new DBField(DBDataType.STRING , "person_name","personName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 考核类型
		*/
		public static final DBField PERFORMANCE_TYPE = new DBField(DBDataType.STRING , "performance_type","performanceType","考核类型","考核类型",false,false,true);
		
		/**
		 * 考核期间
		*/
		public static final DBField PERFORMANCE_PERIOD = new DBField(DBDataType.STRING , "performance_period","performancePeriod","考核期间","考核期间",false,false,true);
		
		/**
		 * 考核成绩
		*/
		public static final DBField RESULT = new DBField(DBDataType.DECIMAL , "result","result","考核成绩","考核成绩",false,false,true);
		
		/**
		 * 考核等级
		*/
		public static final DBField PERFORMANCE_LEVEL = new DBField(DBDataType.STRING , "performance_level","performanceLevel","考核等级","考核等级",false,false,true);
		
		/**
		 * 考核时间
		*/
		public static final DBField RCD_DATE = new DBField(DBDataType.DATE , "rcd_date","rcdDate","考核时间","考核时间",false,false,true);
		
		/**
		 * 评价人
		*/
		public static final DBField EVALUATOR = new DBField(DBDataType.STRING , "evaluator","evaluator","评价人","评价人",false,false,true);
		
		/**
		 * 评价人
		*/
		public static final DBField EVALUATOR_ID = new DBField(DBDataType.STRING , "evaluator_id","evaluatorId","评价人","评价人",false,false,true);
		
		/**
		 * 考核评价
		*/
		public static final DBField REVIEW = new DBField(DBDataType.STRING , "review","review","考核评价","考核评价",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
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
		
		public HR_PERFORMANCE_RCD() {
			this.init($NAME,"考核维护" , ID , PERSON_ID , PERSON_NAME , JOB_NUMBER , PERFORMANCE_TYPE , PERFORMANCE_PERIOD , RESULT , PERFORMANCE_LEVEL , RCD_DATE , EVALUATOR , EVALUATOR_ID , REVIEW , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERFORMANCE_RCD $TABLE=new HR_PERFORMANCE_RCD();
	}
	
	/**
	 * 人员信息
	*/
	public static class HR_PERSON extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX_CODE = new DBField(DBDataType.STRING , "sex_code","sexCode","性别","性别",false,false,true);
		
		/**
		 * 出生日期
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","出生日期","出生日期",false,false,true);
		
		/**
		 * 籍贯
		*/
		public static final DBField NATIVE_PLACE_CODE = new DBField(DBDataType.STRING , "native_place_code","nativePlaceCode","籍贯","籍贯",false,false,true);
		
		/**
		 * 民族
		*/
		public static final DBField NATION_CODE = new DBField(DBDataType.STRING , "nation_code","nationCode","民族","民族",false,false,true);
		
		/**
		 * 婚姻状况
		*/
		public static final DBField MARITAL_STATUS = new DBField(DBDataType.STRING , "marital_status","maritalStatus","婚姻状况","婚姻状况",false,false,true);
		
		/**
		 * 员工状态
		*/
		public static final DBField EMPLOYEE_STATUS = new DBField(DBDataType.STRING , "employee_status","employeeStatus","员工状态","员工状态",false,false,true);
		
		/**
		 * 员工标记
		*/
		public static final DBField EMPLOYEE_IDENTITY_STATUS = new DBField(DBDataType.STRING , "employee_identity_status","employeeIdentityStatus","员工标记","员工标记",false,false,true);
		
		/**
		 * 人员类型
		*/
		public static final DBField EMPLOYEE_TYPE_CODE = new DBField(DBDataType.STRING , "employee_type_code","employeeTypeCode","人员类型","人员类型",false,false,true);
		
		/**
		 * 身份证
		*/
		public static final DBField IDENTITY_CARD = new DBField(DBDataType.STRING , "identity_card","identityCard","身份证","身份证",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 电子邮件
		*/
		public static final DBField EMAIL = new DBField(DBDataType.STRING , "email","email","电子邮件","电子邮件",false,false,true);
		
		/**
		 * 紧急联系人
		*/
		public static final DBField EMERGENCY_CONTACT = new DBField(DBDataType.STRING , "emergency_contact","emergencyContact","紧急联系人","紧急联系人",false,false,true);
		
		/**
		 * 紧急人电话
		*/
		public static final DBField EMERGENCY_CONTACT_NO = new DBField(DBDataType.STRING , "emergency_contact_no","emergencyContactNo","紧急人电话","紧急人电话",false,false,true);
		
		/**
		 * 家庭地址
		*/
		public static final DBField HOME_ADDRESS = new DBField(DBDataType.STRING , "home_address","homeAddress","家庭地址","家庭地址",false,false,true);
		
		/**
		 * 微信号
		*/
		public static final DBField WEIXIN_ID = new DBField(DBDataType.STRING , "weixin_id","weixinId","微信号","微信号",false,false,true);
		
		/**
		 * 学历
		*/
		public static final DBField EDUCATION_CODE = new DBField(DBDataType.STRING , "education_code","educationCode","学历","学历",false,false,true);
		
		/**
		 * 毕业院校
		*/
		public static final DBField GRADUATION_SCHOOL = new DBField(DBDataType.STRING , "graduation_school","graduationSchool","毕业院校","毕业院校",false,false,true);
		
		/**
		 * 所学专业
		*/
		public static final DBField MAJOR = new DBField(DBDataType.STRING , "major","major","所学专业","所学专业",false,false,true);
		
		/**
		 * 毕业时间
		*/
		public static final DBField GRADUATION_DATE = new DBField(DBDataType.DATE , "graduation_date","graduationDate","毕业时间","毕业时间",false,false,true);
		
		/**
		 * 所学外语
		*/
		public static final DBField FOREIGN_LANGUAGE = new DBField(DBDataType.STRING , "foreign_language","foreignLanguage","所学外语","所学外语",false,false,true);
		
		/**
		 * 外语证书
		*/
		public static final DBField FOREIGN_LANGUAGE_LEVEL = new DBField(DBDataType.STRING , "foreign_language_level","foreignLanguageLevel","外语证书","外语证书",false,false,true);
		
		/**
		 * 计算机能力
		*/
		public static final DBField COMPUTER_ABILITY = new DBField(DBDataType.STRING , "computer_ability","computerAbility","计算机能力","计算机能力",false,false,true);
		
		/**
		 * 计算机等级
		*/
		public static final DBField COMPUTER_LEVEL = new DBField(DBDataType.STRING , "computer_level","computerLevel","计算机等级","计算机等级",false,false,true);
		
		/**
		 * 政治面貌
		*/
		public static final DBField POLITIC_COUNTENANCE_CODE = new DBField(DBDataType.STRING , "politic_countenance_code","politicCountenanceCode","政治面貌","政治面貌",false,false,true);
		
		/**
		 * 入党时间
		*/
		public static final DBField JOIN_PART_DATE = new DBField(DBDataType.DATE , "join_part_date","joinPartDate","入党时间","入党时间",false,false,true);
		
		/**
		 * 血型
		*/
		public static final DBField BLOOD_TYPE = new DBField(DBDataType.STRING , "blood_type","bloodType","血型","血型",false,false,true);
		
		/**
		 * 身高
		*/
		public static final DBField BODY_HEIGHT = new DBField(DBDataType.INTEGER , "body_height","bodyHeight","身高","身高",false,false,true);
		
		/**
		 * 体重
		*/
		public static final DBField BODY_WEIGHT = new DBField(DBDataType.INTEGER , "body_weight","bodyWeight","体重","体重",false,false,true);
		
		/**
		 * 入职日期
		*/
		public static final DBField EMPLOYMENT_DATE = new DBField(DBDataType.DATE , "employment_date","employmentDate","入职日期","入职日期",false,false,true);
		
		/**
		 * 转正日期
		*/
		public static final DBField EMPLOYMENT_CONFIRM_DATE = new DBField(DBDataType.DATE , "employment_confirm_date","employmentConfirmDate","转正日期","转正日期",false,false,true);
		
		/**
		 * 初次日期
		*/
		public static final DBField FIRST_EMPLOYMENT_DATE = new DBField(DBDataType.DATE , "first_employment_date","firstEmploymentDate","初次日期","初次日期",false,false,true);
		
		/**
		 * 参加工作时间
		*/
		public static final DBField FIRST_WORK_DATE = new DBField(DBDataType.DATE , "first_work_date","firstWorkDate","参加工作时间","参加工作时间",false,false,true);
		
		/**
		 * 员工部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","员工部门","员工部门",false,false,true);
		
		/**
		 * 员工岗位
		*/
		public static final DBField POSITION_CODE = new DBField(DBDataType.STRING , "position_code","positionCode","员工岗位","员工岗位",false,false,true);
		
		/**
		 * 员工职称
		*/
		public static final DBField EMPLOYEE_TITLE_CODE = new DBField(DBDataType.STRING , "employee_title_code","employeeTitleCode","员工职称","员工职称",false,false,true);
		
		/**
		 * 员工职级
		*/
		public static final DBField RANK_CODE = new DBField(DBDataType.STRING , "rank_code","rankCode","员工职级","员工职级",false,false,true);
		
		/**
		 * 员工工种
		*/
		public static final DBField WORK_KIND_CODE = new DBField(DBDataType.STRING , "work_kind_code","workKindCode","员工工种","员工工种",false,false,true);
		
		/**
		 * 离职日期
		*/
		public static final DBField LEAVE_DATE = new DBField(DBDataType.DATE , "leave_date","leaveDate","离职日期","离职日期",false,false,true);
		
		/**
		 * 离职原因
		*/
		public static final DBField LEAVE_RESON = new DBField(DBDataType.STRING , "leave_reson","leaveReson","离职原因","离职原因",false,false,true);
		
		/**
		 * 工资卡开户行
		*/
		public static final DBField PAYROLL_CARD_BANK_CODE = new DBField(DBDataType.STRING , "payroll_card_bank_code","payrollCardBankCode","工资卡开户行","工资卡开户行",false,false,true);
		
		/**
		 * 工资卡帐号
		*/
		public static final DBField PAYROLL_CARD = new DBField(DBDataType.STRING , "payroll_card","payrollCard","工资卡帐号","工资卡帐号",false,false,true);
		
		/**
		 * 薪酬模版
		*/
		public static final DBField SALARY_TPL_ID = new DBField(DBDataType.STRING , "salary_tpl_id","salaryTplId","薪酬模版","薪酬模版",false,false,true);
		
		/**
		 * 是否发放
		*/
		public static final DBField SALARY_PAY_OUT = new DBField(DBDataType.STRING , "salary_pay_out","salaryPayOut","是否发放","是否发放",false,false,true);
		
		/**
		 * 薪酬备注
		*/
		public static final DBField SALARY_NOTES = new DBField(DBDataType.STRING , "salary_notes","salaryNotes","薪酬备注","薪酬备注",false,false,true);
		
		/**
		 * 照片
		*/
		public static final DBField PERSON_PICTURE_ID = new DBField(DBDataType.STRING , "person_picture_id","personPictureId","照片","照片",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工","员工",false,false,true);
		
		/**
		 * 直属领导
		*/
		public static final DBField LEADER_USER_ID = new DBField(DBDataType.STRING , "leader_user_id","leaderUserId","直属领导","直属领导",false,false,true);
		
		/**
		 * 分管领导
		*/
		public static final DBField SUPERVISOR_USER_ID = new DBField(DBDataType.STRING , "supervisor_user_id","supervisorUserId","分管领导","分管领导",false,false,true);
		
		/**
		 * HR管理
		*/
		public static final DBField HR_USER_ID = new DBField(DBDataType.STRING , "hr_user_id","hrUserId","HR管理","HR管理",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 合同周期
		*/
		public static final DBField CONTRACT_DURATION = new DBField(DBDataType.STRING , "contract_duration","contractDuration","合同周期","合同周期",false,false,true);
		
		/**
		 * 合同开始时间
		*/
		public static final DBField CONTRACT_START_DATE = new DBField(DBDataType.DATE , "contract_start_date","contractStartDate","合同开始时间","合同开始时间",false,false,true);
		
		/**
		 * 合同结束时间
		*/
		public static final DBField CONTRACT_FINISH_DATE = new DBField(DBDataType.DATE , "contract_finish_date","contractFinishDate","合同结束时间","合同结束时间",false,false,true);
		
		/**
		 * 积分
		*/
		public static final DBField SCORE = new DBField(DBDataType.INTEGER , "score","score","积分","积分",false,false,true);
		
		/**
		 * 年假天数
		*/
		public static final DBField YEAR_DAYS = new DBField(DBDataType.DECIMAL , "year_days","yearDays","年假天数","年假天数",false,false,true);
		
		/**
		 * 考勤组
		*/
		public static final DBField ATTENDANCE_TPL_CODE = new DBField(DBDataType.STRING , "attendance_tpl_code","attendanceTplCode","考勤组","考勤组",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_PERSON() {
			this.init($NAME,"人员信息" , ID , JOB_NUMBER , NAME , SEX_CODE , BIRTHDAY , NATIVE_PLACE_CODE , NATION_CODE , MARITAL_STATUS , EMPLOYEE_STATUS , EMPLOYEE_IDENTITY_STATUS , EMPLOYEE_TYPE_CODE , IDENTITY_CARD , CONTACT_INFORMATION , EMAIL , EMERGENCY_CONTACT , EMERGENCY_CONTACT_NO , HOME_ADDRESS , WEIXIN_ID , EDUCATION_CODE , GRADUATION_SCHOOL , MAJOR , GRADUATION_DATE , FOREIGN_LANGUAGE , FOREIGN_LANGUAGE_LEVEL , COMPUTER_ABILITY , COMPUTER_LEVEL , POLITIC_COUNTENANCE_CODE , JOIN_PART_DATE , BLOOD_TYPE , BODY_HEIGHT , BODY_WEIGHT , EMPLOYMENT_DATE , EMPLOYMENT_CONFIRM_DATE , FIRST_EMPLOYMENT_DATE , FIRST_WORK_DATE , ORG_ID , POSITION_CODE , EMPLOYEE_TITLE_CODE , RANK_CODE , WORK_KIND_CODE , LEAVE_DATE , LEAVE_RESON , PAYROLL_CARD_BANK_CODE , PAYROLL_CARD , SALARY_TPL_ID , SALARY_PAY_OUT , SALARY_NOTES , PERSON_PICTURE_ID , EMPLOYEE_ID , LEADER_USER_ID , SUPERVISOR_USER_ID , HR_USER_ID , FILE_ID , CONTRACT_DURATION , CONTRACT_START_DATE , CONTRACT_FINISH_DATE , SCORE , YEAR_DAYS , ATTENDANCE_TPL_CODE , BATCH_CODE , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON $TABLE=new HR_PERSON();
	}
	
	/**
	 * 请假申请
	*/
	public static class HR_PERSON_ABSENCE_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_absence_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 请假类型
		*/
		public static final DBField APPLY_TYPE = new DBField(DBDataType.STRING , "apply_type","applyType","请假类型","请假类型",false,false,true);
		
		/**
		 * 申请人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","申请人员","申请人员",false,false,true);
		
		/**
		 * 开始日期
		*/
		public static final DBField APPLY_S_DATE = new DBField(DBDataType.DATE , "apply_s_date","applySDate","开始日期","开始日期",false,false,true);
		
		/**
		 * 结束日期
		*/
		public static final DBField APPLY_E_DATE = new DBField(DBDataType.DATE , "apply_e_date","applyEDate","结束日期","结束日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
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
		
		public HR_PERSON_ABSENCE_APPLY() {
			this.init($NAME,"请假申请" , ID , BUSINESS_CODE , STATUS , APPLY_TYPE , PERSON_ID , APPLY_S_DATE , APPLY_E_DATE , CONTENT , FILE_IDS , NOTE , OPER_USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_ABSENCE_APPLY $TABLE=new HR_PERSON_ABSENCE_APPLY();
	}
	
	/**
	 * 审批记录
	*/
	public static class HR_PERSON_APPROVAL_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_approval_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 信息
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","信息","信息",false,false,true);
		
		/**
		 * 结果
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","结果","结果",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 操作人员
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人员","操作人员",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField OPER_TIME = new DBField(DBDataType.DATE , "oper_time","operTime","操作时间","操作时间",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON_APPROVAL_RCD() {
			this.init($NAME,"审批记录" , ID , PID , RESULT , CONTENT , OPER_USER_ID , TYPE , OPER_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_APPROVAL_RCD $TABLE=new HR_PERSON_APPROVAL_RCD();
	}
	
	/**
	 * 人员考勤
	*/
	public static class HR_PERSON_ATTENDANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_attendance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 加班时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","加班时长","加班时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON_ATTENDANCE() {
			this.init($NAME,"人员考勤" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_ATTENDANCE $TABLE=new HR_PERSON_ATTENDANCE();
	}
	
	/**
	 * 人员费用
	*/
	public static class HR_PERSON_ATTENDANCE_MONEY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_attendance_money";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 加班费用
		*/
		public static final DBField JB_AMOUNT = new DBField(DBDataType.DECIMAL , "jb_amount","jbAmount","加班费用","加班费用",false,false,true);
		
		/**
		 * 年假费用
		*/
		public static final DBField NJ_AMOUNT = new DBField(DBDataType.DECIMAL , "nj_amount","njAmount","年假费用","年假费用",false,false,true);
		
		/**
		 * 事假费用
		*/
		public static final DBField SJ_AMOUNT = new DBField(DBDataType.DECIMAL , "sj_amount","sjAmount","事假费用","事假费用",false,false,true);
		
		/**
		 * 病假费用
		*/
		public static final DBField BJ_AMOUNT = new DBField(DBDataType.DECIMAL , "bj_amount","bjAmount","病假费用","病假费用",false,false,true);
		
		/**
		 * 其他假费用
		*/
		public static final DBField OTHER_AMOUNT = new DBField(DBDataType.DECIMAL , "other_amount","otherAmount","其他假费用","其他假费用",false,false,true);
		
		/**
		 * 出差费用
		*/
		public static final DBField CC_AMOUNT = new DBField(DBDataType.DECIMAL , "cc_amount","ccAmount","出差费用","出差费用",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON_ATTENDANCE_MONEY() {
			this.init($NAME,"人员费用" , ID , PERSON_ID , JB_AMOUNT , NJ_AMOUNT , SJ_AMOUNT , BJ_AMOUNT , OTHER_AMOUNT , CC_AMOUNT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_ATTENDANCE_MONEY $TABLE=new HR_PERSON_ATTENDANCE_MONEY();
	}
	
	/**
	 * 人员考勤
	*/
	public static class HR_PERSON_ATTENDANCE_REC extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_attendance_rec";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 员工
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工","员工",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 加班(小时)
		*/
		public static final DBField JB_CNT = new DBField(DBDataType.DECIMAL , "jb_cnt","jbCnt","加班","小时)",false,false,true);
		
		/**
		 * 年假(天)
		*/
		public static final DBField NJ_CNT = new DBField(DBDataType.DECIMAL , "nj_cnt","njCnt","年假","天)",false,false,true);
		
		/**
		 * 事假(天)
		*/
		public static final DBField SJ_CNT = new DBField(DBDataType.DECIMAL , "sj_cnt","sjCnt","事假","天)",false,false,true);
		
		/**
		 * 病假(天)
		*/
		public static final DBField BJ_CNT = new DBField(DBDataType.DECIMAL , "bj_cnt","bjCnt","病假","天)",false,false,true);
		
		/**
		 * 出差(天)
		*/
		public static final DBField CC_CNT = new DBField(DBDataType.DECIMAL , "cc_cnt","ccCnt","出差","天)",false,false,true);
		
		/**
		 * 其他假(天)
		*/
		public static final DBField OTHER_CNT = new DBField(DBDataType.DECIMAL , "other_cnt","otherCnt","其他假","天)",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField REC_TIME = new DBField(DBDataType.DATE , "rec_time","recTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","来源",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON_ATTENDANCE_REC() {
			this.init($NAME,"人员考勤" , ID , EMPLOYEE_ID , PERSON_ID , JOB_NUMBER , JB_CNT , NJ_CNT , SJ_CNT , BJ_CNT , CC_CNT , OTHER_CNT , REC_TIME , BATCH_CODE , NOTES , SOURCE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_ATTENDANCE_REC $TABLE=new HR_PERSON_ATTENDANCE_REC();
	}
	
	/**
	 * 商业保险
	*/
	public static class HR_PERSON_BUSI_INSURE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_busi_insure";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","姓名","姓名",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE_CODE = new DBField(DBDataType.STRING , "type_code","typeCode","类型","类型",false,false,true);
		
		/**
		 * 保险单号
		*/
		public static final DBField BILL_CODE = new DBField(DBDataType.STRING , "bill_code","billCode","保险单号","保险单号",false,false,true);
		
		/**
		 * 登记时间
		*/
		public static final DBField RCD_TIME = new DBField(DBDataType.DATE , "rcd_time","rcdTime","登记时间","登记时间",false,false,true);
		
		/**
		 * 保险金额
		*/
		public static final DBField PAY = new DBField(DBDataType.DECIMAL , "pay","pay","保险金额","保险金额",false,false,true);
		
		/**
		 * 个人支付
		*/
		public static final DBField PERSON_PAY = new DBField(DBDataType.DECIMAL , "person_pay","personPay","个人支付","个人支付",false,false,true);
		
		/**
		 * 公司支付
		*/
		public static final DBField COMPANY_PAY = new DBField(DBDataType.DECIMAL , "company_pay","companyPay","公司支付","公司支付",false,false,true);
		
		/**
		 * 生效时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","生效时间","生效时间",false,false,true);
		
		/**
		 * 失效时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","失效时间","失效时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
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
		
		public HR_PERSON_BUSI_INSURE() {
			this.init($NAME,"商业保险" , ID , NAME , PERSON_ID , TYPE_CODE , BILL_CODE , RCD_TIME , PAY , PERSON_PAY , COMPANY_PAY , START_TIME , END_TIME , FILE_IDS , BATCH_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_BUSI_INSURE $TABLE=new HR_PERSON_BUSI_INSURE();
	}
	
	/**
	 * 商业保险类别
	*/
	public static class HR_PERSON_BUSI_INSURE_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_busi_insure_type";
		
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
		 * 保险周期
		*/
		public static final DBField RECYCLE = new DBField(DBDataType.DECIMAL , "recycle","recycle","保险周期","保险周期",false,false,true);
		
		/**
		 * 保险金额
		*/
		public static final DBField MONEY = new DBField(DBDataType.DECIMAL , "money","money","保险金额","保险金额",false,false,true);
		
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
		
		public HR_PERSON_BUSI_INSURE_TYPE() {
			this.init($NAME,"商业保险类别" , ID , CODE , NAME , RECYCLE , MONEY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_BUSI_INSURE_TYPE $TABLE=new HR_PERSON_BUSI_INSURE_TYPE();
	}
	
	/**
	 * 人员证书
	*/
	public static class HR_PERSON_CERT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_cert";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 证书
		*/
		public static final DBField CERT_ID = new DBField(DBDataType.STRING , "cert_id","certId","证书","证书",false,false,true);
		
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
		
		public HR_PERSON_CERT() {
			this.init($NAME,"人员证书" , ID , PERSON_ID , CERT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_CERT $TABLE=new HR_PERSON_CERT();
	}
	
	/**
	 * 证书信息
	*/
	public static class HR_PERSON_CERTIFICATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_certificate";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 证书名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","证书名称","证书名称",false,false,true);
		
		/**
		 * 获得时间
		*/
		public static final DBField GET_TIME = new DBField(DBDataType.DATE , "get_time","getTime","获得时间","获得时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 关联
		*/
		public static final DBField REL_ID = new DBField(DBDataType.STRING , "rel_id","relId","关联","关联",false,false,true);
		
		public HR_PERSON_CERTIFICATE() {
			this.init($NAME,"证书信息" , ID , STATUS , PERSON_ID , EMPLOYEE_ID , NAME , GET_TIME , FILE_IDS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REL_ID);
		}
		public static final HR_PERSON_CERTIFICATE $TABLE=new HR_PERSON_CERTIFICATE();
	}
	
	/**
	 * 证照信息
	*/
	public static class HR_PERSON_CERTIFICATE2 extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_certificate2";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 获得时间
		*/
		public static final DBField G_DATE = new DBField(DBDataType.DATE , "g_date","gDate","获得时间","获得时间",false,false,true);
		
		/**
		 * 过期日期
		*/
		public static final DBField E_DATE = new DBField(DBDataType.DATE , "e_date","eDate","过期日期","过期日期",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 关联
		*/
		public static final DBField REL_ID = new DBField(DBDataType.STRING , "rel_id","relId","关联","关联",false,false,true);
		
		public HR_PERSON_CERTIFICATE2() {
			this.init($NAME,"证照信息" , ID , STATUS , PERSON_ID , EMPLOYEE_ID , NAME , TYPE , G_DATE , E_DATE , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REL_ID);
		}
		public static final HR_PERSON_CERTIFICATE2 $TABLE=new HR_PERSON_CERTIFICATE2();
	}
	
	/**
	 * 员工记录
	*/
	public static class HR_PERSON_CHANGE_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_change_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 调动单
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","调动单","调动单",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
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
		
		public HR_PERSON_CHANGE_RCD() {
			this.init($NAME,"员工记录" , ID , OWNER_ID , PERSON_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_PERSON_CHANGE_RCD $TABLE=new HR_PERSON_CHANGE_RCD();
	}
	
	/**
	 * 转正申请
	*/
	public static class HR_PERSON_CONFIRM_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_confirm_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 申请人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","申请人员","申请人员",false,false,true);
		
		/**
		 * 转正日期
		*/
		public static final DBField CONFIRM_DATE = new DBField(DBDataType.DATE , "confirm_date","confirmDate","转正日期","转正日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
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
		
		public HR_PERSON_CONFIRM_APPLY() {
			this.init($NAME,"转正申请" , ID , BUSINESS_CODE , STATUS , PERSON_ID , CONFIRM_DATE , CONTENT , FILE_IDS , NOTE , OPER_USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_CONFIRM_APPLY $TABLE=new HR_PERSON_CONFIRM_APPLY();
	}
	
	/**
	 * 人员合同
	*/
	public static class HR_PERSON_CONTRACT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_contract";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 合同编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","合同编号","合同编号",false,false,true);
		
		/**
		 * 合同类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","合同类型","合同类型",false,false,true);
		
		/**
		 * 签约方
		*/
		public static final DBField CONTRACT_PARTY_ID = new DBField(DBDataType.STRING , "contract_party_id","contractPartyId","签约方","签约方",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 合同年份
		*/
		public static final DBField CONTRACT_YEAR = new DBField(DBDataType.STRING , "contract_year","contractYear","合同年份","合同年份",false,false,true);
		
		/**
		 * 是否转正
		*/
		public static final DBField TRANSFER_TO_REGULAR = new DBField(DBDataType.STRING , "transfer_to_regular","transferToRegular","是否转正","是否转正",false,false,true);
		
		/**
		 * 永久期限
		*/
		public static final DBField IS_PERMANENT = new DBField(DBDataType.STRING , "is_permanent","isPermanent","永久期限","永久期限",false,false,true);
		
		/**
		 * 试用期工资
		*/
		public static final DBField PROBATION_SALARY = new DBField(DBDataType.DECIMAL , "probation_salary","probationSalary","试用期工资","试用期工资",false,false,true);
		
		/**
		 * 试用期期限
		*/
		public static final DBField CONTRACT_TRY_DURATION = new DBField(DBDataType.STRING , "contract_try_duration","contractTryDuration","试用期期限","试用期期限",false,false,true);
		
		/**
		 * 试用期生效时间
		*/
		public static final DBField PROBATION_START_DATE = new DBField(DBDataType.DATE , "probation_start_date","probationStartDate","试用期生效时间","试用期生效时间",false,false,true);
		
		/**
		 * 试用期到期时间
		*/
		public static final DBField PROBATION_FINISH_DATE = new DBField(DBDataType.DATE , "probation_finish_date","probationFinishDate","试用期到期时间","试用期到期时间",false,false,true);
		
		/**
		 * 转正工资
		*/
		public static final DBField SALARY = new DBField(DBDataType.DECIMAL , "salary","salary","转正工资","转正工资",false,false,true);
		
		/**
		 * 合同期限,月
		*/
		public static final DBField CONTRACT_DURATION = new DBField(DBDataType.DECIMAL , "contract_duration","contractDuration","合同期限","月",false,false,true);
		
		/**
		 * 生效时间
		*/
		public static final DBField CONTRACT_START_DATE = new DBField(DBDataType.DATE , "contract_start_date","contractStartDate","生效时间","生效时间",false,false,true);
		
		/**
		 * 到期时间
		*/
		public static final DBField CONTRACT_FINISH_DATE = new DBField(DBDataType.DATE , "contract_finish_date","contractFinishDate","到期时间","到期时间",false,false,true);
		
		/**
		 * 合同内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","合同内容","合同内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 合同附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","合同附件","合同附件",false,false,true);
		
		/**
		 * 是否归档
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","是否归档","是否归档",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON_CONTRACT() {
			this.init($NAME,"人员合同" , ID , PERSON_ID , BUSINESS_CODE , TYPE , CONTRACT_PARTY_ID , STATUS , CONTRACT_YEAR , TRANSFER_TO_REGULAR , IS_PERMANENT , PROBATION_SALARY , CONTRACT_TRY_DURATION , PROBATION_START_DATE , PROBATION_FINISH_DATE , SALARY , CONTRACT_DURATION , CONTRACT_START_DATE , CONTRACT_FINISH_DATE , CONTENT , NOTES , FILE_ID , ARCH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_CONTRACT $TABLE=new HR_PERSON_CONTRACT();
	}
	
	/**
	 * 教育信息
	*/
	public static class HR_PERSON_EDUCATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_education";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 学历
		*/
		public static final DBField EDUCATION = new DBField(DBDataType.STRING , "education","education","学历","学历",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 毕业院校
		*/
		public static final DBField EDUCATIONAL_INSTITUTIONS = new DBField(DBDataType.STRING , "educational_institutions","educationalInstitutions","毕业院校","毕业院校",false,false,true);
		
		/**
		 * 所学专业
		*/
		public static final DBField MAJOY_STUDIED = new DBField(DBDataType.STRING , "majoy_studied","majoyStudied","所学专业","所学专业",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 关联
		*/
		public static final DBField REL_ID = new DBField(DBDataType.STRING , "rel_id","relId","关联","关联",false,false,true);
		
		public HR_PERSON_EDUCATION() {
			this.init($NAME,"教育信息" , ID , STATUS , PERSON_ID , EMPLOYEE_ID , EDUCATION , S_TIME , E_TIME , EDUCATIONAL_INSTITUTIONS , MAJOY_STUDIED , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REL_ID);
		}
		public static final HR_PERSON_EDUCATION $TABLE=new HR_PERSON_EDUCATION();
	}
	
	/**
	 * 人员档案
	*/
	public static class HR_PERSON_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 档案编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","档案编号","档案编号",false,false,true);
		
		/**
		 * 档案状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","档案状态","档案状态",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","人员","人员",false,false,true);
		
		/**
		 * 是否新建档
		*/
		public static final DBField IF_NEW = new DBField(DBDataType.STRING , "if_new","ifNew","是否新建档","是否新建档",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","来源",false,false,true);
		
		/**
		 * 档案保管地
		*/
		public static final DBField SAVE_LOC = new DBField(DBDataType.STRING , "save_loc","saveLoc","档案保管地","档案保管地",false,false,true);
		
		/**
		 * 参加工作时间
		*/
		public static final DBField WORK_START_DATE = new DBField(DBDataType.STRING , "work_start_date","workStartDate","参加工作时间","参加工作时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE = new DBField(DBDataType.STRING , "file","file","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_PERSON_FILE() {
			this.init($NAME,"人员档案" , ID , CODE , STATUS , USER_ID , IF_NEW , SOURCE , SAVE_LOC , WORK_START_DATE , FILE , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_FILE $TABLE=new HR_PERSON_FILE();
	}
	
	/**
	 * 管理单位
	*/
	public static class HR_PERSON_FILE_ORG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_file_org";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_PERSON_FILE_ORG() {
			this.init($NAME,"管理单位" , ID , NAME , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_FILE_ORG $TABLE=new HR_PERSON_FILE_ORG();
	}
	
	/**
	 * 档案调出
	*/
	public static class HR_PERSON_FILE_OUT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_file_out";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 档案
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","档案","档案",false,false,true);
		
		/**
		 * 调出时间
		*/
		public static final DBField OUT_DATE = new DBField(DBDataType.STRING , "out_date","outDate","调出时间","调出时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HR_PERSON_FILE_OUT() {
			this.init($NAME,"档案调出" , ID , STATUS , FILE_ID , OUT_DATE , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_PERSON_FILE_OUT $TABLE=new HR_PERSON_FILE_OUT();
	}
	
	/**
	 * 收入证明申请
	*/
	public static class HR_PERSON_INCOME_CERTIFICATE_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_income_certificate_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 申请部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","申请部门","申请部门",false,false,true);
		
		/**
		 * 申请人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","申请人员","申请人员",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField CONFIRM_DATE = new DBField(DBDataType.DATE , "confirm_date","confirmDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 身份证
		*/
		public static final DBField CARD = new DBField(DBDataType.STRING , "card","card","身份证","身份证",false,false,true);
		
		/**
		 * 证明有效期
		*/
		public static final DBField PERIOD = new DBField(DBDataType.STRING , "period","period","证明有效期","证明有效期",false,false,true);
		
		/**
		 * 原因
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","原因","原因",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_PERSON_INCOME_CERTIFICATE_APPLY() {
			this.init($NAME,"收入证明申请" , ID , BUSINESS_CODE , STATUS , ORG_ID , PERSON_ID , CONFIRM_DATE , CARD , PERIOD , CONTENT , FILE_ID , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_INCOME_CERTIFICATE_APPLY $TABLE=new HR_PERSON_INCOME_CERTIFICATE_APPLY();
	}
	
	/**
	 * 初选人员
	*/
	public static class HR_PERSON_INTERVIEW extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_interview";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 面试
		*/
		public static final DBField INTERVIEW_ID = new DBField(DBDataType.STRING , "interview_id","interviewId","面试","面试",false,false,true);
		
		/**
		 * 面试结果
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","面试结果","面试结果",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX_CODE = new DBField(DBDataType.STRING , "sex_code","sexCode","性别","性别",false,false,true);
		
		/**
		 * 出生日期
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","出生日期","出生日期",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 学历
		*/
		public static final DBField EDUCATION_CODE = new DBField(DBDataType.STRING , "education_code","educationCode","学历","学历",false,false,true);
		
		/**
		 * 毕业院校
		*/
		public static final DBField GRADUATION_SCHOOL = new DBField(DBDataType.STRING , "graduation_school","graduationSchool","毕业院校","毕业院校",false,false,true);
		
		/**
		 * 所学专业
		*/
		public static final DBField MAJOR = new DBField(DBDataType.STRING , "major","major","所学专业","所学专业",false,false,true);
		
		/**
		 * 面试日期
		*/
		public static final DBField INTERVIEW_DATE = new DBField(DBDataType.DATE , "interview_date","interviewDate","面试日期","面试日期",false,false,true);
		
		/**
		 * 面试方式
		*/
		public static final DBField INTERVIEW_METHOD = new DBField(DBDataType.STRING , "interview_method","interviewMethod","面试方式","面试方式",false,false,true);
		
		/**
		 * 应聘岗位
		*/
		public static final DBField POS = new DBField(DBDataType.STRING , "pos","pos","应聘岗位","应聘岗位",false,false,true);
		
		/**
		 * 招聘部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","招聘部门","招聘部门",false,false,true);
		
		/**
		 * 简历来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","简历来源","简历来源",false,false,true);
		
		/**
		 * 面试结论
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","面试结论","面试结论",false,false,true);
		
		/**
		 * 简历
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","简历","简历",false,false,true);
		
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
		
		public HR_PERSON_INTERVIEW() {
			this.init($NAME,"初选人员" , ID , INTERVIEW_ID , STATUS , NAME , SEX_CODE , BIRTHDAY , CONTACT_INFORMATION , EDUCATION_CODE , GRADUATION_SCHOOL , MAJOR , INTERVIEW_DATE , INTERVIEW_METHOD , POS , ORG_ID , SOURCE , RESULT , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_INTERVIEW $TABLE=new HR_PERSON_INTERVIEW();
	}
	
	/**
	 * 员工离职
	*/
	public static class HR_PERSON_LEAVE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_leave";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 离职人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","离职人员","离职人员",false,false,true);
		
		/**
		 * 交接人
		*/
		public static final DBField HANDOVER_ID = new DBField(DBDataType.STRING , "handover_id","handoverId","交接人","交接人",false,false,true);
		
		/**
		 * 离职日期
		*/
		public static final DBField LEAVE_DATE = new DBField(DBDataType.DATE , "leave_date","leaveDate","离职日期","离职日期",false,false,true);
		
		/**
		 * 原因
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","原因","原因",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
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
		
		public HR_PERSON_LEAVE() {
			this.init($NAME,"员工离职" , ID , BUSINESS_CODE , STATUS , PERSON_ID , HANDOVER_ID , LEAVE_DATE , CONTENT , FILE_IDS , NOTE , OPER_USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_LEAVE $TABLE=new HR_PERSON_LEAVE();
	}
	
	/**
	 * 出差申请
	*/
	public static class HR_PERSON_OFFICIAL_BUSINESS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_official_business";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 申请人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","申请人员","申请人员",false,false,true);
		
		/**
		 * 出差日期
		*/
		public static final DBField LEAVE_DATE = new DBField(DBDataType.DATE , "leave_date","leaveDate","出差日期","出差日期",false,false,true);
		
		/**
		 * 原因
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","原因","原因",false,false,true);
		
		/**
		 * 地点
		*/
		public static final DBField LOCATION = new DBField(DBDataType.STRING , "location","location","地点","地点",false,false,true);
		
		/**
		 * 天数
		*/
		public static final DBField DAYS = new DBField(DBDataType.DECIMAL , "days","days","天数","天数",false,false,true);
		
		/**
		 * 申请费用
		*/
		public static final DBField MONEY = new DBField(DBDataType.DECIMAL , "money","money","申请费用","申请费用",false,false,true);
		
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
		
		public HR_PERSON_OFFICIAL_BUSINESS() {
			this.init($NAME,"出差申请" , ID , BUSINESS_CODE , STATUS , PERSON_ID , LEAVE_DATE , CONTENT , LOCATION , DAYS , MONEY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_OFFICIAL_BUSINESS $TABLE=new HR_PERSON_OFFICIAL_BUSINESS();
	}
	
	/**
	 * 职称信息
	*/
	public static class HR_PERSON_PROFESSIONAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_professional";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 加班时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","加班时长","加班时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON_PROFESSIONAL() {
			this.init($NAME,"职称信息" , ID , EMPLOYEE_ID , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_PROFESSIONAL $TABLE=new HR_PERSON_PROFESSIONAL();
	}
	
	/**
	 * 员工离职表
	*/
	public static class HR_PERSON_RESIGNATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_resignation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 离职日期
		*/
		public static final DBField RESIGNATION_DATE = new DBField(DBDataType.DATE , "resignation_date","resignationDate","离职日期","离职日期",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField OPER_TIME = new DBField(DBDataType.DATE , "oper_time","operTime","操作时间","操作时间",false,false,true);
		
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
		
		public HR_PERSON_RESIGNATION() {
			this.init($NAME,"员工离职表" , ID , PERSON_ID , CONTENT , RESIGNATION_DATE , NOTE , OPER_USER_ID , OPER_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_RESIGNATION $TABLE=new HR_PERSON_RESIGNATION();
	}
	
	/**
	 * 人员简历
	*/
	public static class HR_PERSON_RESUME extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_resume";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 学历
		*/
		public static final DBField EDUCATION_CODE = new DBField(DBDataType.STRING , "education_code","educationCode","学历","学历",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		/**
		 * 生日
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","生日","生日",false,false,true);
		
		/**
		 * 学籍
		*/
		public static final DBField STUDENT_STATUS = new DBField(DBDataType.STRING , "student_status","studentStatus","学籍","学籍",false,false,true);
		
		/**
		 * 婚姻状况
		*/
		public static final DBField MARITAL_STATUS = new DBField(DBDataType.STRING , "marital_status","maritalStatus","婚姻状况","婚姻状况",false,false,true);
		
		/**
		 * 介绍
		*/
		public static final DBField INTRODUCE = new DBField(DBDataType.STRING , "introduce","introduce","介绍","介绍",false,false,false);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,false);
		
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
		
		public HR_PERSON_RESUME() {
			this.init($NAME,"人员简历" , ID , NAME , EDUCATION_CODE , SEX , BIRTHDAY , STUDENT_STATUS , MARITAL_STATUS , INTRODUCE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_PERSON_RESUME $TABLE=new HR_PERSON_RESUME();
	}
	
	/**
	 * 积分明细
	*/
	public static class HR_PERSON_SCORE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_score";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 操作
		*/
		public static final DBField OPER_TYPE_ID = new DBField(DBDataType.STRING , "oper_type_id","operTypeId","操作","操作",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 积分
		*/
		public static final DBField SCORE = new DBField(DBDataType.INTEGER , "score","score","积分","积分",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField RCD_TIME = new DBField(DBDataType.DATE , "rcd_time","rcdTime","操作时间","操作时间",false,false,true);
		
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
		
		public HR_PERSON_SCORE() {
			this.init($NAME,"积分明细" , ID , PERSON_ID , OPER_TYPE_ID , TYPE , CONTENT , SCORE , OPER_USER_ID , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_PERSON_SCORE $TABLE=new HR_PERSON_SCORE();
	}
	
	/**
	 * 员工借调
	*/
	public static class HR_PERSON_SECONDMENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_secondment";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 借调日期
		*/
		public static final DBField ACT_DATE = new DBField(DBDataType.DATE , "act_date","actDate","借调日期","借调日期",false,false,true);
		
		/**
		 * 原因
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","原因","原因",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
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
		
		public HR_PERSON_SECONDMENT() {
			this.init($NAME,"员工借调" , ID , BUSINESS_CODE , STATUS , ACT_DATE , CONTENT , FILE_IDS , NOTE , OPER_USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_SECONDMENT $TABLE=new HR_PERSON_SECONDMENT();
	}
	
	/**
	 * 社会关系
	*/
	public static class HR_PERSON_SOCIAL_RELATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_social_relation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 关系类型
		*/
		public static final DBField REL_TYPE = new DBField(DBDataType.STRING , "rel_type","relType","关系类型","关系类型",false,false,true);
		
		/**
		 * 关系
		*/
		public static final DBField REL = new DBField(DBDataType.STRING , "rel","rel","关系","关系",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 工作单位
		*/
		public static final DBField WORK_COMPANY = new DBField(DBDataType.STRING , "work_company","workCompany","工作单位","工作单位",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONCAT = new DBField(DBDataType.STRING , "concat","concat","联系方式","联系方式",false,false,true);
		
		/**
		 * 紧急联系人
		*/
		public static final DBField EMERGENCY_CONTACT = new DBField(DBDataType.STRING , "emergency_contact","emergencyContact","紧急联系人","紧急联系人",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 关联
		*/
		public static final DBField REL_ID = new DBField(DBDataType.STRING , "rel_id","relId","关联","关联",false,false,true);
		
		public HR_PERSON_SOCIAL_RELATION() {
			this.init($NAME,"社会关系" , ID , STATUS , PERSON_ID , EMPLOYEE_ID , REL_TYPE , REL , NAME , WORK_COMPANY , CONCAT , EMERGENCY_CONTACT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REL_ID);
		}
		public static final HR_PERSON_SOCIAL_RELATION $TABLE=new HR_PERSON_SOCIAL_RELATION();
	}
	
	/**
	 * 人员信息
	*/
	public static class HR_PERSON_STORE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_store";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX_CODE = new DBField(DBDataType.STRING , "sex_code","sexCode","性别","性别",false,false,true);
		
		/**
		 * 出生日期
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","出生日期","出生日期",false,false,true);
		
		/**
		 * 籍贯
		*/
		public static final DBField NATIVE_PLACE_CODE = new DBField(DBDataType.STRING , "native_place_code","nativePlaceCode","籍贯","籍贯",false,false,true);
		
		/**
		 * 民族
		*/
		public static final DBField NATION_CODE = new DBField(DBDataType.STRING , "nation_code","nationCode","民族","民族",false,false,true);
		
		/**
		 * 婚姻状况
		*/
		public static final DBField MARITAL_STATUS = new DBField(DBDataType.STRING , "marital_status","maritalStatus","婚姻状况","婚姻状况",false,false,true);
		
		/**
		 * 身份证
		*/
		public static final DBField IDENTITY_CARD = new DBField(DBDataType.STRING , "identity_card","identityCard","身份证","身份证",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 电子邮件
		*/
		public static final DBField EMAIL = new DBField(DBDataType.STRING , "email","email","电子邮件","电子邮件",false,false,true);
		
		/**
		 * 学历
		*/
		public static final DBField EDUCATION_CODE = new DBField(DBDataType.STRING , "education_code","educationCode","学历","学历",false,false,true);
		
		/**
		 * 毕业院校
		*/
		public static final DBField GRADUATION_SCHOOL = new DBField(DBDataType.STRING , "graduation_school","graduationSchool","毕业院校","毕业院校",false,false,true);
		
		/**
		 * 所学专业
		*/
		public static final DBField MAJOR = new DBField(DBDataType.STRING , "major","major","所学专业","所学专业",false,false,true);
		
		/**
		 * 毕业时间
		*/
		public static final DBField GRADUATION_DATE = new DBField(DBDataType.DATE , "graduation_date","graduationDate","毕业时间","毕业时间",false,false,true);
		
		/**
		 * 所学外语
		*/
		public static final DBField FOREIGN_LANGUAGE = new DBField(DBDataType.STRING , "foreign_language","foreignLanguage","所学外语","所学外语",false,false,true);
		
		/**
		 * 外语证书
		*/
		public static final DBField FOREIGN_LANGUAGE_LEVEL = new DBField(DBDataType.STRING , "foreign_language_level","foreignLanguageLevel","外语证书","外语证书",false,false,true);
		
		/**
		 * 所获证书
		*/
		public static final DBField CERTIFICATE = new DBField(DBDataType.STRING , "certificate","certificate","所获证书","所获证书",false,false,true);
		
		/**
		 * 计算机能力
		*/
		public static final DBField COMPUTER_ABILITY = new DBField(DBDataType.STRING , "computer_ability","computerAbility","计算机能力","计算机能力",false,false,true);
		
		/**
		 * 政治面貌
		*/
		public static final DBField POLITIC_COUNTENANCE_CODE = new DBField(DBDataType.STRING , "politic_countenance_code","politicCountenanceCode","政治面貌","政治面貌",false,false,true);
		
		/**
		 * 入党时间
		*/
		public static final DBField JOIN_PART_DATE = new DBField(DBDataType.DATE , "join_part_date","joinPartDate","入党时间","入党时间",false,false,true);
		
		/**
		 * 参加工作时间
		*/
		public static final DBField FIRST_WORK_DATE = new DBField(DBDataType.DATE , "first_work_date","firstWorkDate","参加工作时间","参加工作时间",false,false,true);
		
		/**
		 * 特长
		*/
		public static final DBField SPECIAL_SKILL = new DBField(DBDataType.STRING , "special_skill","specialSkill","特长","特长",false,false,true);
		
		/**
		 * 对工作要求
		*/
		public static final DBField JOB_REQUIREMENT = new DBField(DBDataType.STRING , "job_requirement","jobRequirement","对工作要求","对工作要求",false,false,true);
		
		/**
		 * 目前月薪
		*/
		public static final DBField NOW_SALARY = new DBField(DBDataType.DECIMAL , "now_salary","nowSalary","目前月薪","目前月薪",false,false,true);
		
		/**
		 * 期望月薪
		*/
		public static final DBField FOR_SALARY = new DBField(DBDataType.DECIMAL , "for_salary","forSalary","期望月薪","期望月薪",false,false,true);
		
		/**
		 * 招聘来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","招聘来源","招聘来源",false,false,true);
		
		/**
		 * 评审结果
		*/
		public static final DBField REVIEW_RESULT = new DBField(DBDataType.STRING , "review_result","reviewResult","评审结果","评审结果",false,false,true);
		
		/**
		 * 应聘岗位
		*/
		public static final DBField POSITION = new DBField(DBDataType.STRING , "position","position","应聘岗位","应聘岗位",false,false,true);
		
		/**
		 * 照片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","照片","照片",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 归属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","归属","归属",false,false,true);
		
		/**
		 * 面试结果
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","面试结果","面试结果",false,false,true);
		
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
		
		public HR_PERSON_STORE() {
			this.init($NAME,"人员信息" , ID , NAME , SEX_CODE , BIRTHDAY , NATIVE_PLACE_CODE , NATION_CODE , MARITAL_STATUS , IDENTITY_CARD , CONTACT_INFORMATION , EMAIL , EDUCATION_CODE , GRADUATION_SCHOOL , MAJOR , GRADUATION_DATE , FOREIGN_LANGUAGE , FOREIGN_LANGUAGE_LEVEL , CERTIFICATE , COMPUTER_ABILITY , POLITIC_COUNTENANCE_CODE , JOIN_PART_DATE , FIRST_WORK_DATE , SPECIAL_SKILL , JOB_REQUIREMENT , NOW_SALARY , FOR_SALARY , SOURCE , REVIEW_RESULT , POSITION , PICTURE_ID , FILE_ID , NOTE , OWNER_CODE , STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_STORE $TABLE=new HR_PERSON_STORE();
	}
	
	/**
	 * 员工调动
	*/
	public static class HR_PERSON_TRANSFER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_transfer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","编号","编号",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 调动日期
		*/
		public static final DBField TRANSFER_DATE = new DBField(DBDataType.DATE , "transfer_date","transferDate","调动日期","调动日期",false,false,true);
		
		/**
		 * 原因
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","原因","原因",false,false,true);
		
		/**
		 * 部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","部门","部门",false,false,true);
		
		/**
		 * 岗位
		*/
		public static final DBField POSITION_CODE = new DBField(DBDataType.STRING , "position_code","positionCode","岗位","岗位",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
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
		
		public HR_PERSON_TRANSFER() {
			this.init($NAME,"员工调动" , ID , BUSINESS_CODE , STATUS , TRANSFER_DATE , CONTENT , ORG_ID , POSITION_CODE , FILE_IDS , NOTE , OPER_USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_TRANSFER $TABLE=new HR_PERSON_TRANSFER();
	}
	
	/**
	 * 员工调动记录
	*/
	public static class HR_PERSON_TRANSFER_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_transfer_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 调动单
		*/
		public static final DBField TRANSFER_ID = new DBField(DBDataType.STRING , "transfer_id","transferId","调动单","调动单",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 调动日期
		*/
		public static final DBField TRANSFER_DATE = new DBField(DBDataType.DATE , "transfer_date","transferDate","调动日期","调动日期",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField OPER_TIME = new DBField(DBDataType.DATE , "oper_time","operTime","操作时间","操作时间",false,false,true);
		
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
		
		public HR_PERSON_TRANSFER_RCD() {
			this.init($NAME,"员工调动记录" , ID , STATUS , TRANSFER_ID , PERSON_ID , CONTENT , TRANSFER_DATE , NOTE , OPER_USER_ID , OPER_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_PERSON_TRANSFER_RCD $TABLE=new HR_PERSON_TRANSFER_RCD();
	}
	
	/**
	 * 工作经历
	*/
	public static class HR_PERSON_WORK_EXPERIENCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_work_experience";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","员工","员工",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 公司名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","公司名称","公司名称",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 岗位
		*/
		public static final DBField POST = new DBField(DBDataType.STRING , "post","post","岗位","岗位",false,false,true);
		
		/**
		 * 工作内容
		*/
		public static final DBField WORK_CONTENT = new DBField(DBDataType.STRING , "work_content","workContent","工作内容","工作内容",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 关联
		*/
		public static final DBField REL_ID = new DBField(DBDataType.STRING , "rel_id","relId","关联","关联",false,false,true);
		
		public HR_PERSON_WORK_EXPERIENCE() {
			this.init($NAME,"工作经历" , ID , STATUS , PERSON_ID , EMPLOYEE_ID , NAME , S_TIME , E_TIME , POST , WORK_CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REL_ID);
		}
		public static final HR_PERSON_WORK_EXPERIENCE $TABLE=new HR_PERSON_WORK_EXPERIENCE();
	}
	
	/**
	 * 人员需求申请
	*/
	public static class HR_PERSONNEL_REQUIREMENT_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_personnel_requirement_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","流程编号","流程编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 征集主题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","征集主题","征集主题",false,false,true);
		
		/**
		 * 需求部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","需求部门","需求部门",false,false,true);
		
		/**
		 * 薪酬范围
		*/
		public static final DBField SALARY = new DBField(DBDataType.STRING , "salary","salary","薪酬范围","薪酬范围",false,false,true);
		
		/**
		 * 需求岗位
		*/
		public static final DBField POS = new DBField(DBDataType.STRING , "pos","pos","需求岗位","需求岗位",false,false,true);
		
		/**
		 * 需求人数
		*/
		public static final DBField PERSON_NUMBER = new DBField(DBDataType.INTEGER , "person_number","personNumber","需求人数","需求人数",false,false,true);
		
		/**
		 * 招聘方式
		*/
		public static final DBField METHOD = new DBField(DBDataType.STRING , "method","method","招聘方式","招聘方式",false,false,true);
		
		/**
		 * 开始日期
		*/
		public static final DBField SDATE = new DBField(DBDataType.DATE , "sdate","sdate","开始日期","开始日期",false,false,true);
		
		/**
		 * 结束日期
		*/
		public static final DBField EDATE = new DBField(DBDataType.DATE , "edate","edate","结束日期","结束日期",false,false,true);
		
		/**
		 * 岗位要求
		*/
		public static final DBField JOB_REQUIREMENT = new DBField(DBDataType.STRING , "job_requirement","jobRequirement","岗位要求","岗位要求",false,false,true);
		
		/**
		 * 工作内容
		*/
		public static final DBField WORK_CONTENT = new DBField(DBDataType.STRING , "work_content","workContent","工作内容","工作内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 申请人
		*/
		public static final DBField APPLY_USER_ID = new DBField(DBDataType.STRING , "apply_user_id","applyUserId","申请人","申请人",false,false,true);
		
		/**
		 * 选择流程
		*/
		public static final DBField PROCESS_CODE = new DBField(DBDataType.STRING , "process_code","processCode","选择流程","选择流程",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSONNEL_REQUIREMENT_APPLY() {
			this.init($NAME,"人员需求申请" , ID , BUSINESS_CODE , STATUS , TITLE , ORG_ID , SALARY , POS , PERSON_NUMBER , METHOD , SDATE , EDATE , JOB_REQUIREMENT , WORK_CONTENT , NOTES , APPLY_USER_ID , PROCESS_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSONNEL_REQUIREMENT_APPLY $TABLE=new HR_PERSONNEL_REQUIREMENT_APPLY();
	}
	
	/**
	 * 工作岗位
	*/
	public static class HR_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 工作职责
		*/
		public static final DBField JOB_CONTENT = new DBField(DBDataType.STRING , "job_content","jobContent","工作职责","工作职责",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_POSITION() {
			this.init($NAME,"工作岗位" , ID , NAME , TYPE , JOB_CONTENT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_POSITION $TABLE=new HR_POSITION();
	}
	
	/**
	 * 岗位类型
	*/
	public static class HR_POSITION_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_position_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 岗位编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","岗位编码","岗位编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_POSITION_TYPE() {
			this.init($NAME,"岗位类型" , ID , CODE , NAME , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_POSITION_TYPE $TABLE=new HR_POSITION_TYPE();
	}
	
	/**
	 * 职业评级
	*/
	public static class HR_PROFESSIONAL_LEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_professional_level";
		
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
		 * 职级奖金
		*/
		public static final DBField BONUS = new DBField(DBDataType.DECIMAL , "bonus","bonus","职级奖金","职级奖金",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PROFESSIONAL_LEVEL() {
			this.init($NAME,"职业评级" , ID , CODE , NAME , BONUS , NOTE , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PROFESSIONAL_LEVEL $TABLE=new HR_PROFESSIONAL_LEVEL();
	}
	
	/**
	 * 职级序列
	*/
	public static class HR_RANK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_rank";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 职级序列
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","职级序列","职级序列",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
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
		
		public HR_RANK() {
			this.init($NAME,"职级序列" , ID , CODE , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RANK $TABLE=new HR_RANK();
	}
	
	/**
	 * 招聘记录
	*/
	public static class HR_RECRUIT_PERSON_REC extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_recruit_person_rec";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 招聘说明
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","招聘说明","招聘说明",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_ID = new DBField(DBDataType.STRING , "post_id","postId","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_NAME = new DBField(DBDataType.STRING , "post_name","postName","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 招聘要求
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","招聘要求","招聘要求",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_DATE = new DBField(DBDataType.DATE , "start_date","startDate","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_DATE = new DBField(DBDataType.DATE , "end_date","endDate","结束时间","结束时间",false,false,true);
		
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
		
		public HR_RECRUIT_PERSON_REC() {
			this.init($NAME,"招聘记录" , ID , NAME , POST_ID , POST_NAME , CONTENT , NOTES , START_DATE , END_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RECRUIT_PERSON_REC $TABLE=new HR_RECRUIT_PERSON_REC();
	}
	
	/**
	 * 招聘岗位
	*/
	public static class HR_RECRUIT_POST_REC extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_recruit_post_rec";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 招聘说明
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","招聘说明","招聘说明",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_NAME = new DBField(DBDataType.STRING , "post_name","postName","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 招聘要求
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","招聘要求","招聘要求",false,false,true);
		
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
		
		public HR_RECRUIT_POST_REC() {
			this.init($NAME,"招聘岗位" , ID , NAME , POST_NAME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RECRUIT_POST_REC $TABLE=new HR_RECRUIT_POST_REC();
	}
	
	/**
	 * 招聘记录
	*/
	public static class HR_RECRUIT_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_recruit_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 招聘说明
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","招聘说明","招聘说明",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_NAME = new DBField(DBDataType.STRING , "post_name","postName","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 招聘要求
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","招聘要求","招聘要求",false,false,true);
		
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
		
		public HR_RECRUIT_RECORD() {
			this.init($NAME,"招聘记录" , ID , NAME , POST_NAME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RECRUIT_RECORD $TABLE=new HR_RECRUIT_RECORD();
	}
	
	/**
	 * 招聘计划申请
	*/
	public static class HR_RECRUITMENT_PLAN_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_recruitment_plan_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","流程编号","流程编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 招聘主题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","招聘主题","招聘主题",false,false,true);
		
		/**
		 * 招聘部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","招聘部门","招聘部门",false,false,true);
		
		/**
		 * 薪酬范围
		*/
		public static final DBField SALARY = new DBField(DBDataType.STRING , "salary","salary","薪酬范围","薪酬范围",false,false,true);
		
		/**
		 * 招聘岗位
		*/
		public static final DBField POS = new DBField(DBDataType.STRING , "pos","pos","招聘岗位","招聘岗位",false,false,true);
		
		/**
		 * 招聘人数
		*/
		public static final DBField PERSON_NUMBER = new DBField(DBDataType.INTEGER , "person_number","personNumber","招聘人数","招聘人数",false,false,true);
		
		/**
		 * 招聘方式
		*/
		public static final DBField METHOD = new DBField(DBDataType.STRING , "method","method","招聘方式","招聘方式",false,false,true);
		
		/**
		 * 开始日期
		*/
		public static final DBField SDATE = new DBField(DBDataType.DATE , "sdate","sdate","开始日期","开始日期",false,false,true);
		
		/**
		 * 结束日期
		*/
		public static final DBField EDATE = new DBField(DBDataType.DATE , "edate","edate","结束日期","结束日期",false,false,true);
		
		/**
		 * 岗位要求
		*/
		public static final DBField JOB_REQUIREMENT = new DBField(DBDataType.STRING , "job_requirement","jobRequirement","岗位要求","岗位要求",false,false,true);
		
		/**
		 * 工作内容
		*/
		public static final DBField WORK_CONTENT = new DBField(DBDataType.STRING , "work_content","workContent","工作内容","工作内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 申请人
		*/
		public static final DBField APPLY_USER_ID = new DBField(DBDataType.STRING , "apply_user_id","applyUserId","申请人","申请人",false,false,true);
		
		/**
		 * 选择流程
		*/
		public static final DBField PROCESS_CODE = new DBField(DBDataType.STRING , "process_code","processCode","选择流程","选择流程",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_RECRUITMENT_PLAN_APPLY() {
			this.init($NAME,"招聘计划申请" , ID , BUSINESS_CODE , STATUS , TITLE , ORG_ID , SALARY , POS , PERSON_NUMBER , METHOD , SDATE , EDATE , JOB_REQUIREMENT , WORK_CONTENT , NOTES , APPLY_USER_ID , PROCESS_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RECRUITMENT_PLAN_APPLY $TABLE=new HR_RECRUITMENT_PLAN_APPLY();
	}
	
	/**
	 * 人员薪酬
	*/
	public static class HR_SALARY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 基本工资
		*/
		public static final DBField BASE_SALARY = new DBField(DBDataType.DECIMAL , "base_salary","baseSalary","基本工资","基本工资",false,false,true);
		
		/**
		 * 岗位工资
		*/
		public static final DBField POST_SALARY = new DBField(DBDataType.DECIMAL , "post_salary","postSalary","岗位工资","岗位工资",false,false,true);
		
		/**
		 * 工龄工资
		*/
		public static final DBField WORKING_YEARS_SALARY = new DBField(DBDataType.DECIMAL , "working_years_salary","workingYearsSalary","工龄工资","工龄工资",false,false,true);
		
		/**
		 * 固定补贴
		*/
		public static final DBField FIXED_SALARY = new DBField(DBDataType.DECIMAL , "fixed_salary","fixedSalary","固定补贴","固定补贴",false,false,true);
		
		/**
		 * 绩效补贴
		*/
		public static final DBField ACHIEVEMENT_SALARY = new DBField(DBDataType.DECIMAL , "achievement_salary","achievementSalary","绩效补贴","绩效补贴",false,false,true);
		
		/**
		 * 加班补贴
		*/
		public static final DBField OVERTIME_SALARY = new DBField(DBDataType.DECIMAL , "overtime_salary","overtimeSalary","加班补贴","加班补贴",false,false,true);
		
		/**
		 * 其他补贴
		*/
		public static final DBField OTHER_SALARY = new DBField(DBDataType.DECIMAL , "other_salary","otherSalary","其他补贴","其他补贴",false,false,true);
		
		/**
		 * 通讯补贴
		*/
		public static final DBField COMMUNICATION_SALARY = new DBField(DBDataType.DECIMAL , "communication_salary","communicationSalary","通讯补贴","通讯补贴",false,false,true);
		
		/**
		 * 交通补贴
		*/
		public static final DBField TRAFFIC_SALARY = new DBField(DBDataType.DECIMAL , "traffic_salary","trafficSalary","交通补贴","交通补贴",false,false,true);
		
		/**
		 * 住房补贴
		*/
		public static final DBField HOUSING_SALARY = new DBField(DBDataType.DECIMAL , "housing_salary","housingSalary","住房补贴","住房补贴",false,false,true);
		
		/**
		 * 提成工资
		*/
		public static final DBField COMMISSION_SALARY = new DBField(DBDataType.DECIMAL , "commission_salary","commissionSalary","提成工资","提成工资",false,false,true);
		
		/**
		 * 高温补贴
		*/
		public static final DBField HIGH_TEMPERATURE_SALARY = new DBField(DBDataType.DECIMAL , "high_temperature_salary","highTemperatureSalary","高温补贴","高温补贴",false,false,true);
		
		/**
		 * 住房公积金基数
		*/
		public static final DBField WELFARE_ZFGJJ_BASE = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_base","welfareZfgjjBase","住房公积金基数","住房公积金基数",false,false,true);
		
		/**
		 * 住房公积金个人
		*/
		public static final DBField WELFARE_ZFGJJ_PERSON = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_person","welfareZfgjjPerson","住房公积金个人","住房公积金个人",false,false,true);
		
		/**
		 * 住房公积金公司
		*/
		public static final DBField WELFARE_ZFGJJ_COMPANY = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_company","welfareZfgjjCompany","住房公积金公司","住房公积金公司",false,false,true);
		
		/**
		 * 养老保险基数
		*/
		public static final DBField WELFAER_YLBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_base","welfaerYlbxBase","养老保险基数","养老保险基数",false,false,true);
		
		/**
		 * 养老保险个人
		*/
		public static final DBField WELFAER_YLBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_person","welfaerYlbxPerson","养老保险个人","养老保险个人",false,false,true);
		
		/**
		 * 养老保险公司
		*/
		public static final DBField WELFAER_YLBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_company","welfaerYlbxCompany","养老保险公司","养老保险公司",false,false,true);
		
		/**
		 * 工伤保险基数
		*/
		public static final DBField WELFAER_GSBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_base","welfaerGsbxBase","工伤保险基数","工伤保险基数",false,false,true);
		
		/**
		 * 工伤保险个人
		*/
		public static final DBField WELFAER_GSBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_person","welfaerGsbxPerson","工伤保险个人","工伤保险个人",false,false,true);
		
		/**
		 * 工伤保险公司
		*/
		public static final DBField WELFAER_GSBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_company","welfaerGsbxCompany","工伤保险公司","工伤保险公司",false,false,true);
		
		/**
		 * 医疗保险基数
		*/
		public static final DBField WELFAER_YRBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_base","welfaerYrbxBase","医疗保险基数","医疗保险基数",false,false,true);
		
		/**
		 * 医疗保险个人
		*/
		public static final DBField WELFAER_YRBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_person","welfaerYrbxPerson","医疗保险个人","医疗保险个人",false,false,true);
		
		/**
		 * 医疗保险公司
		*/
		public static final DBField WELFAER_YRBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_company","welfaerYrbxCompany","医疗保险公司","医疗保险公司",false,false,true);
		
		/**
		 * 生育保险基数
		*/
		public static final DBField WELFAER_SYBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_sybx_base","welfaerSybxBase","生育保险基数","生育保险基数",false,false,true);
		
		/**
		 * 生育保险个人
		*/
		public static final DBField WELFAER_SYBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_sybx_person","welfaerSybxPerson","生育保险个人","生育保险个人",false,false,true);
		
		/**
		 * 生育保险公司
		*/
		public static final DBField WELFAER_SYBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_sybx_company","welfaerSybxCompany","生育保险公司","生育保险公司",false,false,true);
		
		/**
		 * 失业保险基数
		*/
		public static final DBField WELFAER_SYEBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_syebx_base","welfaerSyebxBase","失业保险基数","失业保险基数",false,false,true);
		
		/**
		 * 失业保险个人
		*/
		public static final DBField WELFAER_SYEBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_syebx_person","welfaerSyebxPerson","失业保险个人","失业保险个人",false,false,true);
		
		/**
		 * 失业保险公司
		*/
		public static final DBField WELFAER_SYEBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_syebx_company","welfaerSyebxCompany","失业保险公司","失业保险公司",false,false,true);
		
		/**
		 * 个税抵扣
		*/
		public static final DBField DEDUCT_PERSONAL_TAX_RED = new DBField(DBDataType.DECIMAL , "deduct_personal_tax_red","deductPersonalTaxRed","个税抵扣","个税抵扣",false,false,true);
		
		/**
		 * 扣除考勤
		*/
		public static final DBField DEDUCT_KQ = new DBField(DBDataType.DECIMAL , "deduct_kq","deductKq","扣除考勤","扣除考勤",false,false,true);
		
		/**
		 * 扣除工会
		*/
		public static final DBField DEDUCT_GH = new DBField(DBDataType.DECIMAL , "deduct_gh","deductGh","扣除工会","扣除工会",false,false,true);
		
		/**
		 * 扣除其他
		*/
		public static final DBField DUDUCT_OTHER = new DBField(DBDataType.DECIMAL , "duduct_other","duductOther","扣除其他","扣除其他",false,false,true);
		
		/**
		 * 企业专项扣除
		*/
		public static final DBField PERSONAL_STATUS = new DBField(DBDataType.STRING , "personal_status","personalStatus","企业专项扣除","企业专项扣除",false,false,true);
		
		/**
		 * 子女教育
		*/
		public static final DBField PERSONAL_TAX_ZNJY = new DBField(DBDataType.DECIMAL , "personal_tax_znjy","personalTaxZnjy","子女教育","子女教育",false,false,true);
		
		/**
		 * 子女教育备注
		*/
		public static final DBField PERSONAL_TAX_ZNJY_NOTES = new DBField(DBDataType.STRING , "personal_tax_znjy_notes","personalTaxZnjyNotes","子女教育备注","子女教育备注",false,false,true);
		
		/**
		 * 继续教育
		*/
		public static final DBField PERSONAL_TAX_JXJY = new DBField(DBDataType.DECIMAL , "personal_tax_jxjy","personalTaxJxjy","继续教育","继续教育",false,false,true);
		
		/**
		 * 继续教育备注
		*/
		public static final DBField PERSONAL_TAX_JXJY_NOTES = new DBField(DBDataType.STRING , "personal_tax_jxjy_notes","personalTaxJxjyNotes","继续教育备注","继续教育备注",false,false,true);
		
		/**
		 * 大病医疗
		*/
		public static final DBField PERSONAL_TAX_DBYL = new DBField(DBDataType.DECIMAL , "personal_tax_dbyl","personalTaxDbyl","大病医疗","大病医疗",false,false,true);
		
		/**
		 * 大病医疗备注
		*/
		public static final DBField PERSONAL_TAX_DBYL_NOTES = new DBField(DBDataType.STRING , "personal_tax_dbyl_notes","personalTaxDbylNotes","大病医疗备注","大病医疗备注",false,false,true);
		
		/**
		 * 住房贷款
		*/
		public static final DBField PERSONAL_TAX_ZFDK = new DBField(DBDataType.DECIMAL , "personal_tax_zfdk","personalTaxZfdk","住房贷款","住房贷款",false,false,true);
		
		/**
		 * 住房贷款备注
		*/
		public static final DBField PERSONAL_TAX_ZFDK_NOTES = new DBField(DBDataType.STRING , "personal_tax_zfdk_notes","personalTaxZfdkNotes","住房贷款备注","住房贷款备注",false,false,true);
		
		/**
		 * 住房租金
		*/
		public static final DBField PERSONAL_TAX_ZFZJ = new DBField(DBDataType.DECIMAL , "personal_tax_zfzj","personalTaxZfzj","住房租金","住房租金",false,false,true);
		
		/**
		 * 住房租金备注
		*/
		public static final DBField PERSONAL_TAX_ZFZJ_NOTES = new DBField(DBDataType.STRING , "personal_tax_zfzj_notes","personalTaxZfzjNotes","住房租金备注","住房租金备注",false,false,true);
		
		/**
		 * 赡养老人
		*/
		public static final DBField PERSONAL_TAX_SYLR = new DBField(DBDataType.DECIMAL , "personal_tax_sylr","personalTaxSylr","赡养老人","赡养老人",false,false,true);
		
		/**
		 * 赡养老人备注
		*/
		public static final DBField PERSONAL_TAX_SYLR_NOTES = new DBField(DBDataType.STRING , "personal_tax_sylr_notes","personalTaxSylrNotes","赡养老人备注","赡养老人备注",false,false,true);
		
		/**
		 * 幼儿照护
		*/
		public static final DBField PERSONAL_TAX_ERZH = new DBField(DBDataType.DECIMAL , "personal_tax_erzh","personalTaxErzh","幼儿照护","幼儿照护",false,false,true);
		
		/**
		 * 幼儿照护备注
		*/
		public static final DBField PERSONAL_TAX_ERZH_NOTES = new DBField(DBDataType.STRING , "personal_tax_erzh_notes","personalTaxErzhNotes","幼儿照护备注","幼儿照护备注",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY() {
			this.init($NAME,"人员薪酬" , ID , PERSON_ID , BASE_SALARY , POST_SALARY , WORKING_YEARS_SALARY , FIXED_SALARY , ACHIEVEMENT_SALARY , OVERTIME_SALARY , OTHER_SALARY , COMMUNICATION_SALARY , TRAFFIC_SALARY , HOUSING_SALARY , COMMISSION_SALARY , HIGH_TEMPERATURE_SALARY , WELFARE_ZFGJJ_BASE , WELFARE_ZFGJJ_PERSON , WELFARE_ZFGJJ_COMPANY , WELFAER_YLBX_BASE , WELFAER_YLBX_PERSON , WELFAER_YLBX_COMPANY , WELFAER_GSBX_BASE , WELFAER_GSBX_PERSON , WELFAER_GSBX_COMPANY , WELFAER_YRBX_BASE , WELFAER_YRBX_PERSON , WELFAER_YRBX_COMPANY , WELFAER_SYBX_BASE , WELFAER_SYBX_PERSON , WELFAER_SYBX_COMPANY , WELFAER_SYEBX_BASE , WELFAER_SYEBX_PERSON , WELFAER_SYEBX_COMPANY , DEDUCT_PERSONAL_TAX_RED , DEDUCT_KQ , DEDUCT_GH , DUDUCT_OTHER , PERSONAL_STATUS , PERSONAL_TAX_ZNJY , PERSONAL_TAX_ZNJY_NOTES , PERSONAL_TAX_JXJY , PERSONAL_TAX_JXJY_NOTES , PERSONAL_TAX_DBYL , PERSONAL_TAX_DBYL_NOTES , PERSONAL_TAX_ZFDK , PERSONAL_TAX_ZFDK_NOTES , PERSONAL_TAX_ZFZJ , PERSONAL_TAX_ZFZJ_NOTES , PERSONAL_TAX_SYLR , PERSONAL_TAX_SYLR_NOTES , PERSONAL_TAX_ERZH , PERSONAL_TAX_ERZH_NOTES , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY $TABLE=new HR_SALARY();
	}
	
	/**
	 * 薪酬发放
	*/
	public static class HR_SALARY_ACTION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_action";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 开始日期
		*/
		public static final DBField START = new DBField(DBDataType.DATE , "start","start","开始日期","开始日期",false,false,true);
		
		/**
		 * 结束日期
		*/
		public static final DBField END = new DBField(DBDataType.DATE , "end","end","结束日期","结束日期",false,false,true);
		
		/**
		 * 月份
		*/
		public static final DBField ACTION_MONTH = new DBField(DBDataType.STRING , "action_month","actionMonth","月份","月份",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 跟随模版
		*/
		public static final DBField WITH_TPL = new DBField(DBDataType.STRING , "with_tpl","withTpl","跟随模版","跟随模版",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_ACTION() {
			this.init($NAME,"薪酬发放" , ID , STATUS , LABEL , NAME , START , END , ACTION_MONTH , TPL_ID , WITH_TPL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_ACTION $TABLE=new HR_SALARY_ACTION();
	}
	
	/**
	 * 薪酬字段
	*/
	public static class HR_SALARY_COLUMN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_column";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 字段
		*/
		public static final DBField COL_CODE = new DBField(DBDataType.STRING , "col_code","colCode","字段","字段",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField COL_NAME = new DBField(DBDataType.STRING , "col_name","colName","名称","名称",false,false,true);
		
		/**
		 * 类型,实体,表字段,常量
		*/
		public static final DBField COL_TYPE = new DBField(DBDataType.STRING , "col_type","colType","类型","实体,表字段,常量",false,false,true);
		
		/**
		 * 值
		*/
		public static final DBField COL_VALUE = new DBField(DBDataType.DECIMAL , "col_value","colValue","值","值",false,false,true);
		
		/**
		 * 数据来源
		*/
		public static final DBField DS_SOURCE = new DBField(DBDataType.STRING , "ds_source","dsSource","数据来源","数据来源",false,false,true);
		
		/**
		 * 计算方式
		*/
		public static final DBField CAL_METHOD = new DBField(DBDataType.STRING , "cal_method","calMethod","计算方式","计算方式",false,false,true);
		
		/**
		 * 业务分类
		*/
		public static final DBField BUSI_TYPE = new DBField(DBDataType.STRING , "busi_type","busiType","业务分类","业务分类",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_COLUMN() {
			this.init($NAME,"薪酬字段" , ID , COL_CODE , COL_NAME , COL_TYPE , COL_VALUE , DS_SOURCE , CAL_METHOD , BUSI_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_COLUMN $TABLE=new HR_SALARY_COLUMN();
	}
	
	/**
	 * 薪酬控制
	*/
	public static class HR_SALARY_CTL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_ctl";
		
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
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 是否参与
		*/
		public static final DBField VALUE_EN = new DBField(DBDataType.STRING , "value_en","valueEn","是否参与","是否参与",false,false,true);
		
		/**
		 * 字符串数值
		*/
		public static final DBField VALUE_STR = new DBField(DBDataType.STRING , "value_str","valueStr","字符串数值","字符串数值",false,false,true);
		
		/**
		 * 浮点数值
		*/
		public static final DBField VALUE_D = new DBField(DBDataType.DECIMAL , "value_d","valueD","浮点数值","浮点数值",false,false,true);
		
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
		
		public HR_SALARY_CTL() {
			this.init($NAME,"薪酬控制" , ID , CODE , NAME , TYPE , VALUE_EN , VALUE_STR , VALUE_D , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_CTL $TABLE=new HR_SALARY_CTL();
	}
	
	/**
	 * 薪酬明细
	*/
	public static class HR_SALARY_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField USER_NAME = new DBField(DBDataType.STRING , "user_name","userName","姓名","姓名",false,false,true);
		
		/**
		 * 月份
		*/
		public static final DBField ACTION_MONTH = new DBField(DBDataType.STRING , "action_month","actionMonth","月份","月份",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","部门","部门",false,false,true);
		
		/**
		 * 银行名称
		*/
		public static final DBField BANK = new DBField(DBDataType.STRING , "bank","bank","银行名称","银行名称",false,false,true);
		
		/**
		 * 银行账户
		*/
		public static final DBField BANK_ACCOUNT = new DBField(DBDataType.STRING , "bank_account","bankAccount","银行账户","银行账户",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION_ID = new DBField(DBDataType.STRING , "action_id","actionId","动作","动作",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 工资
		*/
		public static final DBField TOTAL_AMOUNT = new DBField(DBDataType.DECIMAL , "total_amount","totalAmount","工资","工资",false,false,true);
		
		/**
		 * 应发金额
		*/
		public static final DBField PAY_AMOUNT = new DBField(DBDataType.DECIMAL , "pay_amount","payAmount","应发金额","应发金额",false,false,true);
		
		/**
		 * 实发金额,员工
		*/
		public static final DBField ISSUED_AMOUNT = new DBField(DBDataType.DECIMAL , "issued_amount","issuedAmount","实发金额","员工",false,false,true);
		
		/**
		 * 基本工资
		*/
		public static final DBField BASE_SALARY = new DBField(DBDataType.DECIMAL , "base_salary","baseSalary","基本工资","基本工资",false,false,true);
		
		/**
		 * 岗位工资
		*/
		public static final DBField POST_SALARY = new DBField(DBDataType.DECIMAL , "post_salary","postSalary","岗位工资","岗位工资",false,false,true);
		
		/**
		 * 工龄工资
		*/
		public static final DBField WORKING_YEARS_SALARY = new DBField(DBDataType.DECIMAL , "working_years_salary","workingYearsSalary","工龄工资","工龄工资",false,false,true);
		
		/**
		 * 固定补贴
		*/
		public static final DBField FIXED_SALARY = new DBField(DBDataType.DECIMAL , "fixed_salary","fixedSalary","固定补贴","固定补贴",false,false,true);
		
		/**
		 * 绩效补贴
		*/
		public static final DBField ACHIEVEMENT_SALARY = new DBField(DBDataType.DECIMAL , "achievement_salary","achievementSalary","绩效补贴","绩效补贴",false,false,true);
		
		/**
		 * 加班补贴
		*/
		public static final DBField OVERTIME_SALARY = new DBField(DBDataType.DECIMAL , "overtime_salary","overtimeSalary","加班补贴","加班补贴",false,false,true);
		
		/**
		 * 通讯补贴
		*/
		public static final DBField COMMUNICATION_SALARY = new DBField(DBDataType.DECIMAL , "communication_salary","communicationSalary","通讯补贴","通讯补贴",false,false,true);
		
		/**
		 * 交通补贴
		*/
		public static final DBField TRAFFIC_SALARY = new DBField(DBDataType.DECIMAL , "traffic_salary","trafficSalary","交通补贴","交通补贴",false,false,true);
		
		/**
		 * 住房补贴
		*/
		public static final DBField HOUSING_SALARY = new DBField(DBDataType.DECIMAL , "housing_salary","housingSalary","住房补贴","住房补贴",false,false,true);
		
		/**
		 * 高温补贴
		*/
		public static final DBField HIGH_TEMPERATURE_SALARY = new DBField(DBDataType.DECIMAL , "high_temperature_salary","highTemperatureSalary","高温补贴","高温补贴",false,false,true);
		
		/**
		 * 其他补贴
		*/
		public static final DBField OTHER_SALARY = new DBField(DBDataType.DECIMAL , "other_salary","otherSalary","其他补贴","其他补贴",false,false,true);
		
		/**
		 * 提成工资
		*/
		public static final DBField COMMISSION_SALARY = new DBField(DBDataType.DECIMAL , "commission_salary","commissionSalary","提成工资","提成工资",false,false,true);
		
		/**
		 * 计时工资
		*/
		public static final DBField UNIT_TIME_SALARY = new DBField(DBDataType.DECIMAL , "unit_time_salary","unitTimeSalary","计时工资","计时工资",false,false,true);
		
		/**
		 * 计件工资
		*/
		public static final DBField UNIT_NUMBER_SALARY = new DBField(DBDataType.DECIMAL , "unit_number_salary","unitNumberSalary","计件工资","计件工资",false,false,true);
		
		/**
		 * 处罚金额
		*/
		public static final DBField PUNISH_SALARY = new DBField(DBDataType.DECIMAL , "punish_salary","punishSalary","处罚金额","处罚金额",false,false,true);
		
		/**
		 * 每日工资
		*/
		public static final DBField DAY_SALARY = new DBField(DBDataType.DECIMAL , "day_salary","daySalary","每日工资","每日工资",false,false,true);
		
		/**
		 * 扣除考勤
		*/
		public static final DBField DEDUCT_KQ = new DBField(DBDataType.DECIMAL , "deduct_kq","deductKq","扣除考勤","扣除考勤",false,false,true);
		
		/**
		 * 扣除工会
		*/
		public static final DBField DEDUCT_GH = new DBField(DBDataType.DECIMAL , "deduct_gh","deductGh","扣除工会","扣除工会",false,false,true);
		
		/**
		 * 扣除其他
		*/
		public static final DBField DEDUCT_OTHER = new DBField(DBDataType.DECIMAL , "deduct_other","deductOther","扣除其他","扣除其他",false,false,true);
		
		/**
		 * 个税抵扣
		*/
		public static final DBField DEDUCT_PERSONAL_TAX_RED = new DBField(DBDataType.DECIMAL , "deduct_personal_tax_red","deductPersonalTaxRed","个税抵扣","个税抵扣",false,false,true);
		
		/**
		 * 个人所得税
		*/
		public static final DBField PT_GRSDS = new DBField(DBDataType.DECIMAL , "pt_grsds","ptGrsds","个人所得税","个人所得税",false,false,true);
		
		/**
		 * 抵扣基数
		*/
		public static final DBField PT_DKJS = new DBField(DBDataType.DECIMAL , "pt_dkjs","ptDkjs","抵扣基数","抵扣基数",false,false,true);
		
		/**
		 * 绩效评级
		*/
		public static final DBField JXPJ_LEVEL = new DBField(DBDataType.STRING , "jxpj_level","jxpjLevel","绩效评级","绩效评级",false,false,true);
		
		/**
		 * 加班时长
		*/
		public static final DBField WORK_OVERTIME_H_CNT = new DBField(DBDataType.DECIMAL , "work_overtime_h_cnt","workOvertimeHCnt","加班时长","加班时长",false,false,true);
		
		/**
		 * 迟到次数
		*/
		public static final DBField LATE_CNT = new DBField(DBDataType.DECIMAL , "late_cnt","lateCnt","迟到次数","迟到次数",false,false,true);
		
		/**
		 * 出差次数
		*/
		public static final DBField BUSINESS_TRIPS_CNT = new DBField(DBDataType.DECIMAL , "business_trips_cnt","businessTripsCnt","出差次数","出差次数",false,false,true);
		
		/**
		 * 事假天数
		*/
		public static final DBField PERSONAL_LEAVE_CNT = new DBField(DBDataType.DECIMAL , "personal_leave_cnt","personalLeaveCnt","事假天数","事假天数",false,false,true);
		
		/**
		 * 年假天数
		*/
		public static final DBField ANNUAL_LEAVE_CNT = new DBField(DBDataType.DECIMAL , "annual_leave_cnt","annualLeaveCnt","年假天数","年假天数",false,false,true);
		
		/**
		 * 工作天数
		*/
		public static final DBField WORK_DAY_CNT = new DBField(DBDataType.DECIMAL , "work_day_cnt","workDayCnt","工作天数","工作天数",false,false,true);
		
		/**
		 * 税率
		*/
		public static final DBField PT_SL_PCT = new DBField(DBDataType.DECIMAL , "pt_sl_pct","ptSlPct","税率","税率",false,false,true);
		
		/**
		 * 住房公积金基数
		*/
		public static final DBField WELFARE_ZFGJJ_BASE = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_base","welfareZfgjjBase","住房公积金基数","住房公积金基数",false,false,true);
		
		/**
		 * 住房公积金个人
		*/
		public static final DBField WELFARE_ZFGJJ_PERSON = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_person","welfareZfgjjPerson","住房公积金个人","住房公积金个人",false,false,true);
		
		/**
		 * 住房公积金公司
		*/
		public static final DBField WELFARE_ZFGJJ_COMPANY = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_company","welfareZfgjjCompany","住房公积金公司","住房公积金公司",false,false,true);
		
		/**
		 * 住房缴费
		*/
		public static final DBField WELFARE_ZFGJJ_VALUE = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_value","welfareZfgjjValue","住房缴费","住房缴费",false,false,true);
		
		/**
		 * 养老保险基数
		*/
		public static final DBField WELFAER_YLBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_base","welfaerYlbxBase","养老保险基数","养老保险基数",false,false,true);
		
		/**
		 * 养老保险个人
		*/
		public static final DBField WELFAER_YLBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_person","welfaerYlbxPerson","养老保险个人","养老保险个人",false,false,true);
		
		/**
		 * 养老保险公司
		*/
		public static final DBField WELFAER_YLBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_company","welfaerYlbxCompany","养老保险公司","养老保险公司",false,false,true);
		
		/**
		 * 养老缴费
		*/
		public static final DBField WELFAER_YLBX_VALUE = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_value","welfaerYlbxValue","养老缴费","养老缴费",false,false,true);
		
		/**
		 * 工伤保险基数
		*/
		public static final DBField WELFAER_GSBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_base","welfaerGsbxBase","工伤保险基数","工伤保险基数",false,false,true);
		
		/**
		 * 工伤保险个人
		*/
		public static final DBField WELFAER_GSBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_person","welfaerGsbxPerson","工伤保险个人","工伤保险个人",false,false,true);
		
		/**
		 * 工伤保险公司
		*/
		public static final DBField WELFAER_GSBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_company","welfaerGsbxCompany","工伤保险公司","工伤保险公司",false,false,true);
		
		/**
		 * 工伤缴费
		*/
		public static final DBField WELFAER_GSBX_VALUE = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_value","welfaerGsbxValue","工伤缴费","工伤缴费",false,false,true);
		
		/**
		 * 医疗保险基数
		*/
		public static final DBField WELFAER_YRBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_base","welfaerYrbxBase","医疗保险基数","医疗保险基数",false,false,true);
		
		/**
		 * 医疗保险个人
		*/
		public static final DBField WELFAER_YRBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_person","welfaerYrbxPerson","医疗保险个人","医疗保险个人",false,false,true);
		
		/**
		 * 医疗保险公司
		*/
		public static final DBField WELFAER_YRBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_company","welfaerYrbxCompany","医疗保险公司","医疗保险公司",false,false,true);
		
		/**
		 * 医疗缴费
		*/
		public static final DBField WELFAER_YRBX_VALUE = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_value","welfaerYrbxValue","医疗缴费","医疗缴费",false,false,true);
		
		/**
		 * 生育保险基数
		*/
		public static final DBField WELFAER_SYBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_sybx_base","welfaerSybxBase","生育保险基数","生育保险基数",false,false,true);
		
		/**
		 * 生育保险个人
		*/
		public static final DBField WELFAER_SYBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_sybx_person","welfaerSybxPerson","生育保险个人","生育保险个人",false,false,true);
		
		/**
		 * 生育保险公司
		*/
		public static final DBField WELFAER_SYBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_sybx_company","welfaerSybxCompany","生育保险公司","生育保险公司",false,false,true);
		
		/**
		 * 生育缴费
		*/
		public static final DBField WELFAER_SYBX_VALUE = new DBField(DBDataType.DECIMAL , "welfaer_sybx_value","welfaerSybxValue","生育缴费","生育缴费",false,false,true);
		
		/**
		 * 失业保险基数
		*/
		public static final DBField WELFAER_SYEBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_syebx_base","welfaerSyebxBase","失业保险基数","失业保险基数",false,false,true);
		
		/**
		 * 失业保险个人
		*/
		public static final DBField WELFAER_SYEBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_syebx_person","welfaerSyebxPerson","失业保险个人","失业保险个人",false,false,true);
		
		/**
		 * 失业保险公司
		*/
		public static final DBField WELFAER_SYEBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_syebx_company","welfaerSyebxCompany","失业保险公司","失业保险公司",false,false,true);
		
		/**
		 * 失业缴费
		*/
		public static final DBField WELFAER_SYEBX_VALUE = new DBField(DBDataType.DECIMAL , "welfaer_syebx_value","welfaerSyebxValue","失业缴费","失业缴费",false,false,true);
		
		/**
		 * 个人缴费总计
		*/
		public static final DBField WELFAER_PERSON_VALUE_TOTAL = new DBField(DBDataType.DECIMAL , "welfaer_person_value_total","welfaerPersonValueTotal","个人缴费总计","个人缴费总计",false,false,true);
		
		/**
		 * 专项抵扣启用
		*/
		public static final DBField PERSONAL_STATUS = new DBField(DBDataType.STRING , "personal_status","personalStatus","专项抵扣启用","专项抵扣启用",false,false,true);
		
		/**
		 * 子女教育
		*/
		public static final DBField PERSONAL_TAX_ZNJY = new DBField(DBDataType.DECIMAL , "personal_tax_znjy","personalTaxZnjy","子女教育","子女教育",false,false,true);
		
		/**
		 * 继续教育
		*/
		public static final DBField PERSONAL_TAX_JXJY = new DBField(DBDataType.DECIMAL , "personal_tax_jxjy","personalTaxJxjy","继续教育","继续教育",false,false,true);
		
		/**
		 * 大病医疗
		*/
		public static final DBField PERSONAL_TAX_DBYL = new DBField(DBDataType.DECIMAL , "personal_tax_dbyl","personalTaxDbyl","大病医疗","大病医疗",false,false,true);
		
		/**
		 * 住房贷款
		*/
		public static final DBField PERSONAL_TAX_ZFDK = new DBField(DBDataType.DECIMAL , "personal_tax_zfdk","personalTaxZfdk","住房贷款","住房贷款",false,false,true);
		
		/**
		 * 住房租金
		*/
		public static final DBField PERSONAL_TAX_ZFZJ = new DBField(DBDataType.DECIMAL , "personal_tax_zfzj","personalTaxZfzj","住房租金","住房租金",false,false,true);
		
		/**
		 * 赡养老人
		*/
		public static final DBField PERSONAL_TAX_SYLR = new DBField(DBDataType.DECIMAL , "personal_tax_sylr","personalTaxSylr","赡养老人","赡养老人",false,false,true);
		
		/**
		 * 幼儿照护
		*/
		public static final DBField PERSONAL_TAX_ERZH = new DBField(DBDataType.DECIMAL , "personal_tax_erzh","personalTaxErzh","幼儿照护","幼儿照护",false,false,true);
		
		/**
		 * 专项扣除总计
		*/
		public static final DBField PERSONAL_TAX_TOTAL = new DBField(DBDataType.DECIMAL , "personal_tax_total","personalTaxTotal","专项扣除总计","专项扣除总计",false,false,true);
		
		/**
		 * 生效时间
		*/
		public static final DBField EFFECT_TIME = new DBField(DBDataType.DATE , "effect_time","effectTime","生效时间","生效时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 操作说明
		*/
		public static final DBField OPER_MSG = new DBField(DBDataType.STRING , "oper_msg","operMsg","操作说明","操作说明",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_DETAIL() {
			this.init($NAME,"薪酬明细" , ID , USER_NAME , ACTION_MONTH , PERSON_ID , JOB_NUMBER , ORG_ID , BANK , BANK_ACCOUNT , TPL_ID , ACTION_ID , STATUS , TOTAL_AMOUNT , PAY_AMOUNT , ISSUED_AMOUNT , BASE_SALARY , POST_SALARY , WORKING_YEARS_SALARY , FIXED_SALARY , ACHIEVEMENT_SALARY , OVERTIME_SALARY , COMMUNICATION_SALARY , TRAFFIC_SALARY , HOUSING_SALARY , HIGH_TEMPERATURE_SALARY , OTHER_SALARY , COMMISSION_SALARY , UNIT_TIME_SALARY , UNIT_NUMBER_SALARY , PUNISH_SALARY , DAY_SALARY , DEDUCT_KQ , DEDUCT_GH , DEDUCT_OTHER , DEDUCT_PERSONAL_TAX_RED , PT_GRSDS , PT_DKJS , JXPJ_LEVEL , WORK_OVERTIME_H_CNT , LATE_CNT , BUSINESS_TRIPS_CNT , PERSONAL_LEAVE_CNT , ANNUAL_LEAVE_CNT , WORK_DAY_CNT , PT_SL_PCT , WELFARE_ZFGJJ_BASE , WELFARE_ZFGJJ_PERSON , WELFARE_ZFGJJ_COMPANY , WELFARE_ZFGJJ_VALUE , WELFAER_YLBX_BASE , WELFAER_YLBX_PERSON , WELFAER_YLBX_COMPANY , WELFAER_YLBX_VALUE , WELFAER_GSBX_BASE , WELFAER_GSBX_PERSON , WELFAER_GSBX_COMPANY , WELFAER_GSBX_VALUE , WELFAER_YRBX_BASE , WELFAER_YRBX_PERSON , WELFAER_YRBX_COMPANY , WELFAER_YRBX_VALUE , WELFAER_SYBX_BASE , WELFAER_SYBX_PERSON , WELFAER_SYBX_COMPANY , WELFAER_SYBX_VALUE , WELFAER_SYEBX_BASE , WELFAER_SYEBX_PERSON , WELFAER_SYEBX_COMPANY , WELFAER_SYEBX_VALUE , WELFAER_PERSON_VALUE_TOTAL , PERSONAL_STATUS , PERSONAL_TAX_ZNJY , PERSONAL_TAX_JXJY , PERSONAL_TAX_DBYL , PERSONAL_TAX_ZFDK , PERSONAL_TAX_ZFZJ , PERSONAL_TAX_SYLR , PERSONAL_TAX_ERZH , PERSONAL_TAX_TOTAL , EFFECT_TIME , NOTES , BATCH_CODE , OPER_MSG , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_DETAIL $TABLE=new HR_SALARY_DETAIL();
	}
	
	/**
	 * 所得税设置
	*/
	public static class HR_SALARY_INCOME_TAX extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_income_tax";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 级别
		*/
		public static final DBField VALUE_LEVEL = new DBField(DBDataType.STRING , "value_level","valueLevel","级别","级别",false,false,true);
		
		/**
		 * 起始金额
		*/
		public static final DBField START = new DBField(DBDataType.DECIMAL , "start","start","起始金额","起始金额",false,false,true);
		
		/**
		 * 结束金额
		*/
		public static final DBField END = new DBField(DBDataType.DECIMAL , "end","end","结束金额","结束金额",false,false,true);
		
		/**
		 * 税率
		*/
		public static final DBField TAX = new DBField(DBDataType.DECIMAL , "tax","tax","税率","税率",false,false,true);
		
		/**
		 * 速扣
		*/
		public static final DBField QUICK_DEDUCT = new DBField(DBDataType.DECIMAL , "quick_deduct","quickDeduct","速扣","速扣",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_INCOME_TAX() {
			this.init($NAME,"所得税设置" , ID , VALUE_LEVEL , START , END , TAX , QUICK_DEDUCT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_INCOME_TAX $TABLE=new HR_SALARY_INCOME_TAX();
	}
	
	/**
	 * 薪酬月份
	*/
	public static class HR_SALARY_MONTH extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_month";
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_MONTH() {
			this.init($NAME,"薪酬月份" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_MONTH $TABLE=new HR_SALARY_MONTH();
	}
	
	/**
	 * 项目提成
	*/
	public static class HR_SALARY_PROJECT_COMMISSION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_project_commission";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 项目编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","项目编码","项目编码",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","项目名称","项目名称",false,false,true);
		
		/**
		 * 提成比例
		*/
		public static final DBField COMMISSION_RATIO = new DBField(DBDataType.DECIMAL , "commission_ratio","commissionRatio","提成比例","提成比例",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_PROJECT_COMMISSION() {
			this.init($NAME,"项目提成" , ID , CODE , NAME , COMMISSION_RATIO , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_PROJECT_COMMISSION $TABLE=new HR_SALARY_PROJECT_COMMISSION();
	}
	
	/**
	 * 项目提成记录
	*/
	public static class HR_SALARY_PROJECT_COMMISSION_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_project_commission_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 项目编码
		*/
		public static final DBField PROJECT_CODE = new DBField(DBDataType.STRING , "project_code","projectCode","项目编码","项目编码",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目名称","项目名称",false,false,true);
		
		/**
		 * 提成比例
		*/
		public static final DBField PROJECT_COMMISSION_RATIO = new DBField(DBDataType.STRING , "project_commission_ratio","projectCommissionRatio","提成比例","提成比例",false,false,true);
		
		/**
		 * 业务量
		*/
		public static final DBField BUSINESS_VALUE = new DBField(DBDataType.DECIMAL , "business_value","businessValue","业务量","业务量",false,false,true);
		
		/**
		 * 提成金额
		*/
		public static final DBField COMMISSION_SALARY = new DBField(DBDataType.DECIMAL , "commission_salary","commissionSalary","提成金额","提成金额",false,false,true);
		
		/**
		 * 记录日期
		*/
		public static final DBField RCD_DATE = new DBField(DBDataType.DATE , "rcd_date","rcdDate","记录日期","记录日期",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_PROJECT_COMMISSION_RCD() {
			this.init($NAME,"项目提成记录" , ID , PERSON_ID , JOB_NUMBER , PROJECT_CODE , PROJECT_NAME , PROJECT_COMMISSION_RATIO , BUSINESS_VALUE , COMMISSION_SALARY , RCD_DATE , BATCH_CODE , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_PROJECT_COMMISSION_RCD $TABLE=new HR_SALARY_PROJECT_COMMISSION_RCD();
	}
	
	/**
	 * 计时项目
	*/
	public static class HR_SALARY_PROJECT_TIME extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_project_time";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 项目编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","项目编码","项目编码",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","项目名称","项目名称",false,false,true);
		
		/**
		 * 计时单价
		*/
		public static final DBField MONEY = new DBField(DBDataType.DECIMAL , "money","money","计时单价","计时单价",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_PROJECT_TIME() {
			this.init($NAME,"计时项目" , ID , CODE , NAME , MONEY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_PROJECT_TIME $TABLE=new HR_SALARY_PROJECT_TIME();
	}
	
	/**
	 * 计时项目记录
	*/
	public static class HR_SALARY_PROJECT_TIME_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_project_time_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 项目编码
		*/
		public static final DBField PROJECT_CODE = new DBField(DBDataType.STRING , "project_code","projectCode","项目编码","项目编码",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目名称","项目名称",false,false,true);
		
		/**
		 * 计时单价
		*/
		public static final DBField PROJECT_UNIT_PRICE = new DBField(DBDataType.DECIMAL , "project_unit_price","projectUnitPrice","计时单价","计时单价",false,false,true);
		
		/**
		 * 工时
		*/
		public static final DBField FINISH_HOUR = new DBField(DBDataType.DECIMAL , "finish_hour","finishHour","工时","工时",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField TOTAL_PRICE = new DBField(DBDataType.DECIMAL , "total_price","totalPrice","总金额","总金额",false,false,true);
		
		/**
		 * 记录日期
		*/
		public static final DBField RCD_DATE = new DBField(DBDataType.DATE , "rcd_date","rcdDate","记录日期","记录日期",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_PROJECT_TIME_RCD() {
			this.init($NAME,"计时项目记录" , ID , PERSON_ID , JOB_NUMBER , PROJECT_CODE , PROJECT_NAME , PROJECT_UNIT_PRICE , FINISH_HOUR , TOTAL_PRICE , RCD_DATE , BATCH_CODE , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_PROJECT_TIME_RCD $TABLE=new HR_SALARY_PROJECT_TIME_RCD();
	}
	
	/**
	 * 计件项目
	*/
	public static class HR_SALARY_PROJECT_UNIT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_project_unit";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 项目编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","项目编码","项目编码",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","项目名称","项目名称",false,false,true);
		
		/**
		 * 计件单价
		*/
		public static final DBField MONEY = new DBField(DBDataType.DECIMAL , "money","money","计件单价","计件单价",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_PROJECT_UNIT() {
			this.init($NAME,"计件项目" , ID , CODE , NAME , MONEY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_PROJECT_UNIT $TABLE=new HR_SALARY_PROJECT_UNIT();
	}
	
	/**
	 * 计件项目记录
	*/
	public static class HR_SALARY_PROJECT_UNIT_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_project_unit_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 项目编码
		*/
		public static final DBField PROJECT_CODE = new DBField(DBDataType.STRING , "project_code","projectCode","项目编码","项目编码",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目名称","项目名称",false,false,true);
		
		/**
		 * 项目单价
		*/
		public static final DBField PROJECT_UNIT_PRICE = new DBField(DBDataType.DECIMAL , "project_unit_price","projectUnitPrice","项目单价","项目单价",false,false,true);
		
		/**
		 * 完成数量
		*/
		public static final DBField FINISH_NUMBER = new DBField(DBDataType.DECIMAL , "finish_number","finishNumber","完成数量","完成数量",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField TOTAL_PRICE = new DBField(DBDataType.DECIMAL , "total_price","totalPrice","总金额","总金额",false,false,true);
		
		/**
		 * 记录日期
		*/
		public static final DBField RCD_DATE = new DBField(DBDataType.DATE , "rcd_date","rcdDate","记录日期","记录日期",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","附件","附件",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_PROJECT_UNIT_RCD() {
			this.init($NAME,"计件项目记录" , ID , PERSON_ID , JOB_NUMBER , PROJECT_CODE , PROJECT_NAME , PROJECT_UNIT_PRICE , FINISH_NUMBER , TOTAL_PRICE , RCD_DATE , BATCH_CODE , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_PROJECT_UNIT_RCD $TABLE=new HR_SALARY_PROJECT_UNIT_RCD();
	}
	
	/**
	 * 薪酬税率
	*/
	public static class HR_SALARY_TAX_PCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_tax_pct";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 最小
		*/
		public static final DBField MIN = new DBField(DBDataType.STRING , "min","min","最小","最小",false,false,true);
		
		/**
		 * 最小包含
		*/
		public static final DBField MIN_INCLUDE = new DBField(DBDataType.STRING , "min_include","minInclude","最小包含","最小包含",false,false,true);
		
		/**
		 * 最大
		*/
		public static final DBField MAX = new DBField(DBDataType.DECIMAL , "max","max","最大","最大",false,false,true);
		
		/**
		 * 最大包含
		*/
		public static final DBField MAX_INCLUDE = new DBField(DBDataType.STRING , "max_include","maxInclude","最大包含","最大包含",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_TAX_PCT() {
			this.init($NAME,"薪酬税率" , ID , NAME , MIN , MIN_INCLUDE , MAX , MAX_INCLUDE , NOTES , SORT , TENANT_ID);
		}
		public static final HR_SALARY_TAX_PCT $TABLE=new HR_SALARY_TAX_PCT();
	}
	
	/**
	 * 薪酬模版
	*/
	public static class HR_SALARY_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_tpl";
		
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
		 * 开始上月
		*/
		public static final DBField START_M_DAY = new DBField(DBDataType.INTEGER , "start_m_day","startMDay","开始上月","开始上月",false,false,true);
		
		/**
		 * 结束本月
		*/
		public static final DBField END_M_DAY = new DBField(DBDataType.INTEGER , "end_m_day","endMDay","结束本月","结束本月",false,false,true);
		
		/**
		 * 计算公式
		*/
		public static final DBField METHOD = new DBField(DBDataType.STRING , "method","method","计算公式","计算公式",false,false,true);
		
		/**
		 * 计算公式
		*/
		public static final DBField METHOD_SCRIPT = new DBField(DBDataType.STRING , "method_script","methodScript","计算公式","计算公式",false,false,true);
		
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
		
		public HR_SALARY_TPL() {
			this.init($NAME,"薪酬模版" , ID , CODE , NAME , START_M_DAY , END_M_DAY , METHOD , METHOD_SCRIPT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_TPL $TABLE=new HR_SALARY_TPL();
	}
	
	/**
	 * 计算项目
	*/
	public static class HR_SALARY_TPL_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_tpl_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 计算顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","计算顺序","计算顺序",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
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
		 * 公式
		*/
		public static final DBField EXPRESSION_VALUE = new DBField(DBDataType.STRING , "expression_value","expressionValue","公式","公式",false,false,true);
		
		/**
		 * 公式
		*/
		public static final DBField EXPRESSION_SHOW = new DBField(DBDataType.STRING , "expression_show","expressionShow","公式","公式",false,false,true);
		
		/**
		 * 包含公式
		*/
		public static final DBField INCLUDE_EXPRESSION = new DBField(DBDataType.STRING , "include_expression","includeExpression","包含公式","包含公式",false,false,true);
		
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
		
		public HR_SALARY_TPL_ITEM() {
			this.init($NAME,"计算项目" , ID , SORT , TPL_ID , CODE , NAME , STATUS , EXPRESSION_VALUE , EXPRESSION_SHOW , INCLUDE_EXPRESSION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_TPL_ITEM $TABLE=new HR_SALARY_TPL_ITEM();
	}
	
	/**
	 * 薪酬人员
	*/
	public static class HR_SALARY_TPL_PERSON extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_tpl_person";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
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
		
		public HR_SALARY_TPL_PERSON() {
			this.init($NAME,"薪酬人员" , ID , TPL_ID , PERSON_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_TPL_PERSON $TABLE=new HR_SALARY_TPL_PERSON();
	}
	
	/**
	 * 评价指标
	*/
	public static class HR_SCORE_INDICATOR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_indicator";
		
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
		 * 权重
		*/
		public static final DBField WEIGHT = new DBField(DBDataType.DECIMAL , "weight","weight","权重","权重",false,false,true);
		
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
		
		public HR_SCORE_INDICATOR() {
			this.init($NAME,"评价指标" , ID , NAME , STATUS , WEIGHT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SCORE_INDICATOR $TABLE=new HR_SCORE_INDICATOR();
	}
	
	/**
	 * 任务单
	*/
	public static class HR_SCORE_TASK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_task";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField CREATE_OWNER_ID = new DBField(DBDataType.STRING , "create_owner_id","createOwnerId","所属","所属",false,false,true);
		
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
		
		public HR_SCORE_TASK() {
			this.init($NAME,"任务单" , ID , NAME , USER_ID , STATUS , NOTES , CREATE_OWNER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SCORE_TASK $TABLE=new HR_SCORE_TASK();
	}
	
	/**
	 * 任务配置
	*/
	public static class HR_SCORE_TASK_CONF extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_task_conf";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 关系
		*/
		public static final DBField RELATIONSHIP = new DBField(DBDataType.STRING , "relationship","relationship","关系","关系",false,false,true);
		
		/**
		 * 评分卷
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","评分卷","评分卷",false,false,true);
		
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
		
		public HR_SCORE_TASK_CONF() {
			this.init($NAME,"任务配置" , ID , NAME , RELATIONSHIP , TPL_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SCORE_TASK_CONF $TABLE=new HR_SCORE_TASK_CONF();
	}
	
	/**
	 * 任务单明细
	*/
	public static class HR_SCORE_TASK_DTL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_task_dtl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 任务单
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","任务单","任务单",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 评分人
		*/
		public static final DBField RATER_ID = new DBField(DBDataType.STRING , "rater_id","raterId","评分人","评分人",false,false,true);
		
		/**
		 * 被评分人
		*/
		public static final DBField RATED_ID = new DBField(DBDataType.STRING , "rated_id","ratedId","被评分人","被评分人",false,false,true);
		
		/**
		 * 总分
		*/
		public static final DBField TOTAL_SCORE = new DBField(DBDataType.DECIMAL , "total_score","totalScore","总分","总分",false,false,true);
		
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
		
		public HR_SCORE_TASK_DTL() {
			this.init($NAME,"任务单明细" , ID , TASK_ID , TPL_ID , STATUS , RATER_ID , RATED_ID , TOTAL_SCORE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SCORE_TASK_DTL $TABLE=new HR_SCORE_TASK_DTL();
	}
	
	/**
	 * 任务配置记录
	*/
	public static class HR_SCORE_TASK_INST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_task_inst";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 任务
		*/
		public static final DBField CONF_ID = new DBField(DBDataType.STRING , "conf_id","confId","任务","任务",false,false,true);
		
		/**
		 * 评分卷
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","评分卷","评分卷",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 关系
		*/
		public static final DBField RELATIONSHIP = new DBField(DBDataType.STRING , "relationship","relationship","关系","关系",false,false,true);
		
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
		
		public HR_SCORE_TASK_INST() {
			this.init($NAME,"任务配置记录" , ID , CONF_ID , TPL_ID , NAME , RELATIONSHIP , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_SCORE_TASK_INST $TABLE=new HR_SCORE_TASK_INST();
	}
	
	/**
	 * 任务部门
	*/
	public static class HR_SCORE_TASK_ORG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_task_org";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 任务
		*/
		public static final DBField CONFIG_ID = new DBField(DBDataType.STRING , "config_id","configId","任务","任务",false,false,true);
		
		/**
		 * 关系
		*/
		public static final DBField RELATIONSHIP = new DBField(DBDataType.STRING , "relationship","relationship","关系","关系",false,false,true);
		
		/**
		 * 包含部门
		*/
		public static final DBField ORG_INCLUDE = new DBField(DBDataType.STRING , "org_include","orgInclude","包含部门","包含部门",false,false,true);
		
		/**
		 * 排除部门
		*/
		public static final DBField ORG_EXCLUDE = new DBField(DBDataType.STRING , "org_exclude","orgExclude","排除部门","排除部门",false,false,true);
		
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
		
		public HR_SCORE_TASK_ORG() {
			this.init($NAME,"任务部门" , ID , CONFIG_ID , RELATIONSHIP , ORG_INCLUDE , ORG_EXCLUDE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_SCORE_TASK_ORG $TABLE=new HR_SCORE_TASK_ORG();
	}
	
	/**
	 * 任务用户
	*/
	public static class HR_SCORE_TASK_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_task_user";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 任务
		*/
		public static final DBField INST_ID = new DBField(DBDataType.STRING , "inst_id","instId","任务","任务",false,false,true);
		
		/**
		 * 关系
		*/
		public static final DBField RELATIONSHIP = new DBField(DBDataType.STRING , "relationship","relationship","关系","关系",false,false,true);
		
		/**
		 * 包含用户
		*/
		public static final DBField USER_INCLUDE = new DBField(DBDataType.STRING , "user_include","userInclude","包含用户","包含用户",false,false,true);
		
		/**
		 * 排除用户
		*/
		public static final DBField USER_EXCLUDE = new DBField(DBDataType.STRING , "user_exclude","userExclude","排除用户","排除用户",false,false,true);
		
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
		
		public HR_SCORE_TASK_USER() {
			this.init($NAME,"任务用户" , ID , INST_ID , RELATIONSHIP , USER_INCLUDE , USER_EXCLUDE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_SCORE_TASK_USER $TABLE=new HR_SCORE_TASK_USER();
	}
	
	/**
	 * 评分模版
	*/
	public static class HR_SCORE_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_tpl";
		
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
		 * 说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","说明","说明",false,false,true);
		
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
		
		public HR_SCORE_TPL() {
			this.init($NAME,"评分模版" , ID , NAME , STATUS , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SCORE_TPL $TABLE=new HR_SCORE_TPL();
	}
	
	/**
	 * 评分项目
	*/
	public static class HR_SCORE_TPL_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_tpl_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 组件类型
		*/
		public static final DBField ITEM_TYPE = new DBField(DBDataType.STRING , "item_type","itemType","组件类型","组件类型",false,false,true);
		
		/**
		 * 题目
		*/
		public static final DBField ITEM_NAME = new DBField(DBDataType.STRING , "item_name","itemName","题目","题目",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","指标","指标",false,false,true);
		
		/**
		 * 最小分
		*/
		public static final DBField MIN_SCORE = new DBField(DBDataType.DECIMAL , "min_score","minScore","最小分","最小分",false,false,true);
		
		/**
		 * 最大分
		*/
		public static final DBField MAX_SCORE = new DBField(DBDataType.DECIMAL , "max_score","maxScore","最大分","最大分",false,false,true);
		
		/**
		 * 默认分
		*/
		public static final DBField DEF_SCORE = new DBField(DBDataType.DECIMAL , "def_score","defScore","默认分","默认分",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SN = new DBField(DBDataType.INTEGER , "sn","sn","排序","排序",false,false,true);
		
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
		
		public HR_SCORE_TPL_ITEM() {
			this.init($NAME,"评分项目" , ID , TPL_ID , ITEM_TYPE , ITEM_NAME , GROUP_ID , MIN_SCORE , MAX_SCORE , DEF_SCORE , SN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SCORE_TPL_ITEM $TABLE=new HR_SCORE_TPL_ITEM();
	}
	
	/**
	 * 评分明细
	*/
	public static class HR_SCORE_TPL_ITEM_VALUE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_tpl_item_value";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","所属","所属",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 评分项
		*/
		public static final DBField TPL_ITEM_ID = new DBField(DBDataType.STRING , "tpl_item_id","tplItemId","评分项","评分项",false,false,true);
		
		/**
		 * 组件类型
		*/
		public static final DBField ITEM_TYPE = new DBField(DBDataType.STRING , "item_type","itemType","组件类型","组件类型",false,false,true);
		
		/**
		 * 题目
		*/
		public static final DBField ITEM_NAME = new DBField(DBDataType.STRING , "item_name","itemName","题目","题目",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","指标","指标",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField GROUP_NAME = new DBField(DBDataType.STRING , "group_name","groupName","指标","指标",false,false,true);
		
		/**
		 * 最小分
		*/
		public static final DBField MIN_SCORE = new DBField(DBDataType.DECIMAL , "min_score","minScore","最小分","最小分",false,false,true);
		
		/**
		 * 最大分
		*/
		public static final DBField MAX_SCORE = new DBField(DBDataType.DECIMAL , "max_score","maxScore","最大分","最大分",false,false,true);
		
		/**
		 * 默认分
		*/
		public static final DBField DEF_SCORE = new DBField(DBDataType.DECIMAL , "def_score","defScore","默认分","默认分",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SN = new DBField(DBDataType.INTEGER , "sn","sn","排序","排序",false,false,true);
		
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
		
		public HR_SCORE_TPL_ITEM_VALUE() {
			this.init($NAME,"评分明细" , ID , TASK_ID , TPL_ID , TPL_ITEM_ID , ITEM_TYPE , ITEM_NAME , GROUP_ID , GROUP_NAME , MIN_SCORE , MAX_SCORE , DEF_SCORE , SN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SCORE_TPL_ITEM_VALUE $TABLE=new HR_SCORE_TPL_ITEM_VALUE();
	}
	
	/**
	 * 考评用户
	*/
	public static class HR_SCORE_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_score_user";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 任务
		*/
		public static final DBField INST_ID = new DBField(DBDataType.STRING , "inst_id","instId","任务","任务",false,false,true);
		
		/**
		 * 部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","部门","部门",false,false,true);
		
		/**
		 * 关系
		*/
		public static final DBField RELATIONSHIP = new DBField(DBDataType.STRING , "relationship","relationship","关系","关系",false,false,true);
		
		/**
		 * 考评卷
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","考评卷","考评卷",false,false,true);
		
		/**
		 * 评价人
		*/
		public static final DBField RATER_ID = new DBField(DBDataType.STRING , "rater_id","raterId","评价人","评价人",false,false,true);
		
		/**
		 * 被评价人
		*/
		public static final DBField RATED_ID = new DBField(DBDataType.STRING , "rated_id","ratedId","被评价人","被评价人",false,false,true);
		
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
		
		public HR_SCORE_USER() {
			this.init($NAME,"考评用户" , ID , INST_ID , ORG_ID , RELATIONSHIP , TPL_ID , RATER_ID , RATED_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_SCORE_USER $TABLE=new HR_SCORE_USER();
	}
	
	/**
	 * 培训机构
	*/
	public static class HR_TRAINING_INSTITUTION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_training_institution";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 机构名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","机构名称","机构名称",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACT = new DBField(DBDataType.STRING , "contact","contact","联系人","联系人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 机构介绍
		*/
		public static final DBField PROFILE = new DBField(DBDataType.STRING , "profile","profile","机构介绍","机构介绍",false,false,true);
		
		/**
		 * 网址
		*/
		public static final DBField WEBSITE = new DBField(DBDataType.STRING , "website","website","网址","网址",false,false,true);
		
		/**
		 * 培训经历
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","培训经历","培训经历",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_TRAINING_INSTITUTION() {
			this.init($NAME,"培训机构" , ID , NAME , CONTACT , CONTACT_INFORMATION , PROFILE , WEBSITE , CONTENT , NOTES , FILE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_TRAINING_INSTITUTION $TABLE=new HR_TRAINING_INSTITUTION();
	}
	
	/**
	 * 培训讲师
	*/
	public static class HR_TRAINING_INSTRUCTOR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_training_instructor";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 工作单位
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","工作单位","工作单位",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 社会头衔
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","社会头衔","社会头衔",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_TRAINING_INSTRUCTOR() {
			this.init($NAME,"培训讲师" , ID , ORG_ID , NAME , TITLE , CONTACT_INFORMATION , NOTES , FILE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_TRAINING_INSTRUCTOR $TABLE=new HR_TRAINING_INSTRUCTOR();
	}
	
	/**
	 * 人员休假
	*/
	public static class HR_VACATION_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_vacation_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 休假类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","休假类型","休假类型",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","时长","时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_VACATION_DATA() {
			this.init($NAME,"人员休假" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , TYPE , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_VACATION_DATA $TABLE=new HR_VACATION_DATA();
	}
	
	/**
	 * 人员加班
	*/
	public static class HR_WORK_OVERTIME_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_work_overtime_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 加班时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","加班时长","加班时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_WORK_OVERTIME_DATA() {
			this.init($NAME,"人员加班" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_WORK_OVERTIME_DATA $TABLE=new HR_WORK_OVERTIME_DATA();
	}
}