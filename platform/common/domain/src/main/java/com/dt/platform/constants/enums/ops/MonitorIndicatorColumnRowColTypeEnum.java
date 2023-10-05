package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/*]
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum MonitorIndicatorColumnRowColTypeEnum implements CodeTextEnum {

    SINGLE_SINGLE("single_single" , "单行单列"),
    SINGLE_MULTIPLE("single_multiple" , "单行多列"),
    MULTIPLE_MULTIPLE("multiple_multiple" , "多行多列"),
    MULTIPLE_SINGLE("multiple_single" , "多行多列");

    private String code;
    private String text;
    private MonitorIndicatorColumnRowColTypeEnum(String code, String text)  {
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