package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum InspectionTaskAbnormalStatusEnum implements CodeTextEnum {

    NOT_PROCESS("not_process" , "未处理"),
    PROCESSED("processed" , "已处理");

    private String code;
    private String text;
    private InspectionTaskAbnormalStatusEnum(String code, String text)  {
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