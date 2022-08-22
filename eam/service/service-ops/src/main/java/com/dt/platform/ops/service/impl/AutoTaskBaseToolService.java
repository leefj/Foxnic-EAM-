package com.dt.platform.ops.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsAutoTaskResultStatusEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.AutoNodeMeta;
import com.dt.platform.domain.ops.meta.AutoTaskMeta;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.AU;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.yaml.snakeyaml.events.Event;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("AutoTaskBaseToolService")
public class AutoTaskBaseToolService implements IAutoTaskToolService{


    public static String METHOD_VIEW="view";

    public static String METHOD_CHECK="check";

    public static String METHOD_EXECUTE="execute";


    @Autowired
    private IAutoTaskMLogService autoTaskMLogService;


    @Autowired
    private IAutoTaskLogService autoTaskLogService;

    @Autowired
    private IAutoTaskService autoTaskService;


    @Autowired
    private IAutoNodeService autoNodeService;


    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }



    @Override
    public Result executeNode(AutoNode node, AutoAction action,String taskId, String mLogId,String method) {
        AutoTaskLog log=new AutoTaskLog();
        log.setActionId(action.getId());
        log.setStatus(OpsAutoTaskResultStatusEnum.ACTING.code());
        log.setStime(new Date());
        log.setTaskId(taskId);
        log.setMLogId(mLogId);
        log.setNodeId(node.getId());
        log.setRecordTime(new Date());
        autoTaskLogService.insert(log);

        //检查Node
        Result checkNodeResult=checkNode(node);
        if(!checkNodeResult.isSuccess()){
            log.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
            log.setRecordContent(checkNodeResult.getMessage());
            log.setEtime(new Date());
            autoTaskLogService.update(log,SaveMode.NOT_NULL_FIELDS);
            return ErrorDesc.failureMessage(checkNodeResult.getMessage());
        }

        //检查动作
        Result checkActionResult=checkAction(action);
        if(!checkActionResult.isSuccess()){
            log.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
            log.setRecordContent(checkActionResult.getMessage());
            log.setEtime(new Date());
            autoTaskLogService.update(log,SaveMode.NOT_NULL_FIELDS);
            return ErrorDesc.failureMessage(checkActionResult.getMessage());
        }

        //连接测试
        Result checkConnectNodeResult=checkConnectNode(action);
        if(!checkConnectNodeResult.isSuccess()){
            log.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
            log.setRecordContent(checkConnectNodeResult.getMessage());
            log.setEtime(new Date());
            autoTaskLogService.update(log,SaveMode.NOT_NULL_FIELDS);
            return ErrorDesc.failureMessage(checkConnectNodeResult.getMessage());
        }


        //执行
        log.setStatus(OpsAutoTaskResultStatusEnum.SUCCESS.code());
        log.setRecordContent("操作完成");
        log.setEtime(new Date());
        autoTaskLogService.update(log,SaveMode.NOT_NULL_FIELDS);
        return ErrorDesc.success();
    }

    public Result executeByTaskId(String taskId, String method){
        AutoTask task=autoTaskService.getById(taskId);
        autoTaskService.dao().fill(task)
                .with(AutoTaskMeta.GROUP)
                .execute();

        AutoGroup group=task.getGroup();
        List<AutoNode> nodeList= new ArrayList<>();
        //填充节点
        if(group!=null){
            AutoNode nodeQuery=new AutoNode();
            nodeQuery.setStatus(StatusEnableEnum.ENABLE.code());
            nodeQuery.setGroupId(group.getId());
            nodeList=autoNodeService.queryList(nodeQuery);
        }

        //获取凭证数据
        if(nodeList!=null){
            autoNodeService.dao().fill(nodeList)
                    .with(AutoNodeMeta.VOUCHER)
                    .execute();
        }

        //获取动作数据
        autoTaskService.dao().fill(task)
                .with(AutoTaskMeta.ACTION)
                .execute();

        return this.batchExecuteNode(nodeList,task,method);
    }

    /**
     * @return 执行成功
     * */
    @Override
    public Result batchExecuteNode(List<AutoNode> nodeList, AutoTask task, String method){

        AutoTaskMLog taskMainLog=new AutoTaskMLog();
        String id= IDGenerator.getSnowflakeIdString();
        taskMainLog.setId(id);
        taskMainLog.setTaskId(task.getId());
        taskMainLog.setStime(new Date());
        taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.ACTING.code());
        AutoAction action=task.getAction();

        //检查action
        if(action==null){
            String msg="执行动作为空";
            taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
            taskMainLog.setContent(msg);
            autoTaskMLogService.insert(taskMainLog);
            return ErrorDesc.failureMessage(msg);
        }else{
            taskMainLog.setActionId(action.getId());
        }

        //检查method
        if(method.equals(METHOD_EXECUTE) || method.equals(METHOD_VIEW)||method.equals(METHOD_CHECK)){
            System.out.println("success");
        }else{
            String msg="检查参数不符合要求";
            taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
            taskMainLog.setContent(msg);
            autoTaskMLogService.insert(taskMainLog);
            return ErrorDesc.failureMessage(msg);
        }


        if(nodeList==null|| nodeList.size()==0){
            String msg="执行节点数量为空";
            taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
            taskMainLog.setContent(msg);
            autoTaskMLogService.insert(taskMainLog);
            return ErrorDesc.failureMessage(msg);
        }


        autoTaskMLogService.insert(taskMainLog);

        for(AutoNode node:nodeList){
            Logger.info("task:"+task.getName()+",node:"+node.getName()+",action:"+action.getName());
            Result eRes=executeNode(node,action,task.getId(),id,method);
        }
        taskMainLog.setEtime(new Date());
        taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.SUCCESS.code());
        taskMainLog.setContent("操作完成");
        autoTaskMLogService.update(taskMainLog, SaveMode.NOT_NULL_FIELDS);
        return ErrorDesc.success();
    }




    public Result checkConnectNode(AutoAction node){


        ErrorDesc.failureMessage("与节点连接失败");
        return ErrorDesc.success();
    }

    public Result checkAction(AutoAction action){
        String conf=action.getConfContent();
        String content=action.getExecuteContent();

        if(StringUtil.isBlank(conf)){
            return ErrorDesc.failureMessage("执行配置内容为空");
        }

        JSONObject confObject= JSONObject.parseObject(conf);
        if(confObject==null){
            return ErrorDesc.failureMessage("执行配置内容为空");
        }

        if(StringUtil.isBlank(content)){
            return ErrorDesc.failureMessage("执行内容为空");
        }
        return ErrorDesc.success();
    }

    public Result checkNode(AutoNode node){

        String ip=node.getIp();
        int port=node.getPort();
        if(StringUtil.isBlank(ip)){
            return ErrorDesc.failureMessage("地址不能为空");
        }
        if(port<=0||port>=65536){
            return ErrorDesc.failureMessage("端口不正确");
        }
        AutoVoucher voucher = node.getVoucher();
        if(voucher==null){
            return ErrorDesc.failureMessage("凭证不能为空");
        }
        String accountStr=voucher.getAccount();
        String voucherStr=voucher.getVoucher();
        if(StringUtil.isBlank(accountStr)){
            return ErrorDesc.failureMessage("凭证账户不能为空");
        }
        if(StringUtil.isBlank(voucherStr)){
            return ErrorDesc.failureMessage("凭证数据不能为空");
        }

        return ErrorDesc.success();
    }



}
