package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum MonitorMethodEnum implements CodeTextEnum {

    ZABBIX_AGENT("zabbix_agent" , "Zabbix客户端取数"),
    MYSQL_JDBC("mysql_jdbc" , "MySQL_JDBC"),
    ORACLE_JDBC("oracle_jdbc" , "Oracle_JDBC"),
    DB2_JDBC("db2_jdbc" , "DB2_JDBC"),
    PG_JDBC("pg_jdbc" , "PG_JDBC"),
    OB_ORACLE_JDBC("ob_oracle_jdbc" , "OB_Oracle_JDBC"),
    OB_MYSQL_JDBC("ob_mysql_jdbc" , "OB_MySQL_JDBC"),
    SQLSERVER_JDBC("sqlserver_jdbc" , "SqlServer_JDBC"),
    SNMP("snmp" , "SNMP"),
    SCRIPT("script" , "脚本取数"),
    CALCULATED_BY_CODE("calculated_by_code" , "计算取数");
    private String code;
    private String text;
    private MonitorMethodEnum(String code, String text)  {
        this.code=code;
        this.text=text;
    }

    public String code() {
        return code;
    }

    public String text() {
        return text;
    }
}