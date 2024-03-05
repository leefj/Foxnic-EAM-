package com.dt.platform.constants.enums.hr;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssessmentCycleEnum implements CodeTextEnum {

	FULL_YEAR("full_yar" , "年度"),
	FIRST_QUARTER("first_quarter" , "第一季度"),
	SECOND_QUARTER("second_quarter" , "第二季度"),
	THIRD_QUARTER("third_quarter" , "第三季度"),
	FOURTH_QUARTER("fourth_quarter" , "第四季度");


	private String code;
	private String text;
	private AssessmentCycleEnum(String code, String text)  {
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