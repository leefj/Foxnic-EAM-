package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsDbApplyAssociatedSystemEnum implements CodeTextEnum {


    YQ("yq", "YQ"),
    BB("bb", "BB");

    private String code;
    private String text;
    private OpsDbApplyAssociatedSystemEnum(String code, String text)  {
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
