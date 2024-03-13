package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum InspectPointColumnEnum implements CodeTextEnum {

    //TXT(name,db_column)
    ASSET_ID("id","id" );

    private String code;
    private String text;
    private InspectPointColumnEnum(String code, String text)  {
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
