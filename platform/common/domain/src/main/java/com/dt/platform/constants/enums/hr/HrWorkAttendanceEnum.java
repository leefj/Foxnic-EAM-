package com.dt.platform.constants.enums.hr;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum HrWorkAttendanceEnum implements CodeTextEnum {

	TYPE_JB("type_jb" , "加班"),
	TYPE_NJ("type_nj" , "年假"),
	TYPE_SJ("type_sj" , "事假"),
	TYPE_BJ("type_bj" , "病假"),
	TYPE_CC("type_cc" , "出差"),
	TYPE_OTHER("type_other" , "其他");

	private String code;
	private String text;
	private HrWorkAttendanceEnum(String code, String text)  {
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