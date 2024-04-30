package com.dt.platform.constants.enums.eam;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.api.constant.CodeTextEnum;

public enum AssetOperateCleanOutEnum implements CodeTextEnum {
    EAM_ASSET_SCRAP("eam_asset_scrap", "报废"),
    EAM_ASSET_HANDLE("eam_asset_handle", "处置");


    private String code;
    private String text;
    private AssetOperateCleanOutEnum(String code, String text)  {
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
