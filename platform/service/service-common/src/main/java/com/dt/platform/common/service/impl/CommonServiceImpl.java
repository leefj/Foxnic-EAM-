package com.dt.platform.common.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.ICommonService;
import com.dt.platform.domain.common.UserImport;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssssssss.magicapi.core.service.MagicAPIService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;


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
    public Result<String> alertNotice(String ct,String url) {
        String res="";
        Result<String> res2=new Result<>();
        JSONObject obj=JSONObject.parseObject(ct);
        HashMap<String,String> headerMap=null;
        System.out.println("发送数据:"+ct);
        UUID uniqueKey = UUID.randomUUID();
        String uniqueKeyString = uniqueKey.toString();
//        JSONObject obj=new JSONObject();
//        obj.put("triggerId",uniqueKeyString);
//        obj.put("app","bf4ae4a9-466f-4cb7-9d88-dd90f35fe4a3");
//        obj.put("eventType","trigger");
//        obj.put("alertTime",time);
//        obj.put("priority",4);
//        obj.put("name",ct);
//        obj.put("group","网络组");
//        obj.put("ip","10.21.1.86");
//        obj.put("description","IMC网络监控");
//        obj.put("host","IMC");
      //  Logg("json:\n"+obj.toJSONString());
        try {
            CloseableHttpClient httpClient2 = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");  // 设置请求头的内容类型为 JSON
            httpPost.setEntity(new StringEntity(obj.toString(), ContentType.APPLICATION_JSON));  //
            System.out.println("start to post");
            HttpResponse httpResponse = httpClient2.execute(httpPost);  // 发送 HTTP POST 请求
            HttpEntity httpEntity = httpResponse.getEntity();  // 获取响应实体
            res = EntityUtils.toString(httpEntity);  // 将响应实体转换为字符串
            System.out.println("Response: " + res);  // 打印响应结果
            res2.data(obj.toString()+res);
            res2.success(true);
        } catch (Exception e) {
            e.printStackTrace();
            res2.data(e.getMessage());
            res2.success(false);
        }

        return res2;
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
