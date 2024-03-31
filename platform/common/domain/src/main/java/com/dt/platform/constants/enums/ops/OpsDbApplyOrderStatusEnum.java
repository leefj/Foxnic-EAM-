package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsDbApplyOrderStatusEnum implements CodeTextEnum {


    NONE("none", "未生成"),
    SUCECSS("success", "成功生成"),
    FAILED("failed", "成功失败");

    private String code;
    private String text;
    private OpsDbApplyOrderStatusEnum(String code, String text)  {
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
