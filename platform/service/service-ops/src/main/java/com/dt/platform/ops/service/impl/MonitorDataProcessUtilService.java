package com.dt.platform.ops.service.impl;


import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorNodeTriggerLastData;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.cache.CacheProperties;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;

import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.meta.DBType;
import org.apache.commons.jexl3.*;
import org.github.foxnic.web.framework.cache.FoxnicDataCacheManager;
import org.github.foxnic.web.framework.dao.DBConfigs;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;


@Service("MonitorDataProcessUtilService")
public class MonitorDataProcessUtilService {


    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }



    public BigDecimal lastDouble(MonitorNode node,String code,String store,String subFilter,int minute){
        String value=last(node,code,store,subFilter,minute,"5");
        return new BigDecimal(value);
    }

    public BigDecimal lastDouble(MonitorNode node,String code,String store,String subFilter,int minute,String defValue){
        String value=last(node,code,store,subFilter,minute,defValue);
        return new BigDecimal(value);
    }

    public String lastString(MonitorNode node,String code,String store,String subFilter,int minute,String defValue){
        return last(node,code,store,subFilter,minute,defValue);
    }

    public String lastString(MonitorNode node,String code,String store,String subFilter,int minute){
        return last(node,code,store,subFilter,minute,null);
    }
    public String last(MonitorNode node,String code,String store,String subFilter,int minute,String defValue){
        String curTplCode=node.getCalIndicatorTplCode();
        String res=defValue;
        String timestr="";

        if(subFilter==null){
            subFilter="";
        }else{
            subFilter=" and "+subFilter;
        }

        if(minute>0){
            timestr=" and record_time>date_sub(now(), interval "+minute+" minute) ";
        }
        String sql="select "
                +" (select value_column from ops_monitor_tpl_indicator where monitor_tpl_code=? and code=?) col,"
                +" t.* from ops_monitor_node_value_last t "
                +" where  result_status='sucess' #<TIME># and monitor_tpl_code=? and indicator_code=? and node_id=? " +subFilter
                +" and record_time=(select max(t.record_time) from ops_monitor_node_value_last t where result_status='sucess' "
                +" and monitor_tpl_code=? and indicator_code=? and node_id=?)";
        Rcd rcd=dao.queryRecord(sql.replace("#<TIME>#",timestr),curTplCode,code,curTplCode,code,node.getId(),curTplCode,code,node.getId());

        if(node.getTriggerData()==null){
            node.setTriggerData(new MonitorNodeTriggerLastData());
        }
        //如果没有记录，则返回默认值
        if(rcd==null){
            Logger.info("no record for:"+code+" node_name:"+node.getNodeNameShow());
            return res;
        }

        //如果配置了store，则按照store获取，否则自动获取col
        //在多个col时，需要配置store
        String col="";
        if(store==null){
            col=rcd.getString("col");
        }else{
            col=store;
        }
        if(StringUtil.isBlank(rcd.getString(col))){
            Logger.info("to set default:" + defValue + "node_name:" + node.getNodeNameShow());
        }else{
            res=rcd.getString(col);
        }
        String id=rcd.getString("id");
        node.getTriggerData().setId(id);
        node.getTriggerData().setValue(res);
        node.getTriggerData().setSourceData(rcd.toJSONObject());
        return res;
    }



    public String getStringJsonObject(String objStr,String col){
        JSONObject obj= JSONObject.parseObject(objStr);
        if(obj!=null){
           return obj.getString(col);
        }else{
           return "";
        }
    }

    public int getIntJsonObject(String objStr,String col){
        JSONObject obj= JSONObject.parseObject(objStr);
        if(obj!=null){
            return obj.getIntValue(col);
        }else{
            return 0;
        }
    }

    public double getDoubleJsonObject(String objStr,String col){
        JSONObject obj= JSONObject.parseObject(objStr);
        if(obj!=null){
            return obj.getDoubleValue(col);
        }else{
            return 0.00;
        }
    }

    private DAO createDAO(String driverName,String url,String userName,String passwd) {
        // 从连接字符串识别数据库类型
        DBType dbType=DBType.parseFromURL(url);
        // 创建数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passwd);
        // mysql 关闭，Oracle 建议开启
        if(dbType==DBType.ORACLE) {
            dataSource.setPoolPreparedStatements(true);
        }
        // 通过 DAOBuilder 创建 DAO 对象
        DAOBuilder builder=new DAOBuilder();
        try {
            dao=builder.datasource(dataSource).build();
            // 设置全局方言
        //    GlobalSettings.DEFAULT_SQL_DIALECT=this.dao.getSQLDialect();
            // 设置数据库规约
          //  dao.setDBTreaty(getDBTreaty());
            // 设置关系管理器
          //  dao.setRelationManager(new DemoRelationManager());
            //设置缓存
            FoxnicDataCacheManager cacheManager=new FoxnicDataCacheManager();
            CacheProperties cacheProperties=new CacheProperties(SpringUtil.getEnvProperties("foxnic.cache"));
            cacheManager.setCacheProperties(cacheProperties);
            cacheManager.setRelationManager(dao.getRelationManager());
            dao.setDataCacheManager(cacheManager);
            // 设置SQL打印
            dao.setPrintSQL(true);
            dao.setPrintSQLSimple(true);
            dao.setPrintSQLCallstack(false);
            return dao;
        } catch (Exception e) {
            e.printStackTrace();
//            Logger.error("创建DAO错误",e);
            return null;
        }
    }
    public static void main(String[] args) {
        MonitorDataProcessUtilService u=new MonitorDataProcessUtilService();

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.MONTH,2);
//        Date lastDate = calendar.getTime();
//
//        System.out.println(lastDate);
//
//        Map<String, Object> map =new HashMap<>();
//        map.put("a", new BigDecimal("1"));
//        map.put("b", new BigDecimal("6"));
//        map.put("c", new BigDecimal("100.01"));
//
//        JexlBuilder jexlBuilder = new JexlBuilder();
//        Map<String, Object> funcs =new HashMap<>();
//        funcs.put("cF",new MonitorDataProcessUtilService());
//        jexlBuilder.namespaces(funcs);
//
//        JexlEngine jexlEngine = jexlBuilder.create();
//        boolean bb=true;
//
//        Date d1=new Date();
//        Date d2=new Date();
//
//        JexlContext jexlContext = new MapContext();
//        jexlContext.set("bb",  bb);
//        jexlContext.set("d1",  d1);
//        jexlContext.set("d2",  d2);
//        jexlContext.set("a",  new BigDecimal("1"));
//        jexlContext.set("b",  new BigDecimal("1.0"));
//        String expr="a>b";
//        JexlExpression expression = jexlEngine.createExpression(expr);
//        Object r=expression.evaluate(jexlContext);
//        System.out.println(r.getClass()+","+r);
//        // 初始化Jexl构造器
////        JexlBuilder jexlBuilder = new JexlBuilder();
////        // 创建Jexl表达式引擎
////        JexlEngine jexlEngine = jexlBuilder.create();
////        // 创建Jexl表达式解析器
////        JexlScript jexlScript = jexlEngine.createScript("if(item.eRecoverableAmount>=25){grade=1;gradeName='有灾害';}else{grade=0;gradeName='无灾害';}");
////        // 创建Jexl表达式变量上下文
////        JexlContext jexlContext = new MapContext();
////
////
////        AssetDepreciationDetail d=new AssetDepreciationDetail();
////        d.setERecoverableAmount(new BigDecimal("1.01"));
////        jexlContext.set("item", d);
////        // 执行Jexl表达式，得到结果
////        jexlScript.execute(jexlContext);
////        System.out.println(jexlContext.get("grade"));
////        System.out.println(jexlContext.get("gradeName"));
//
////        AssetDepreciationUtilService a=new AssetDepreciationUtilService();
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////        Date date11 = null;
////        Date date22 =null;
////        try {
////              date11 = sdf.parse("2022-01-01");
////              date22 = sdf.parse("2023-12-05");
////            String t=a.usedLifeByAccountingPeriod(date11,date22);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
    }

    private String calculationValue(String jexlExp, Map<String, Object> map){
        JexlBuilder jb=new JexlBuilder();
        Map<String, Object> funcs =new HashMap<>();
        funcs.put("commonFunction",new MonitorDataProcessUtilService());
        jb.namespaces(funcs);
        JexlEngine jexl =jb.create();
        JexlExpression  expression = jexl.createExpression(jexlExp);
        JexlContext jc = new MapContext();
        for (String key : map.keySet()) {
            jc.set(key, map.get(key));
        }
        Object r=expression.evaluate(jc);
        if (null ==r) {
            return "";
        }
        return r.toString();
    }


}
