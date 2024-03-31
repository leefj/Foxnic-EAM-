package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsDbApplyStatusEnum implements CodeTextEnum {


    UNSUBMITTED("unsubmitted", "未提交"),
    FAILED("failed", "提交失败"),
    SUBMITTED("submitted", "已提交");

    private String code;
    private String text;
    private OpsDbApplyStatusEnum(String code, String text)  {
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
