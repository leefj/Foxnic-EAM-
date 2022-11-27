package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.dt.platform.eam.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.apache.commons.jexl3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service("AssetDepreciationUtilService")
public class AssetDepreciationUtilService {

    /**
     * 月份是否一样
     * @param date1 日期1 2022-01
     * @param date2 日期2 2022-01
     * @return 1 相等,
     *         0 不相等
     * */
    public String equalMonth(Date date1, Date date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String d1 = sdf.format(date1);
        String d2 = sdf.format(date2);
        if(d1.equals(d2)){
            return "1";
        }else{
            return "0";
        }
    }

    /**
     * date1-date2
     * @param date1 日期1 2022-01
     * @param date2 日期2 2022-01
     * @return 返回相减的月份
     * */
    public String subtractMonth(Date date1, Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        int year1 = cal1.get(Calendar.YEAR) ;
        int month1 = cal1.get(Calendar.MONTH) + 1;

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int year2 = cal2.get(Calendar.YEAR) ;
        int month2 = cal2.get(Calendar.MONTH) + 1;
        return (year1-year2)*12+(month1-month2)+"";
    }


    public static void main(String[] args) {
        AssetDepreciationUtilService a=new AssetDepreciationUtilService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date11 = null;
        Date date22 =null;
        try {
              date11 = sdf.parse("2022-01-01");
              date22 = sdf.parse("2023-12-05");
            String t=a.usedLifeByAccountingPeriod(date11,date22);
            System.out.println(t);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        AssetDepreciationUtilService a=new AssetDepreciationUtilService();
//        Date date = new Date();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        // 把日期往后增加一天,整数  往后推,负数往前移动
//        calendar.add(Calendar.DATE, 90);
//        // 这个时间就是日期往后推一天的结果
//        date = calendar.getTime();
//
//        System.out.println(a.compareDate(date,new Date()));
    }

    /**
     * 月份是否一样
     * @param  registerDate 入账日期 2022-01
     * @param  businessDate 入账日期 2022-01
     * @return 1
     * */
    public String usedLifeByAccountingPeriod(Date registerDate,Date businessDate){
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
            return (month2-month1)+"";
        }else{
            //超过了入账日期所在年，只需要计算获得当前月份
            Calendar cal = Calendar.getInstance();
            cal.setTime(businessDate);
            int month = cal.get(Calendar.MONTH) + 1;
            return month+"";
        }
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
//        System.out.println("compareDate "+d1);
//        System.out.println("compareDate "+d2);
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
        System.out.println("compareDate reuslt:"+v);
        return v+"";
    }



    /*
     * 根据规则字段计算折旧数据
     * */
    public Result calRuleContent(AssetDepreciationDetail assetDepreciationDetail,AssetDepreciationCalRule rule){
        String colValue=rule.getColumnValue();
        String calType=rule.getCalculationType();
        String ruleContent=rule.getMethodContent();
        String partMsg="rule:"+rule.getRuleNumber()+",单据:"+assetDepreciationDetail.getOperId()+",列名:"+rule.getColumnName();
        System.out.println(partMsg+",动作:本规则计算开始,资产编号:"+assetDepreciationDetail.getAssetCode()+",列值:"+rule.getColumnValue()+",info:"+rule.getMethodContentInfo());
        //System.out.println("rule:"+rule.getRuleNumber()+",before data:\n"+BeanUtil.toJSONObject(assetDepreciationDetail).toJSONString());
        //上一起折旧数据
        AssetDepreciationDetail lastAssetDepreciationDetail=assetDepreciationDetail.getLastAssetDepreciationDetail();
        //资产原始数据
        Asset assetOriginalData=assetDepreciationDetail.getAsset();

        if(AssetDepreciationCalculationMethodTypeEnum.JEXL_EXPRESSION.code().equals(calType)){
            //JEXL_EXPRESSION 表达式计算
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("asset", assetDepreciationDetail);
            map.put("last", lastAssetDepreciationDetail);
            map.put("assetOriginalData", assetOriginalData);
            System.out.println(partMsg+",字段:"+rule.getColumnValue() +",表达式:"+ruleContent);
            if(StringUtil.isBlank(ruleContent)){
                return ErrorDesc.failureMessage(partMsg+",计算表达式为空");
            }

            String result = calculationValue(ruleContent,map);
            System.out.println(partMsg+",计算结果:"+result);
            if(StringUtil.isBlank(result)||result.startsWith("err")){
                return ErrorDesc.failureMessage(partMsg+",计算结果:"+result);
            }

            //返回
            if(AssetDepreciationCalculationReturnTypeEnum.TYPE_DOUBLE.code().equals(rule.getReturnType())){
                //double 类型
                BigDecimal bResult = new BigDecimal(result).setScale(2,BigDecimal.ROUND_DOWN);
                BeanUtil.setFieldValue(assetDepreciationDetail,colValue,bResult);
                System.out.println(partMsg+",set value:"+BeanUtil.getFieldValue(assetDepreciationDetail,colValue,BigDecimal.class).toString());
            }else if(AssetDepreciationCalculationReturnTypeEnum.TYPE_STRING.code().equals(rule.getReturnType())){
                //string 类型
                BeanUtil.setFieldValue(assetDepreciationDetail,colValue,result);
                System.out.println(partMsg+",set value:"+BeanUtil.getFieldValue(assetDepreciationDetail,colValue,String.class));
            }
        }
        else if(AssetDepreciationCalculationMethodTypeEnum.NOT_NULL.code().equals(calType)){
            //NOT NULL 方式
            Boolean notNUll=true;
            if(BeanUtil.getFieldValue(assetDepreciationDetail,colValue)==null){
                notNUll=false;
            }
            System.out.println(partMsg+",计算结果:"+notNUll);
            if(!notNUll){
                return ErrorDesc.failureMessage("本规则计算未匹配,规则编号:"+rule.getRuleNumber()+","+rule.getColumnName()+"该值不能为空");
            }
        } else if(AssetDepreciationCalculationMethodTypeEnum.SCRIPT.code().equals(calType)){
            //SCRIPT 脚本，暂时未实现
            System.out.println(partMsg+",本规则未实现");
            return ErrorDesc.failureMessage("本规则计算类型没有实现,Rule:"+rule.getRuleNumber());
        }else{
            System.out.println(partMsg+",计算规则配置有误");
            return ErrorDesc.failureMessage("本规则计算类型设置有误,Rule:"+rule.getRuleNumber());
        }
        //  System.out.println("rule:"+rule.getRuleNumber()+",after data:\n"+BeanUtil.toJSONObject(assetDepreciationDetail).toJSONString());
        System.out.println(partMsg+",动作:本规则计算开始,资产编号:"+assetDepreciationDetail.getAssetCode()+",列值:"+rule.getColumnValue()+",info:"+rule.getMethodContentInfo());
        return ErrorDesc.success();
    }

    private String calculationValue(String jexlExp, Map<String, Object> map){
        JexlBuilder jb=new JexlBuilder();
        Map<String, Object> funcs =new HashMap<>();
        funcs.put("commonFunction",new AssetDepreciationUtilService());
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
