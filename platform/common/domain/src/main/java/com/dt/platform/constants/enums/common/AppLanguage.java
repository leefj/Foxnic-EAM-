package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;
import org.github.foxnic.web.language.Language;


/**
 * @since 2022-08-13 12:52:07
 * @author 李方捷 , leefangjie@qq.com
 * 从 select distinct code,name from sys_config WHERE deleted=0 and code like 'webfull%' 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum AppLanguage implements CodeTextEnum {

	/**
	 * WebFull名称
	*/
	en(Language.en_gb),cn(Language.zh_cn);
	private Language language;
	private String text;
	private AppLanguage(Language language)  {
		this.language=language;
		this.text=language.text();
	}

	public Language language() {
		return language;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	/**
	 * 从字符串转换成当前枚举类型
	*/
	public static AppLanguage parseByCode(String code) {
		return (AppLanguage) EnumUtil.parseByCode(AppLanguage.values(),code);
	}
}
