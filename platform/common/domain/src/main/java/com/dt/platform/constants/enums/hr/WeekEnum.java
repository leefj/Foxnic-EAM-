package com.dt.platform.constants.enums.hr;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum WeekEnum implements CodeTextEnum {

	W1("w1" , "周一"),
	W2("w2" , "周二"),
	W3("w3" , "周三"),
	W4("w4" , "周四"),
	W5("w5" , "周五"),
	W6("w6" , "周六"),
	W7("w7" , "周日");

	private String code;
	private String text;
	private WeekEnum(String code, String text)  {
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