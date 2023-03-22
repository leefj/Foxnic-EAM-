package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同签订方类型
 * */
public enum CounterpartyClass implements CodeTextEnum {



	ENTERPRISE("enterprise" , "企业"),
	PERSON("person" , "个人");

	private String code;
	private String text;
	private CounterpartyClass(String code, String text)  {
		this.code=code;
		this.text=text;
	}

	public String code() {
		return code;
	}

	public String text() {
		return text;
	}

	/**
	 * 从字符串转换成当前枚举类型
	*/
	public static CounterpartyClass parseByCode(String code) {
		return (CounterpartyClass) EnumUtil.parseByCode(CounterpartyClass.values(),code);
	}
}
