package com.dt.platform.hr.service.impl;

import com.dt.platform.domain.hr.SalaryCtl;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.SalaryIncomeTax;
import com.github.foxnic.commons.log.Logger;
import org.apache.commons.jexl3.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service("SalaryCalUtilService")
public class SalaryUtilService {



    public BigDecimal calIncomeTaxPctValue(BigDecimal total, List<SalaryIncomeTax> taxList){
        Logger.info("total:"+total.toString());
        BigDecimal res=new BigDecimal("0.03");
        for(SalaryIncomeTax tax:taxList){
            //total<tax
            if(total.compareTo(tax.getEnd())==-1){
                res=tax.getTax();
                break;
            }
        }
        return res;
    }

    public BigDecimal calIncomeTaxValue(BigDecimal total, List<SalaryIncomeTax> taxList){
        SalaryIncomeTax pct=null;
        for(SalaryIncomeTax tax:taxList){
            //total<tax
            if(total.compareTo(tax.getEnd())==-1){
                pct=tax;
                break;
            }

        }
        Logger.info("total:"+total.toString());
        Logger.info("pct:"+pct.getTax());
        BigDecimal res=total.multiply(pct.getTax()).subtract(pct.getQuickDeduct());
        //四舍五入模式
        return res.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    //四舍五入模式
    public BigDecimal roundHalfUp(Object value, int scale){
        Logger.info("class type:"+value.getClass());
        if(value.getClass().equals(BigDecimal.class)){
            return ((BigDecimal) value).setScale(scale,BigDecimal.ROUND_HALF_UP);
        }else if(value.getClass().equals(Integer.class)){
            return new BigDecimal((Integer) value);
        }else if(value.getClass().equals(Double.class)){
            return new BigDecimal((Double) value).setScale(scale,BigDecimal.ROUND_HALF_UP);
        }else if(value.getClass().equals(Float.class)){
            return new BigDecimal((Float) value).setScale(scale,BigDecimal.ROUND_HALF_UP);
        }else if(value.getClass().equals(String.class)){
            return new BigDecimal((String) value).setScale(scale,BigDecimal.ROUND_HALF_UP);
        }else{
            Logger.error("roundHalfUp error,current class type is "+value.getClass()+",please modify code.");
        }
        return null;
    }


    /**
     * 月份是否一样
     * @param  registerDate 入账日期 2022-01
     * @param  businessDate 入账日期 2022-01
     * @return 1
     * */
    public int usedLifeByAccountingPeriod(Date registerDate,Date businessDate){
        //按照计算规则，registerDate 不会和businessDate 相等，businessDate大于registerDate 至少一个月
        SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
        String d1y = sdfy.format(registerDate);
        String d2y = sdfy.format(businessDate);
        if(d2y.equals(d1y)){
            //资产入账日期，在本年度发生折旧
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(registerDate);
            int month1 = cal1.get(Calendar.MONTH) + 1;
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(businessDate);
            int month2 = cal2.get(Calendar.MONTH) + 1;
            return (month2-month1);
        }else{
            //超过了入账日期所在年，只需要计算获得当前月份
            Calendar cal = Calendar.getInstance();
            cal.setTime(businessDate);
            int month = cal.get(Calendar.MONTH) + 1;
            return month;
        }
    }


    /**
     * date1-date2
     * @param businessDate 日期1 2022-01
     * @param startDate 日期2 2022-01
     * @return 返回相减的月份
     * */
    public int usedLifeByAccountingPeriodForLast(Date startDate,Date businessDate){
        int value= usedLifeByAccountingPeriod(startDate,businessDate);
        if(value-1<0){
            return 0;
        }else{
            return value-1;
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
    //    funcs.put("commonFunction",new AssetDepreciationUtilService());
        jexlBuilder.namespaces(funcs);

        JexlEngine jexlEngine = jexlBuilder.create();
        boolean bb=true;

        Date d1=new Date();
        Date d2=new Date();
        String expr="d1>d2";

        JexlContext jexlContext = new MapContext();
        jexlContext.set("bb",  bb);
        jexlContext.set("d1",  d1);
        jexlContext.set("d2",  d2);
        jexlContext.set("a",  new BigDecimal("1"));
        jexlContext.set("b",  new BigDecimal("1.0"));

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

    /**
     *  支持条件表达式计算
     * @param eval 表达式不能有汉字（支持条件语句的表达式）
     * @param map
     * @param clazz
     * @Description: 根据表达式和参数集合进行计算
     * @Author: chenhf
     * @Date: 2021/6/22 16:12
     * @return: java.lang.Object
     */
    private static Object exeScriptExpression(String eval, Map<String, Object> map,Class<?>... clazz) {
        JexlEngine engine = new JexlBuilder().create();
        JexlScript script = engine.createScript(eval);
        JexlContext context = new MapContext();
        Arrays.asList(clazz).forEach(cal -> {
            context.set(cal.getSimpleName(),cal);
        });
        if (Objects.nonNull(map)) {
            map.forEach(context::set);
        }
        return script.execute(context);
    }


    /**
     * 日期是否一样
     * @param date1 日期1 2022-01-02,
     * @param date2 日期2 2022-01-02
     * @return 0 date1=date2,
     *         1 date1>date2,
     *        -1 date1<date2
     * */
    public String compareDate(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d1 = sdf.format(date1);
        String d2 = sdf.format(date2);
        Logger.info("compareDate d1:"+d1+",d2:"+d2);
        Date date11 = null;
        Date date22 = null;
        int v=0;
        try {
            date11 = sdf.parse(d1);
            date22 = sdf.parse(d2);
            v=date11.compareTo(date22);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Logger.info("compareDate reuslt:"+v);
        return v+"";
    }






}