package com.dt.platform.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ScreenApiHttpClient {
    public static final String UTF_8 = "UTF-8";
    public static final String GBK = "GBK";
    public static final String GB_2312 = "GB2312";
    public static final String ISO_8859_1 = "ISO-8859-1";
    private CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    private RequestConfig requestConfig;

    public ScreenApiHttpClient() {
        this.requestConfig = RequestConfig.DEFAULT;
    }

    public ScreenApiHttpClient(RequestConfig config) {
        this.requestConfig = config;
    }

    public ScreenApiHttpClient(int connectionRequestTimeout, int connectTimeout, int socketTimeout) {
        this.requestConfig = RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
    }

    public String get(String url) throws Exception {
        return this.get(url, (Map) null, (Map) null, "UTF-8");
    }

    public String get(String url, String charset) throws Exception {
        return this.get(url, (Map) null, (Map) null, charset);
    }

    public String get(String url, Map<String, String> params, Map<String, String> headers, String charset) throws Exception {
        List<String> pairs = new ArrayList();
        if (params != null) {
            Iterator var6 = params.entrySet().iterator();
            while (var6.hasNext()) {
                Map.Entry<String, String> e = (Map.Entry) var6.next();
                pairs.add((String) e.getKey() + "=" + (String) e.getValue());
            }
        }
        String queryString = StringUtil.join(pairs, "&");
        if(queryString.length()>2){
            if (url.indexOf("?") != -1) {
                url = url + "&" + queryString;
            } else {
                url = url + "?" + queryString;
            }
        }
        HttpGet get = new HttpGet(url);
        this.applyHeaders(get, headers);
        HttpResponse httpResponse = this.httpClient.execute(get);
        String response = EntityUtils.toString(httpResponse.getEntity(), charset);
        return response;
    }

    public String post(String url, Map<String, String> params, String charset) throws Exception {
        return this.post(url, params, (Map) null, charset);
    }

    private void applyHeaders(AbstractHttpMessage msg, Map<String, String> headers) {
        if (headers != null && !headers.keySet().isEmpty()) {
            Set<String> keySet = headers.keySet();
            Iterator iterator = keySet.iterator();

            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                String value = (String) headers.get(key);
                msg.addHeader(key, value);
            }

        }
    }

    public String post(String url, Map<String, String> params, Map<String, String> headers, String charset) throws Exception {
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList();
        if (params != null) {
            Iterator var7 = params.entrySet().iterator();

            while (var7.hasNext()) {
                Map.Entry<String, String> e = (Map.Entry) var7.next();
                list.add(new BasicNameValuePair((String) e.getKey(), (String) e.getValue()));
            }
        }

        UrlEncodedFormEntity form = new UrlEncodedFormEntity(list, charset);
        post.setEntity(form);
        post.setConfig(this.requestConfig);
        this.applyHeaders(post, headers);
        HttpResponse httpResponse = this.httpClient.execute(post);
        String response = EntityUtils.toString(httpResponse.getEntity(), charset);
        return response;
    }

    public String postJSONObject(String url, JSONObject params) throws IOException {
        if (params == null) {
            params = new JSONObject();
        }

        return this.postMap(url, params.toJSONString(), new HashMap());
    }


    public String postMap(String url, String bodyJsonParams, Map<String, String> headers) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        //application/json
        //application/x-www-form-urlencoded; charset=UTF-8
        //httpPost.setEntity(new StringEntity(bodyJsonParams,ContentType.create(ContentType.APPLICATION_JSON.getMimeType())));
        httpPost.setEntity(new StringEntity(bodyJsonParams,ContentType.create(ContentType.APPLICATION_JSON.getMimeType())));
        this.applyHeaders(httpPost, headers);
        return execute(httpPost);
    }

    private static String execute(HttpUriRequest httpUriRequest) throws IOException {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            Throwable var2 = null;

            try {
                CloseableHttpResponse response = httpClient.execute(httpUriRequest);
                response.getAllHeaders();
                if (response.getStatusLine().getStatusCode() != 200) {
                    return null;
                } else {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    Throwable var5 = null;

                    try {
                        String result = "";

                        for (String tmp = null; (tmp = bufferedReader.readLine()) != null; result = result + tmp) {
                        }

                        String var8 = result;
                        return var8;
                    } catch (Throwable var34) {
                        var5 = var34;
                        throw var34;
                    } finally {
                        if (bufferedReader != null) {
                            if (var5 != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable var33) {
                                    var5.addSuppressed(var33);
                                }
                            } else {
                                bufferedReader.close();
                            }
                        }

                    }
                }
            } catch (Throwable var36) {
                var2 = var36;
                throw var36;
            } finally {
                if (httpClient != null) {
                    if (var2 != null) {
                        try {
                            httpClient.close();
                        } catch (Throwable var32) {
                            var2.addSuppressed(var32);
                        }
                    } else {
                        httpClient.close();
                    }
                }

            }
        } catch (Exception var38) {
            Logger.error("请求失败", var38);
            return null;
        }
    }
}