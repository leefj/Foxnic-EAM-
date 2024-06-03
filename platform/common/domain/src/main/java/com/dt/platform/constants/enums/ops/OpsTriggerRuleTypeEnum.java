package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsTriggerRuleTypeEnum implements CodeTextEnum {



    STATIC("static", "静态"),
    DYNAMIC("dynamic", "自动发现");

    private String code;
    private String text;
    private OpsTriggerRuleTypeEnum(String code, String text)  {
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
