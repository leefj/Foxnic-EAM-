package com.dt.platform.common.config;

import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.context.RequestEntity;
import org.ssssssss.magicapi.core.interceptor.ResultProvider;

import java.util.HashMap;

@Component
public class MagicApiCustomJsonValueProvider  implements ResultProvider {


    @Override
    public Object buildResult(RequestEntity requestEntity, int code, String message, Object data) {
        // 如果对分页格式有要求的话，可以对data的类型进行判断，进而返回不同的格式
        return new HashMap<String,Object>(){
            {
                if(code==1){
                    put("code", "00");
                    put("success", true);
                }else{
                    put("code", "01");
                    put("success", false);
                }
                put("data", data);
                put("message", message);
                put("api_code", code);
                put("api_message", message);
            }
        };
    }
}
