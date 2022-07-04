package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum networkStrategySessionTypeypeEnum implements CodeTextEnum {

    LONG("long" , "长连接"),
    SHORT("short" , "短连接");

    private String code;
    private String text;
    private networkStrategySessionTypeypeEnum(String code, String text)  {
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
