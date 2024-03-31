package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsDbApplyRbEnum implements CodeTextEnum {


    NONE("none", "未执行"),
    EXECUTED("executed", "已执行");

    private String code;
    private String text;
    private OpsDbApplyRbEnum(String code, String text)  {
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
