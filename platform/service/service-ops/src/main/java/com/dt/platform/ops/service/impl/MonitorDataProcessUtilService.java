package com.dt.platform.ops.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.MonitorNode;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.spec.DAO;

import org.apache.commons.jexl3.*;
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


    public BigDecimal lastDouble(MonitorNode node,String code,int minute){
        String value=last(node,code,minute,"0");
        return new BigDecimal(value);
    }

    public BigDecimal lastDouble(MonitorNode node,String code,int minute,String defValue){
        String value=last(node,code,minute,defValue);
        return new BigDecimal(value);
    }

    public String lastString(MonitorNode node,String code,int minute,String defValue){
        return last(node,code,minute,defValue);
    }

    public String lastString(MonitorNode node,String code,int minute){
        return last(node,code,minute,null);
    }

    public String last(MonitorNode node,String code,int minute,String defValue){
        String curTplCode=node.getCalIndicatorTplCode();
        String res=defValue;
        String timestr="";
        if(minute>0){
            timestr=" and record_time>date_sub(now(), interval "+minute+" minute) ";
        }
        String sql="select "
                +" (select value_column from ops_monitor_tpl_indicator where monitor_tpl_code=? and code=?) col,"
                +" t.* from ops_monitor_node_value_last t"
                +" where result_status='sucess' #TIME# and monitor_tpl_code=? and indicator_code=? and node_id=? "
                +" and record_time=(select max(t.record_time) from ops_monitor_node_value_last t where result_status='sucess' and monitor_tpl_code=? and indicator_code=? and node_id=?)";
        Rcd rs=dao.queryRecord(sql.replace("#TIME#",timestr),curTplCode,code,curTplCode,code,node.getId(),curTplCode,code,node.getId());
        if(rs!=null){
            res=rs.getString(rs.getString("col"));
            String id=rs.getString("id");
            if(node.getUidList()==null){
                node.setUidList(new ArrayList<>());
            }
            node.getUidList().add(id);
        }
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

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,2);
        Date lastDate = calendar.getTime();

        System.out.println(lastDate);

        Map<String, Object> map =new HashMap<>();
        map.put("a", new BigDecimal("1"));
        map.put("b", new BigDecimal("6"));
        map.put("c", new BigDecimal("100.01"));

        JexlBuilder jexlBuilder = new JexlBuilder();
        Map<String, Object> funcs =new HashMap<>();
        funcs.put("cF",new MonitorDataProcessUtilService());
        jexlBuilder.namespaces(funcs);

        JexlEngine jexlEngine = jexlBuilder.create();
        boolean bb=true;

        Date d1=new Date();
        Date d2=new Date();

        JexlContext jexlContext = new MapContext();
        jexlContext.set("bb",  bb);
        jexlContext.set("d1",  d1);
        jexlContext.set("d2",  d2);
        jexlContext.set("a",  new BigDecimal("1"));
        jexlContext.set("b",  new BigDecimal("1.0"));
        String expr="a>b";
        JexlExpression expression = jexlEngine.createExpression(expr);
        Object r=expression.evaluate(jexlContext);
        System.out.println(r.getClass()+","+r);
        // 初始化Jexl构造器
//        JexlBuilder jexlBuilder = new JexlBuilder();
//        // 创建Jexl表达式引擎
//        JexlEngine jexlEngine = jexlBuilder.create();
//        // 创建Jexl表达式解析器
//        JexlScript jexlScript = jexlEngine.createScript("if(item.eRecoverableAmount>=25){grade=1;gradeName='有灾害';}else{grade=0;gradeName='无灾害';}");
//        // 创建Jexl表达式变量上下文
//        JexlContext jexlContext = new MapContext();
//
//
//        AssetDepreciationDetail d=new AssetDepreciationDetail();
//        d.setERecoverableAmount(new BigDecimal("1.01"));
//        jexlContext.set("item", d);
//        // 执行Jexl表达式，得到结果
//        jexlScript.execute(jexlContext);
//        System.out.println(jexlContext.get("grade"));
//        System.out.println(jexlContext.get("gradeName"));

//        AssetDepreciationUtilService a=new AssetDepreciationUtilService();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date11 = null;
//        Date date22 =null;
//        try {
//              date11 = sdf.parse("2022-01-01");
//              date22 = sdf.parse("2023-12-05");
//            String t=a.usedLifeByAccountingPeriod(date11,date22);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
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
