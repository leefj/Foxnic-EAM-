package com.dt.platform.proxy.common;

import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 表单信息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 09:06:10
 */
@FeignClient(value = ServiceNames.COMMON, contextId = CommonServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CommonServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-form-info
     */
    public static final String API_CONTEXT_PATH = "user";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";


//    public static final String ALERT_NOTICE = API_PREFIX + "alert-notice";


    /**
     * 更新员工导入
     */
    public static final String CURRENT_USER_INFO = API_PREFIX + "current-user-info";

    public static final String CALL_MAGIC_API_SERVICE = API_PREFIX + "call-magic-api-service";

    @RequestMapping(CommonServiceProxy.CALL_MAGIC_API_SERVICE)
    public Result<Object> callMagicAPIService(String execType, String reqType, String path, Map<String, Object> params);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.CommonController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CommonServiceProxy api() {
        return APIProxy.get(CommonServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
