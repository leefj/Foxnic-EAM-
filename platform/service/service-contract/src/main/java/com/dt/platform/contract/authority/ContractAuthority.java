package com.dt.platform.contract.authority;


import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;

@Component
public class ContractAuthority extends ModuleAuthority {
    /**
     * 返回最顶层菜单的权限Key
     * */
    @Override
    public String[] getAuthorities() {
        return new String[] {
                // 合同管理
                "contract"
        };
    }
}
