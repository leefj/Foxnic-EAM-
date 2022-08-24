package com.dt.platform.ops.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsAutoActionNodeNumberTypeEnum;
import com.dt.platform.constants.enums.ops.OpsAutoTaskResultStatusEnum;
import com.dt.platform.constants.enums.ops.OpsAutoTaskRunStatusEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.AutoNodeMeta;
import com.dt.platform.domain.ops.meta.AutoTaskMeta;
import com.dt.platform.ops.service.*;
import com.dt.platform.ops.service.impl.ops.Machine;
import com.dt.platform.ops.service.impl.ops.SftpClient;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.yaml.snakeyaml.events.Event;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/*
[#IP#]

* */

@Service("AutoTaskBaseToolService")
public class AutoTaskBaseToolService implements IAutoTaskToolService{

    @Value("${foxnic.storage.disk.location.windows}")
    private String windowsDir="";

    @Value("${foxnic.storage.disk.location.mac}")
    private String macDir="";

    @Value("${foxnic.storage.disk.location.linux}")
    private String linuxDir="";

    public static String METHOD_VIEW="view";

    public static String METHOD_CHECK="check";

    public static String METHOD_EXECUTE="execute";

    private String getStorageDir() {
        if(OSType.isWindows()) return windowsDir;
        else if(OSType.isLinux()) return linuxDir;
        else if(OSType.isMac()) return macDir;
        else {
            throw new RuntimeException("不支持的操作系统");
        }
    }

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

    public Result recordFailed(AutoTaskLog log,String message){
        log.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
        log.setRecordContent(message);
        log.setEtime(new Date());
        autoTaskLogService.update(log,SaveMode.NOT_NULL_FIELDS);
        return ErrorDesc.success();
    }


