package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同签订方类型
 * */
public enum ContractPerformanceAction implements CodeTextEnum {




	NOT_AGREEMENT("not_agreement" , "未履约"),
	AGREEMENT("agreement" , "已履约");

	private String code;
	private String text;
	private ContractPerformanceAction(String code, String text)  {
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
	public static ContractPerformanceAction parseByCode(String code) {
		return (ContractPerformanceAction) EnumUtil.parseByCode(ContractPerformanceAction.values(),code);
	}
}
