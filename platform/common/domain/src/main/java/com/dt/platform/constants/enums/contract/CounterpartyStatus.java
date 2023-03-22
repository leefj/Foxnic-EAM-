package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同签订方类型
 * */
public enum CounterpartyStatus implements CodeTextEnum {


	VALID("valid" , "有效"),
	INVALID("invalid" , "无效")
	;

	private String code;
	private String text;
	private CounterpartyStatus(String code, String text)  {
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
	public static CounterpartyStatus parseByCode(String code) {
		return (CounterpartyStatus) EnumUtil.parseByCode(CounterpartyStatus.values(),code);
	}
}
