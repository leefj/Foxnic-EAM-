package com.dt.platform.constants.enums.hr;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum PersonDataExportColumnEnum implements CodeTextEnum {


    EMPLOYEE_OWNER_TYPE_NAME( "employeeOwnerTypeName","employee_type_code" ),
    POLITIC_COUNTENANCE_CODE_NAME( "politicCountenanceCodeName","politic_countenance_code" ),
    EMPLOYEE_IDENTITY_STATUS_NAME( "employeeIdentityStatusName","employee_identity_status" ),
    EDUCATION_CODE_NAME( "educationCodeName","education_code" ),
    BLOOD_TYPE_NAME( "bloodTypeName","blood_type" ),
    SEX_CODE_NAME( "sexCodeName","sex_code" ),
    PAYROLL_CARD_BANK_CODE_NAME( "payrollCardBankCodeName","payroll_card_bank_code" ),
    MARITAL_STATUS_NAME( "maritalStatusName","marital_status" ),

    SALARY_PAY_OUT_NAME( "salaryPayOutName","salary_pay_out" ),
    EMPLOYEE_STATUS_NAME( "employeeStatusName","employee_status" ),

    ORG_NAME( "orgName","org_id" ),

    SALARY_TPL_NAME( "salaryTplName","salary_tpl_id" ),
    POSITION_CODE_NAME( "positionCodeName","position_code" ),
    RANK_CODE_NAME( "rankCodeName","rank_code" ),
    EMPLOYEE_TITLE_CODE_NAME( "employeeTitleCodeName","employee_title_code" );







    private String code;
    private String text;
    private PersonDataExportColumnEnum(String code, String text)  {
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
