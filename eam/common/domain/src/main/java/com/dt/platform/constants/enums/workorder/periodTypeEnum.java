package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum periodTypeEnum implements CodeTextEnum {

    PERMANENT("permanent" , "永久"),
    TEMPORARY("temporary" , "临时");

    private String code;
    private String text;
    private periodTypeEnum(String code, String text)  {
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
