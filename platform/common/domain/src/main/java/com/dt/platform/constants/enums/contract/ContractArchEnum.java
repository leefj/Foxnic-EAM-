package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同类型
 * */
public enum ContractArchEnum implements CodeTextEnum {

	/**
	 * 主合同
	*/
	Y("Y" , "归档"),

	/**
	 * 子合同
	*/
	N("N" , "未归档")
//
//	/**
//	 * 附加协议
//	 */
//	ADDI("addi" , "附加协议")
	;

	private String code;
	private String text;
	private ContractArchEnum(String code, String text)  {
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
	public static ContractArchEnum parseByCode(String code) {
		return (ContractArchEnum) EnumUtil.parseByCode(ContractArchEnum.values(),code);
	}
}
