package com.dt.platform.common.authority;


import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.domain.common.KeyCode;
import com.dt.platform.domain.common.KeyCodeVO;
import com.dt.platform.proxy.common.KeyCodeServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
@Component
public class CommonAuthority extends ModuleAuthority {

    /**
     * 返回最顶层菜单的权限Key
     * */
    @Override
    public String[] getAuthorities() {
        KeyCodeVO vo=new KeyCodeVO();
        vo.setStatus(StatusYNEnum.YES.code());
      //  Result<List<KeyCode>> res=KeyCodeServiceProxy.api().queryList(vo);
        String[] s=new String[] {"pay","system_monitor_list","bigscreen","system:mngr","system_ops","common_system","data_backup","auto_perm","sys_tpl_file:mngr","system_monitor"};
        Logger.info("static key:"+s);
//        if(res.isSuccess()&&res.getData().size()>0){
//            List<KeyCode> list=res.getData();
//            List<String> keyStrList= CollectorUtil.collectList(list, KeyCode::getKey);
//            System.out.println("db incluse key:"+keyStrList.toArray());
//            Arrays.asList(s).addAll(keyStrList);
//            Logger.info("return  key:"+s);
//            return s;
//        }
//        Logger.info("return  key:"+s);
        return s;
    }
}
