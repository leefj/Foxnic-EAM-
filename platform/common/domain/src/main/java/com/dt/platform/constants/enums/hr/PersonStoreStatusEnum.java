package com.dt.platform.constants.enums.hr;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum PersonStoreStatusEnum implements CodeTextEnum {

	ACCESS("access" , "通过"),
	NOT_PARTICIPATING ("not_participating" , "未参加"),
	VERY_GOOD ("very_good" , "很好"),
	GOOD ("good" , "好"),
	BAD ("bad" , "差"),
	VERY_BAD ("very_bad" , "较差"),
	NOT_ADMITTED ("not_admitted" , "不录取");
	private String code;
	private String text;
	private PersonStoreStatusEnum(String code, String text)  {
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