    @Override
    public Result executeNode(AutoNode node, AutoAction action,String taskId, String mLogId,String method) {

        AutoTaskLog log=new AutoTaskLog();
        log.setActionId(action.getId());
        log.setStatus(OpsAutoTaskResultStatusEnum.ACTING.code());
        log.setStime(new Date());
        log.setTaskId(taskId);
        log.setMLogId(mLogId);
        log.setRecordContent("操作完成");
        log.setNodeId(node.getId());
        log.setRecordTime(new Date());
        autoTaskLogService.insert(log);

        //检查动作
        Result checkActionResult= checkAction(action);
        if(!checkActionResult.isSuccess()){
            recordFailed(log,checkActionResult.getMessage());
            return ErrorDesc.failureMessage(checkActionResult.getMessage());
        }

        //检查Node
        Result checkNodeResult=checkNode(node);
        if(!checkNodeResult.isSuccess()){
            recordFailed(log,checkNodeResult.getMessage());
            return ErrorDesc.failureMessage(checkNodeResult.getMessage());
        }

        //检查配置变量
        String actionConfContent=action.getConfContent();
        JSONObject actionConfContentObj=null;
        try{
            actionConfContentObj=JSONObject.parseObject(actionConfContent);
        }catch (com.alibaba.fastjson.JSONException eee) {
            recordFailed(log,"动作配置内容解析失败");
            return ErrorDesc.failureMessage("动作配置内容解析失败");
        }

        HashMap<String,Object> vars=new HashMap<>();
        if(actionConfContentObj.containsKey("vars")){
            JSONArray varsArr=actionConfContentObj.getJSONArray("vars");
            if(varsArr!=null&&varsArr.size()>0){
                for(int i=0;i<varsArr.size();i++){
                    vars.put(varsArr.getJSONObject(i).getString("key"),varsArr.getJSONObject(i));
                }
            }
        }


        //获取当前配置
        HashMap<String,String> currentNodeVars=new HashMap<>();
        AutoTask task=autoTaskService.getById(taskId);
        String taskConfContent=task.getConfContent();
        JSONArray taskConfContentArr=null;
        try{
            taskConfContentArr=JSONArray.parseArray(taskConfContent);
        }catch (com.alibaba.fastjson.JSONException eee) {
            recordFailed(log,"批次作业配置内容解析失败");
            return ErrorDesc.failureMessage("批次作业配置内容解析失败");
        }

        if(taskConfContentArr!=null&&taskConfContentArr.size()>0){
            for(int i=0;i<taskConfContentArr.size();i++){
                JSONObject nodeConfObj=taskConfContentArr.getJSONObject(i);
                if(nodeConfObj.containsKey("ip")){
                    String nodeIp=nodeConfObj.getString("ip");
                    if(nodeConfObj.containsKey("vars")){
                       JSONArray nodeVarsArr= nodeConfObj.getJSONArray("vars");
                       for(int j=0;j<nodeVarsArr.size();j++){
                           JSONObject kv=nodeVarsArr.getJSONObject(j);
                           currentNodeVars.put(kv.getString("key"),kv.getString("value"));
                       }
                    }
                    if(nodeIp.equals(node.getIp())){
                        break;
                    }
                }
            }
        }



        //连接测试
        Result checkConnectNodeResult=checkConnectNode(action);
        if(!checkConnectNodeResult.isSuccess()){
            recordFailed(log,checkConnectNodeResult.getMessage());
            return ErrorDesc.failureMessage(checkConnectNodeResult.getMessage());
        }



        System.out.println("###########Action Start,ip:"+node.getIp()+" #########");
        System.out.println("method:"+method);
        System.out.println("taskId:"+taskId);
        System.out.println("mLogId:"+mLogId);
        System.out.println("nodeName:"+node.getName());
        System.out.println("nodeIp:"+node.getIp());
        //替换变量参数
        System.out.println("globalVars:\n"+vars);
        System.out.println("currentNodeVars:\n"+currentNodeVars);
        String ct=action.getExecuteContent();
        for (String key : vars.keySet()) {
            JSONObject keyObject= (JSONObject) vars.get(key);
            System.out.println("keyObject:"+keyObject);
            String gValue=keyObject.getString("value");
            String value=currentNodeVars.getOrDefault(key,gValue);
            System.out.println("replace var,key:"+key+",value:"+value+",gvalue:"+gValue);
            String t=ct.replaceAll("<##"+key+"##>",value);
            ct=t;
        }

        String t= ct.replaceAll("<##ip##>",node.getIp());
        ct=t;
        System.out.println("replace var,key:ip,value:"+node.getIp());
        System.out.println("execute Content:\n"+ct);
        if(METHOD_EXECUTE.equals(method)){
            //#############create exe file #############
            String execFileName="ops_"+mLogId+"_"+node.getId();
            String execFileNameWithSuffix=execFileName+".sh";
            String execFileFullName="";
            File executeTmpFile=null;
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;
            try {
                System.out.println("create temp main execute file,file:"+execFileNameWithSuffix);
                executeTmpFile = File.createTempFile(execFileName, ".sh");
                execFileFullName=executeTmpFile.getAbsolutePath();
                bufferedReader = new BufferedReader(new StringReader(ct));
                bufferedWriter = new BufferedWriter(new FileWriter(executeTmpFile));
                char buf[] = new char[1024]; //字符缓冲区
                int len;
                while ((len = bufferedReader.read(buf)) != -1) {
                    bufferedWriter.write(buf, 0, len);
                }
                bufferedWriter.flush();
                bufferedReader.close();
                bufferedWriter.close();
                System.out.println("create temp main execute file success,file:"+execFileFullName);
            } catch (IOException e) {
                String msg="create temp main execute file failed,file:"+execFileFullName;
                System.out.println(msg);
                e.printStackTrace();
                recordFailed(log,msg);
                return ErrorDesc.failureMessage(msg);
            }
            //#############upload exe file #############
            Machine m=new Machine();
            m.setHostname(node.getIp());
            m.setPort(node.getPort());
            m.setUsername(node.getVoucher().getAccount());
            m.setPassword(node.getVoucher().getVoucher());
            SftpClient sftp = new SftpClient(m);
            sftp.connect();
            if(!sftp.isConnected()){
                String msg="Connect to host by sftp error!";
                recordFailed(log,msg);
                return ErrorDesc.failureMessage(msg);
            }
            sftp.changeDirectory("/tmp");
            try {
                if("/tmp".equals(sftp.getCurrentCatalog())){
                    sftp.deleteFile(execFileNameWithSuffix);
                }
            } catch (IOException ee) {
                System.out.println("delete temp execute file error,detail:"+ee.getMessage());
            }
            Result uploadExeFileR= sftp.uploadFile(executeTmpFile, execFileNameWithSuffix, null);
            if(!uploadExeFileR.success()){
                recordFailed(log,uploadExeFileR.message());
                return ErrorDesc.failureMessage(uploadExeFileR.message());
            }
            //#############upload script file #############
            String scriptSql="select\n" +
                    "a.script_id,\n" +
                    "c.file_name,\n" +
                    "d.location\n" +
                    "from \n" +
                    "ops_auto_action_s_script a,\n" +
                    "ops_auto_action b,\n" +
                    "ops_auto_action_script c,\n" +
                    "sys_file d\n" +
                    "where a.owner_id=b.id \n" +
                    "and c.id=a.script_id\n" +
                    "and d.id=c.file_id\n" +
                    "and a.deleted=0 \n" +
                    "and b.deleted=0\n" +
                    "and c.deleted=0\n"+
                    "and b.id=?";
            RcdSet scriptRS=dao.query(scriptSql,action.getId());
            for(Rcd rcd:scriptRS){
                String f=this.getStorageDir()+rcd.getString("location");
                String fn=rcd.getString("file_name");
                if(StringUtil.isBlank(fn)){
                    recordFailed(log,"文件名不能为空");
                    return ErrorDesc.failureMessage("文件名不能为空");
                }
                File file=new File(f);
                if(!file.exists()){
                    String msg="script:"+f+" not exist";
                    recordFailed(log,msg);
                    return ErrorDesc.failureMessage(msg);
                }
                try {
                    if("/tmp".equals(sftp.getCurrentCatalog())){
                        sftp.deleteFile(fn);
                    }
                } catch (IOException ee) {
                    System.out.println("delete script file error,detail:"+ee.getMessage());
                }

                Result uploadScritR=sftp.uploadFile(file, fn, null);
                if(!uploadScritR.isSuccess()){
                    recordFailed(log,uploadScritR.message());
                    return ErrorDesc.failureMessage(uploadScritR.message());
                }

            }

            //#############upload file #############
            String fileSql="select\n" +
                    "a.file_id,\n" +
                    "c.file_name,\n" +
                    "d.location\n" +
                    "from \n" +
                    "ops_auto_action_s_file a,\n" +
                    "ops_auto_action b,\n" +
                    "ops_auto_action_file c,\n" +
                    "sys_file d\n" +
                    "where a.owner_id=b.id \n" +
                    "and c.id=a.file_id\n" +
                    "and d.id=c.file_id\n" +
                    "and a.deleted=0 \n" +
                    "and b.deleted=0\n" +
                    "and c.deleted=0\n"+
                    "and b.id=?";
            if(StatusEnableEnum.ENABLE.code().equals(action.getFileStatus())){
                RcdSet fileRS=dao.query(fileSql,action.getId());
                for(Rcd rcd:fileRS){
                    String f=this.getStorageDir()+rcd.getString("location");
                    String fn=rcd.getString("file_name");
                    if(StringUtil.isBlank(fn)){
                        recordFailed(log,"文件名不能为空");
                        return ErrorDesc.failureMessage("文件名不能为空");
                    }
                    File file=new File(f);
                    if(!file.exists()){
                        String msg="file:"+f+" not exist";
                        recordFailed(log,msg);
                        return ErrorDesc.failureMessage(msg);
                    }
                    try {
                        if("/tmp".equals(sftp.getCurrentCatalog())){
                            sftp.deleteFile(fn);
                        }
                    } catch (IOException ee) {
                        System.out.println("delete file error,detail:"+ee.getMessage());
                    }
                    Result uploadFileR=sftp.uploadFile(file, fn, null);
                    if(!uploadFileR.isSuccess()){
                        recordFailed(log,uploadFileR.message());
                        return ErrorDesc.failureMessage(uploadFileR.message());
                    }

                }
            }else{
                System.out.println("file upload status:"+ action.getFileStatus());
            }
            //#############execute #############
            RemoteShellExecutor executor = new RemoteShellExecutor(node.getIp(),node.getVoucher().getAccount(),
                    node.getVoucher().getVoucher(), node.getPort());

            ArrayList<String> exeCommands = new ArrayList<String>();
            exeCommands.add("sed -i \"s/^M//\" /tmp/"+execFileNameWithSuffix);
            exeCommands.add("sh /tmp/"+execFileNameWithSuffix);
            RemoteShellResult r2 = executor.exec(exeCommands);
            r2.print();
            if(r2.result.length()>=10000){
                log.setContentDetail(r2.result.substring(0,10000));
            }else{
                log.setContentDetail(r2.result);
            }
        }else if (METHOD_CHECK.equals(method)){
            RemoteShellExecutor executor = new RemoteShellExecutor(node.getIp(),node.getVoucher().getAccount(),
                    node.getVoucher().getVoucher(), node.getPort());
            String cmds = "echo 'success!';hostname";
            RemoteShellResult r2 = executor.exec(cmds);
            r2.print();
            log.setContentDetail(r2.result);
            executor.close();
        }else if (METHOD_VIEW.equals(method)){

        }
        System.out.println("###########Action Finish,ip:"+node.getIp()+" #########");




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
                .with(AutoTaskMeta.BATCH)
                .execute();

        AutoBatch batch=task.getBatch();
        List<AutoNode> nodeList= new ArrayList<>();
        String sql="select b.node_id from ops_auto_task a,ops_auto_node_select b where a.id=b.owner_id and a.deleted=0 and b.deleted=0 and a.status='enable' and a.id='"+taskId+"'";
        String nodeSql="";
        //填充节点
        if(StringUtil.isBlank(task.getBatchId())){
            nodeSql=sql;
        }else{
            String sql2="select b.node_id from ops_auto_batch a,ops_auto_node_select b where a.id=b.owner_id and a.deleted=0 and b.deleted=0 and a.status='enable' and a.id='"+task.getBatchId()+"'";
            nodeSql=sql+" union all "+sql2;
        }
        AutoNode node=new AutoNode();
        node.setStatus(StatusEnableEnum.ENABLE.code());
        ConditionExpr expr=new ConditionExpr();
        expr.and("id in ("+nodeSql+")");
        nodeList=autoNodeService.queryList(node,expr);
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

        //检查节点数量
        if(nodeList==null|| nodeList.size()==0){
            String msg="执行节点数量为空";
            taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
            taskMainLog.setContent(msg);
            autoTaskMLogService.insert(taskMainLog);
            return ErrorDesc.failureMessage(msg);
        }


        //检查节点数量是否符合模版
        if(OpsAutoActionNodeNumberTypeEnum.TWO.code().equals(action.getNodeNumberType())){
            if(nodeList.size()!=2){
                String msg="当前部署模版,只能选择2个节点";
                taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
                taskMainLog.setContent(msg);
                autoTaskMLogService.insert(taskMainLog);
                return ErrorDesc.failureMessage(msg);
            }
        }else if (OpsAutoActionNodeNumberTypeEnum.THREE.code().equals(action.getNodeNumberType())){
            if(nodeList.size()!=3){
                String msg="当前部署模版,只能选择3个节点";
                taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.FAILED.code());
                taskMainLog.setContent(msg);
                autoTaskMLogService.insert(taskMainLog);
                return ErrorDesc.failureMessage(msg);
            }
        }

        autoTaskMLogService.insert(taskMainLog);
        AutoTask updateTask=new AutoTask();
        updateTask.setId((task.getId()));
        updateTask.setRunStatus(OpsAutoTaskRunStatusEnum.RUNNING.code());
        autoTaskService.update(updateTask,SaveMode.NOT_NULL_FIELDS);
        for(AutoNode node:nodeList){
            Logger.info("task:"+task.getName()+",node:"+node.getName()+",action:"+action.getName());
            Result eRes=executeNode(node,action,task.getId(),id,method);
        }
        taskMainLog.setEtime(new Date());
        taskMainLog.setStatus(OpsAutoTaskResultStatusEnum.SUCCESS.code());
        taskMainLog.setContent("操作完成");
        autoTaskMLogService.update(taskMainLog, SaveMode.NOT_NULL_FIELDS);

        updateTask.setRunStatus(OpsAutoTaskRunStatusEnum.FINISH.code());
        autoTaskService.update(updateTask,SaveMode.NOT_NULL_FIELDS);
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

//        JSONObject confObject= JSONObject.parseObject(conf);
//        if(confObject==null){
//            return ErrorDesc.failureMessage("执行配置内容为空");
//        }

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
