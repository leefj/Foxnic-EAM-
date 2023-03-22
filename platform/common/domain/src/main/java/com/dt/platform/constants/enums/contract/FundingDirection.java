package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同资金状态
 * */
public enum FundingDirection implements CodeTextEnum {


	COLLECT("collect" , "收款"),
	PAY("pay" , "付款"),
	NONE("none" , "不结算");

	private String code;
	private String text;
	private FundingDirection(String code, String text)  {
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
	public static FundingDirection parseByCode(String code) {
		return (FundingDirection) EnumUtil.parseByCode(FundingDirection.values(),code);
	}
}
