package com.dt.platform.common.sso;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.AppLanguage;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.UserTenant;
import org.github.foxnic.web.domain.system.UserTenantVO;
import org.github.foxnic.web.framework.sso.TokenReader;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.system.TenantServiceProxy;
import org.github.foxnic.web.proxy.system.UserTenantServiceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class ApplicationTokenReader extends TokenReader {

    @Value("${app.sso.token-validate-api}")
    private String tokenValidateUrl;

    @Value("${app.sso.client-name}")
    private String clientName;

    @Value("${app.tenant-id}")
    private String tenantId;

    private String companyId = null;

    @Override
    public String readUserId(HttpServletRequest request) {
        String uid=request.getParameter("uid");
        String token=request.getParameter("st");
        String userId = null;
        if(!StringUtil.isBlank(token)) {
            userId=getUserIdByToken(token);
        }
        if(StringUtil.isBlank(userId)) {
            userId=uid;
        }
        return userId;
    }

    @Override
    public Language readLanguage(HttpServletRequest request) {
        String lang=request.getParameter("lang");
        AppLanguage appLanguage=AppLanguage.parseByCode(lang);
        if(appLanguage==null) appLanguage=AppLanguage.cn;
        return appLanguage.language();
    }

    private void initIf() {
        if(this.companyId!=null) return;
        Result<Tenant> tenantResult =  TenantServiceProxy.api().getById(tenantId);
        if(tenantResult.failure()){
            throw new IllegalArgumentException("租户ID错误");
        }
        this.companyId=tenantResult.data().getCompanyId();
        if(StringUtil.isBlank(this.companyId)){
            throw new IllegalArgumentException("租户未指定公司");
        }
    }

    private String getUserIdByToken(String token) {

        initIf();
        HttpPost post = new HttpPost(tokenValidateUrl);
        post.setHeader("Content-Type","application/json");
        post.setHeader("Authorization",token);
        JSONObject data=new JSONObject();
        data.put("clientName",clientName);
        data.put("Authorization",token);

        try {
            post.setEntity(new StringEntity(data.toJSONString()));
            String httpResponse = execute(post);
            if(StringUtil.isBlank(httpResponse)) {
                return null;
            }
            JSONObject result=JSONObject.parseObject(httpResponse);
            String empNo=result.getJSONObject("data").getString("empNo");

            EmployeeVO employee = new EmployeeVO();
            employee.setBadge(empNo);
            Result<List<Employee>> employeeListResult= EmployeeServiceProxy.api().queryList(employee);
            if(employeeListResult.failure()) return null;
            if(employeeListResult.data()==null || employeeListResult.data().isEmpty()) return null;
            Employee emp=employeeListResult.data().get(0);
            UserTenantVO userTenantVO=new UserTenantVO();
            userTenantVO.setOwnerTenantId(tenantId);
            userTenantVO.setEmployeeId(emp.getId());
            userTenantVO.setActivated(1);
            Result<List<UserTenant>> utResult= UserTenantServiceProxy.api().queryList(userTenantVO);
            if(utResult.failure()) return null;
            if(utResult.data()==null || utResult.data().isEmpty()) return null;
            UserTenant userTenant=utResult.data().get(0);
            String userId=userTenant.getUserId();
            return userId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String execute(HttpUriRequest httpUriRequest) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            CloseableHttpResponse response = httpClient.execute(httpUriRequest);
            if (response.getStatusLine().getStatusCode() == 200) {// 请求成功状态
                try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()))) {
                    String result="";
                    String tmp=null;
                    while((tmp=bufferedReader.readLine())!=null){
                        result+=tmp;
                    }
                    return result;
                }
            }
        } catch (Exception e) {
            Logger.error("请求失败",e);
        }
        return null;
    }

}
