package com.dt.platform.ops.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetDepreciationCalculationReturnTypeEnum;
import com.dt.platform.constants.enums.ops.MonitorMethodEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Insert;
import org.apache.commons.jexl3.*;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service("MonitorDataProcessCalculateServiceImpl")
public class MonitorDataProcessCalculateServiceImpl implements IMonitorDataProcessCalculateService {


    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }


    @Autowired
    private IMonitorNodeService monitorNodeService;

    @Autowired
    private IMonitorTplService monitorTplService;

    @Autowired
    private IMonitorNodeValueService monitorNodeValueService;

    @Autowired
    private IMonitorTplIndicatorService monitorTplIndicatorService;


    @Autowired
    private MonitorDataProcessBaseServiceImpl monitorDataProcessBaseService;

    @Autowired
    private MonitorDataProcessUtilService monitorDataProcessUtilService;


    private String MONITOR_METHOD=MonitorMethodEnum.CALCULATED_BY_CODE.code();

    @Override
    public Result collectData() {
        List<MonitorNode> nodeList=monitorDataProcessBaseService.queryExecuteNodeList(MONITOR_METHOD);
        Logger.info("collectData,find nodes number:"+nodeList.size());

        // 创建 ForkJoin 工具，其中 输入一个 Integer 元素的 List ，输出 Long 元素的 List ，每个线程处理 若干元素 ，此处为 5 个
        SimpleJoinForkTask<MonitorNode,Result> task=new SimpleJoinForkTask<>(nodeList,10);
        // 并行执行
        List<Result> rvs=task.execute(els->{
            // 打印当前线程信息
            Logger.info(Thread.currentThread().getName());
            // 处理当前分到的 若干元素，此处为 5 个
            List<Result> rs=new ArrayList<>();
            for (MonitorNode node : els) {
                Result result=collectNodeData(node);
                if(!result.isSuccess()){
                    Logger.info("node ip:"+node.getNodeIp()+",message"+result.getMessage());
                }
                rs.add(result);
            }
            // 处理完毕，返回本批次的处理结果，由 SimpleJoinForkTask 负责合并全部结果，并由 rvs 变量接收
            return rs;
        });
        return ErrorDesc.success();
    }

    @Override
    public Result collectNodeData(MonitorNode node) {
        //获取指标
        List<MonitorTplIndicator> monitorTplIndicatorList=monitorDataProcessBaseService.queryExecuteIndicatorList(node.getId(),MONITOR_METHOD);
        Logger.info("method:"+this.MONITOR_METHOD+",collectData,process node:"+node.getId()+",ip:"+node.getNodeIp()+",find indicator number:"+monitorTplIndicatorList.size());
        List<Insert> list=calculateByNode(monitorTplIndicatorList,node);
        //开始执行insert
        if(list.size()>0){
            monitorDataProcessBaseService.executeCollectDataInsert(list);
        }
        return ErrorDesc.success();
    }


    private List<Insert> calculateByNode(List<MonitorTplIndicator> indicators,MonitorNode node){
        List<Insert> insertList=new ArrayList<>();
        for(int i=0;i<indicators.size();i++){
            List<Insert> ins=calculateByIndicator(indicators.get(i),node);
            if(ins!=null&&ins.size()>0){
                insertList.addAll(ins);
            }
        }
        return insertList;
    }

    private String calculationValue(String jexlExp, Map<String, Object> map){
        JexlBuilder jb=new JexlBuilder();
        Map<String, Object> funcs =new HashMap<>();
        funcs.put("cF",monitorDataProcessUtilService);
        jb.namespaces(funcs);
        JexlEngine jexl =jb.create();
        JexlExpression expression = jexl.createExpression(jexlExp);
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


    private List<Insert> calculateByIndicator(MonitorTplIndicator indicator,MonitorNode node){

        List<Insert> list=new ArrayList<>();
        //当前支支持，返回单行，单列
        String expr=indicator.getCommand();
        node.setCalIndicatorTplCode(indicator.getMonitorTplCode());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("node", node);
        Logger.info("nodeId:"+node.getId()+",indicator:"+indicator.getCode()+",表达式:"+expr);
        Object result = calculationValue(expr,map);
        if(!indicator.getStatus().equals("enable")){
            return list;
        }
        Logger.info("result:"+result);
        if(StringUtil.isBlank(result)){
            Insert valueInsert=new Insert("ops_monitor_node_value");
            valueInsert.set("id", IDGenerator.getSnowflakeId());
            valueInsert.setIf("result_status","failed");
            valueInsert.setIf("result_message","result is null");
            valueInsert.setIf("indicator_code",indicator.getCode());
            valueInsert.setIf("node_id",node.getId());
            valueInsert.setIf("is_connected",1);
            valueInsert.setIf("monitor_tpl_code",indicator.getMonitorTplCode());
            valueInsert.setIf("record_time",new Date());
            list.add(valueInsert);
        }else{
            //转换成insert语句
            String content=result.toString();
            Result<Object> insertResult=monitorDataProcessBaseService.convertToInsertData(indicator,content,node);
            if(insertResult.isSuccess()){
                list=(List<Insert>)insertResult.getData();
            }
        }
        return list;
    }

    @Override
    public Result clearNodeValueLastHistoryData() {
        return ErrorDesc.success();
    }
}
