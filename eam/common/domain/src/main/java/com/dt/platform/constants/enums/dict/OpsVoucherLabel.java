package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2021-09-29 11:26:59
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsVoucherLabel {
	
	/**
	 * 生产
	*/
	PROD("prod" , "生产"),
	
	/**
	 * 测试
	*/
	TEST("test" , "测试"),
	
	/**
	 * 开发
	*/
	DEV("dev" , "开发"),
	;
	
	private String code;
	private String text;
	private OpsVoucherLabel(String code,String text)  {
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
	public static OpsVoucherLabel parseByCode(String code) {
		return (OpsVoucherLabel) EnumUtil.parseByCode(OpsVoucherLabel.values(),code);
	}
}