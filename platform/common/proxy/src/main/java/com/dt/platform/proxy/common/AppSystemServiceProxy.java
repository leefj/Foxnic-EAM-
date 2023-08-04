package com.dt.platform.proxy.common;

import com.dt.platform.proxy.ServiceNames;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 表单信息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 09:06:10
 */
@FeignClient(value = ServiceNames.COMMON, contextId = AppSystemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AppSystemServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径
     */
    public static final String API_CONTEXT_PATH = "system";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 保存赋权明细
     */
    public static final String SSO_CHECK = API_PREFIX + "sso-check";

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.UserController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AppSystemServiceProxy api() {
        return APIProxy.get(AppSystemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
