package com.dt.platform.constants.enums.oa;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum ScheduleRankEnum implements CodeTextEnum {

	EMERGENT("emergent" , "紧急"),
	IMPORTANT("important" , "重要"),
	SECONDARY("secondary" , "次要"),
	NOT_IMPORTANT("not_important" , "不重要"),
	NONE("none" , "无优先级")
	;
	private String code;
	private String text;
	private ScheduleRankEnum(String code, String text)  {
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