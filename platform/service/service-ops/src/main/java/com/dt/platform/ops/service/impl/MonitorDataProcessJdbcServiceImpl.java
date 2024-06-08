package com.dt.platform.ops.service.impl;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.ops.MonitorMethodEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.sql.expr.Insert;
import com.github.foxnic.sql.meta.DBType;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("MonitorDataProcessJdbcServiceImpl")
public class MonitorDataProcessJdbcServiceImpl implements IMonitorDataProcessJdbcService {
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

    private String MONITOR_METHOD_DB2= MonitorMethodEnum.DB2_JDBC.code();
    private String MONITOR_METHOD_ORACLE= MonitorMethodEnum.ORACLE_JDBC.code();
    private String MONITOR_METHOD_MYSQL= MonitorMethodEnum.MYSQL_JDBC.code();
    private String MONITOR_METHOD_PG= MonitorMethodEnum.PG_JDBC.code();
    private String MONITOR_METHOD_SQLSERVER= MonitorMethodEnum.SQLSERVER_JDBC.code();

    @Override
    public Result collectData() {
        List<MonitorNode> nodeList=new ArrayList<>();
        List<MonitorNode> nodeListDb2=monitorDataProcessBaseService.queryExecuteNodeList(MONITOR_METHOD_DB2);
        List<MonitorNode> nodeListOracle=monitorDataProcessBaseService.queryExecuteNodeList(MONITOR_METHOD_ORACLE);
        List<MonitorNode> nodeListMysql=monitorDataProcessBaseService.queryExecuteNodeList(MONITOR_METHOD_MYSQL);
        List<MonitorNode> nodeListPg=monitorDataProcessBaseService.queryExecuteNodeList(MONITOR_METHOD_PG);
        List<MonitorNode> nodeListSqlServer=monitorDataProcessBaseService.queryExecuteNodeList(MONITOR_METHOD_SQLSERVER);

        if(nodeListDb2!=null&&nodeListDb2.size()>0){
            nodeList.addAll(nodeListDb2);
        }
        if(nodeListOracle!=null&&nodeListOracle.size()>0){
            nodeList.addAll(nodeListOracle);
        }
        if(nodeListOracle!=null&&nodeListOracle.size()>0){
            nodeList.addAll(nodeListMysql);
        }
        if(nodeListPg!=null&&nodeListPg.size()>0){
            nodeList.addAll(nodeListPg);
        }
        if(nodeListSqlServer!=null&&nodeListSqlServer.size()>0){
            nodeList.addAll(nodeListSqlServer);
        }
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
                Result result=collectNodeData(node,null,false);
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


    //同一个节点指标必须一样
    @Override
    public Result collectNodeData(MonitorNode node,String indicatorId,boolean isForce) {

        String sql="select distinct c.monitor_method from ops_monitor_tpl a,ops_monitor_node_tpl_item b,ops_monitor_tpl_indicator c\n" +
                "where a.code=b.tpl_code \n" +
                "and a.code=c.monitor_tpl_code\n" +
                "and a.deleted=0\n" +
                "and c.deleted=0\n" +
                "and a.status='enable'\n" +
                "and c.status='enable'\n" +
                "and c.monitor_method in ('oracle_jdbc','db2_jdbc','mysql_jdbc','sqlserver_jdbc')\n" +
                "and b.node_id=?";
        RcdSet rs=dao.query(sql,node.getId());
        if(rs.size()!=1){
            return ErrorDesc.failureMessage("当前节点,存在超过2个以上jdbc类型,只支持一个");
        }
        String var=node.getVar();
        JSONObject varObj=JSONObject.parseObject(var);
        if(var==null){
            return ErrorDesc.failureMessage("当前节点,所需的变量不存在");
        }

        String user=varObj.getString("user");
        String pwd=varObj.getString("pwd");
        String me=rs.getRcd(0).getString("monitor_method");
        List<MonitorTplIndicator> monitorTplIndicatorList=monitorDataProcessBaseService.queryExecuteIndicatorList(node.getId(),me,null,isForce);
        if(monitorTplIndicatorList==null||monitorTplIndicatorList.size()==0){
            return ErrorDesc.success();
        }
        String dbType="";
        String driver="";
        if(MonitorMethodEnum.DB2_JDBC.code().equals(me)){
            dbType="db2";
            driver="com.ibm.db2.jcc.DB2Driver";
        }else if(MonitorMethodEnum.ORACLE_JDBC.code().equals(me)){
            dbType="oracle";
            driver="oracle.jdbc.driver.OracleDriver";
        }else if(MonitorMethodEnum.MYSQL_JDBC.code().equals(me)||MonitorMethodEnum.OB_MYSQL_JDBC.code().equals(me)){
            dbType="mysql"; //mysql 5.7
            driver="com.mysql.jdbc.Driver";
        }else if(MonitorMethodEnum.SQLSERVER_JDBC.code().equals(me)){
            dbType="sqlserver";
            driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }else if(MonitorMethodEnum.PG_JDBC.code().equals(me)){
            dbType="pg";
            driver="org.postgresql.Driver";
        }else{
            return ErrorDesc.failureMessage("当前节点所选JDBC不支持");
        }
        Logger.info("dbType:"+dbType+",driver:"+driver);
        DAO d=createDAO(dbType,driver,node.getJdbcUrl(),user,pwd);
        if(d==null){
            Logger.info("create dao failed!,url:"+node.getJdbcUrl());
            //插入节点报错数据
            MonitorTplIndicator indicator=monitorTplIndicatorList.get(0);
            Insert errInsert=new Insert("ops_monitor_node_value");
            errInsert.set("id", IDGenerator.getSnowflakeId());
            errInsert.setIf("result_status","failed");
            errInsert.setIf("result_message","dao create failed");
            errInsert.setIf("indicator_code",indicator.getCode());
            errInsert.setIf("node_id",node.getId());
            errInsert.setIf("is_connected",1);
            errInsert.setIf("monitor_tpl_code",indicator.getMonitorTplCode());
            errInsert.setIf("record_time",new Date());
            dao.execute(errInsert);
            Insert errInsertLast=new Insert("ops_monitor_node_value_last");
            errInsertLast.set("id", IDGenerator.getSnowflakeId());
            errInsertLast.setIf("result_status","failed");
            errInsertLast.setIf("result_message","dao create failed");
            errInsertLast.setIf("indicator_code",indicator.getCode());
            errInsertLast.setIf("node_id",node.getId());
            errInsertLast.setIf("is_connected",1);
            errInsertLast.setIf("monitor_tpl_code",indicator.getMonitorTplCode());
            errInsertLast.setIf("record_time",new Date());
            dao.execute(errInsertLast);
            return ErrorDesc.failureMessage("dao创建失败");
        }else{
            Logger.info("create dao success!");
        }
        List<Insert> list=queryIndicators(d,monitorTplIndicatorList,node);
        if(list.size()>0){
            monitorDataProcessBaseService.executeCollectDataInsert(list);
        }
        return ErrorDesc.success();

    }

    public List<Insert> queryIndicators(DAO d,List<MonitorTplIndicator> indicators,MonitorNode node){
        List<Insert> insertList=new ArrayList<>();
        for(int i=0;i<indicators.size();i++){
            List<Insert> ins=queryIndicatorData(d,indicators.get(i),node);
            if(ins!=null&&ins.size()>0){
                insertList.addAll(ins);
            }
        }
        return insertList;
    }
    public List<Insert> queryIndicatorData(DAO dbDao,MonitorTplIndicator indicator,MonitorNode node){
        List<Insert> list=new ArrayList<>();
        RcdSet rs=dbDao.query(indicator.getCommand());
        if(!indicator.getStatus().equals("enable")){
            return list;
        }
        if(rs==null){
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
            String[] mapArr=indicator.getValueColumnMap().split(",");
            String content="";
            for(int i=0;i<rs.size();i++){
                String e="";
                for(int j=0;j<mapArr.length;j++){
                    if(j==0){
                        e=rs.getRcd(i).getString(mapArr[j]);
                    }else{
                        e=e+","+rs.getRcd(i).getString(mapArr[j]);
                    }
                }
                if(i==0){
                    content=e;
                }else{
                    content=content+"\n"+e;
                }
            }
            Logger.info("content:\n"+content);
            Result<Object> insertResult=monitorDataProcessBaseService.convertToInsertData(indicator,content,node);
            if(insertResult.isSuccess()){
                list=(List<Insert>)insertResult.getData();
            }
        }
        return list;
    }

    private DAO createDAO(String type,String driverName, String url, String userName, String passwd) {
        Logger.info("create dao driver:"+driverName+",jdbc:"+url+",userName:"+userName);
        DAO newDao=null;
        DBType dbType=DBType.parseFromURL(url);
        if("oracle".equals(type)){
            dbType=DBType.ORACLE;
        }else if("db2".equals(type)){
            dbType=DBType.DB2;
        }else if("mysql".equals(type)){
            dbType=DBType.MYSQL;
        }else if("sqlserver".equals(type)){
            dbType=DBType.SQLSVR;
        }else if("pg".equals(type)){
            dbType=DBType.PG;
        }
        if(dbType==null){
            dbType=DBType.parseFromURL(url);
        }
        if(dbType==null){
            dbType=DBType.parseFromDriver(url);
        }
        if(dbType==null){
            Logger.info("dbType is null");
            return null;
        }
        Logger.info("dbType:"+dbType.getDAOType());
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passwd);
        dataSource.setMaxActive(2);
        dataSource.setPhyMaxUseCount(2L);
        dataSource.setPhyMaxUseCount(2L);
        dataSource.setMaxWait(3000L);
        dataSource.setConnectionErrorRetryAttempts(2);
        dataSource.setBreakAfterAcquireFailure(true);
        if(dbType==DBType.ORACLE) {
            // mysql 关闭，Oracle 建议开启
            dataSource.setPoolPreparedStatements(true);
        }
        DAOBuilder builder=new DAOBuilder();
        try {
            newDao=builder.datasource(dataSource).build();
            newDao.setPrintSQL(true);
            newDao.setPrintSQLSimple(true);
            newDao.setPrintSQLCallstack(false);
            return newDao;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Result clearNodeValueLastHistoryData() {
        return ErrorDesc.success();
    }
}
