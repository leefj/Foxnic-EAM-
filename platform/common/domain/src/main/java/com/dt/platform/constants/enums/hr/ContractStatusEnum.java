package com.dt.platform.constants.enums.hr;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum ContractStatusEnum implements CodeTextEnum {

	INSERT("insert" , "录入"),
	APPROVAL("approval" , "送审中"),
	RETURNED("returned" , "已退回"),
	ACTING("acting" , "生效中"),
	TRYING("trying" , "试用中"),
	TRIAL_EXPIRED("trial_expired" , "试用到期"),
	RELEASED("released" , "已解除"),
	CLOSED("closed" , "已到期")
	;
	private String code;
	private String text;
	private ContractStatusEnum(String code, String text)  {
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