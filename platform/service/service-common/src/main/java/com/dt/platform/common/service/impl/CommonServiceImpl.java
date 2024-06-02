package com.dt.platform.common.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.ICommonService;
import com.dt.platform.domain.common.UserImport;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssssssss.magicapi.core.service.MagicAPIService;

import java.util.List;
import java.util.Map;



@Service("SysUserService2")
public class CommonServiceImpl extends SuperService<UserImport> implements ICommonService {

    @Autowired
    MagicAPIService magicAPIService;

    @Override
    public Object callMagicAPIService(String execType,String reqType,String path,Map<String, Object> params) {
        Object value=null;
        if("execute".equals(execType)){
             value = magicAPIService.execute(reqType, path, params);
        }else if("call".equals(execType)){
            value = magicAPIService.call(reqType, path, params);
        }else if("invoke".equals(execType)){
            value = magicAPIService.invoke( path, params);
        }
        return value;
    }

    @Override
    public Result<JSONObject> queryCurrentUserInfo() {
        Result<JSONObject> r=new Result<>();
        JSONObject json = new JSONObject();
        if(SessionUser.getCurrent()!=null){
            json.put("realName",SessionUser.getCurrent().getRealName());
            json.put("username",SessionUser.getCurrent().getUsername());
            json.put("employeeId",SessionUser.getCurrent().getActivatedEmployeeId());
            json.put("tenantId",SessionUser.getCurrent().getActivatedTenantId());
        }
        r.success(true);
        r.data(json);
        return r;
    }

    @Override
    public Result deleteByIdPhysical(String id) {
        return null;
    }

    @Override
    public UserImport getById(String id) {
        return null;
    }

    @Override
    public List<UserImport> getByIds(List<String> ids) {
        return null;
    }

    @Override
    public DAO dao() {
        return null;
    }

    @Override
    public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
        return null;
    }
}
