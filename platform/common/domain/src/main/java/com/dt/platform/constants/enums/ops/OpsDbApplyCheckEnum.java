package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsDbApplyCheckEnum implements CodeTextEnum {


    NONE("none", "未执行"),
    SUCCESS("success", "通过"),
    FAILED("failed", "未通过");

    private String code;
    private String text;
    private OpsDbApplyCheckEnum(String code, String text)  {
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
