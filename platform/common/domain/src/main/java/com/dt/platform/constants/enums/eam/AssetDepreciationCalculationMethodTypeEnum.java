package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetDepreciationCalculationMethodTypeEnum implements CodeTextEnum {

    EXPRESSION("expression" , "表达式"),
    SCRIPT("script" , "脚本");

    private String code;
    private String text;
    private AssetDepreciationCalculationMethodTypeEnum(String code, String text)  {
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