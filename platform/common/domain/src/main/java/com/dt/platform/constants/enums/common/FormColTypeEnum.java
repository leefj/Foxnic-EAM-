package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum FormColTypeEnum implements CodeTextEnum {

	TYPE_S_STRING("s_string" , "短字符串(100)"),
	TYPE_STRING("string" , "字符串(300)"),
	TYPE_L_STRING("l_string" , "长字符串(1500)"),
	TYPE_TEXT("text" , "文本"),
	TYPE_DATETIME("datetime" , "时间"),
	TYPE_INT("int" , "整形"),
	TYPE_DECIMAL("decimal" , "浮点"),
	;
	private String code;
	private String text;
	private FormColTypeEnum(String code, String text)  {
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