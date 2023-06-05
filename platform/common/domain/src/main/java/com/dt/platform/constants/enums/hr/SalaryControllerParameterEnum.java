package com.dt.platform.constants.enums.hr;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum SalaryControllerParameterEnum implements CodeTextEnum {

	SALARY_PT_DKJS("salary_pt_dkjs" , "抵扣基数"),
	HIGH_TEMPERATURE_SALARY("high_temperature_salary" , "高温补贴"),
	WELFAER_GSBX_COMPANY("welfaer_gsbx_company" , "工伤保险公司"),
	WELFAER_GSBX_PERSON("welfaer_gsbx_person" , "工伤保险个人"),
	WELFAER_SYBX_COMPANY("welfaer_sybx_company" , "生育保险公司"),
	WELFAER_SYBX_PERSON("welfaer_sybx_person" , "生育保险个人"),
	WELFAER_SYEBX_COMPANY("welfaer_syebx_company" , "失业保险公司"),
	WELFAER_SYEBX_PERSON("welfaer_syebx_person" , "失业保险个人"),
	WELFAER_YLBX_COMPANY("welfaer_ylbx_company" , "养老保险公司"),
	WELFAER_YLBX_PERSON("welfaer_ylbx_person" , "养老保险个人"),
	WELFAER_YRBX_COMPANY("welfaer_yrbx_company" , "医疗保险公司"),
	WELFAER_YRBX_PERSON("welfaer_yrbx_person" , "医疗保险个人"),
	WELFARE_ZFGJJ_COMPANY("welfare_zfgjj_company" , "住房公积金公司"),
	WELFARE_ZFGJJ_PERSON("welfare_zfgjj_person" , "住房公积金个人")
	;


	private String code;
	private String text;
	private SalaryControllerParameterEnum(String code, String text)  {
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