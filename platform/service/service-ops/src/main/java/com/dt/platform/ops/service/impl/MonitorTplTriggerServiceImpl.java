package com.dt.platform.ops.service.impl;

import javax.annotation.Resource;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.ops.MonitorAlertMethodProcessStatusEnum;
import com.dt.platform.constants.enums.ops.MonitorWarnLevelEnum;
import com.dt.platform.constants.enums.ops.MonitorWarnProcessStatusEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.MonitorAlertBookMeta;
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta;
import com.dt.platform.ops.service.*;
import com.dt.platform.proxy.common.CommonServiceProxy;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.mysql.jdbc.log.Log;
import org.apache.commons.jexl3.*;
import org.github.foxnic.web.domain.hrm.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 触发器服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 20:49:27
*/


@Service("OpsMonitorTplTriggerService")

public class MonitorTplTriggerServiceImpl extends SuperService<MonitorTplTrigger> implements IMonitorTplTriggerService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;


	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired
	private IMonitorAlertService monitorAlertService;

	@Autowired
	private MonitorDataProcessUtilService monitorDataProcessUtilService;

	@Autowired
	private IMonitorAlertEventService monitorAlertEventService;

	@Autowired
	private IMonitorAlertLogService monitorAlertLogService;

	@Autowired
	private IMonitorAlertBookService monitorAlertBookService;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	@Autowired
	private IMonitorNodeService monitorNodeService;

	@Autowired
	private IMonitorNodeTriggerService monitorNodeTriggerService;


	@Override
	public Result createAllNodeTrigger(){
		String sql="select distinct d.id\n" +
				"from \n" +
				"ops_monitor_node_tpl_item a,\n" +
				"ops_monitor_tpl b,\n" +
				"ops_monitor_tpl_trigger c,\n" +
				"ops_monitor_node d\n" +
				"where a.tpl_code=b.code \n" +
				"and b.status='enable'\n" +
				"and c.status='enable'\n" +
				"and c.monitor_tpl_code=a.tpl_code\n" +
				"and d.id=a.node_id\n" +
				"and d.deleted=0\n" +
				"and a.deleted=0\n" +
				"and b.deleted=0\n" +
				"and c.deleted=0";
		RcdSet rs=dao.query(sql);
		Logger.info("createAllNodeTrigger count:"+rs.size());
		for(int i=0;i<rs.size();i++){
			Rcd rcd=rs.getRcd(i);
			createNodeTrigger(rcd.getString("id"));
		}
		return ErrorDesc.success();
	}
	@Override
	public Result createNodeTrigger(String nodeId){

		//重建，不保留原来的指标
		String sql="select c.id trigger_id,c.* from ops_monitor_node_tpl_item a,ops_monitor_tpl b,\n" +
				"ops_monitor_tpl_trigger c \n" +
				"where a.tpl_code=b.code and b.status='enable'\n" +
				"and c.status='enable'\n" +
				"and c.monitor_tpl_code=a.tpl_code\n" +
				"and a.node_id=?";
		RcdSet rs=dao.query(sql,nodeId);
		dao.execute("delete from ops_monitor_node_trigger where node_id=?",nodeId);
		for(int i=0;i<rs.size();i++){
			Rcd rcd=rs.getRcd(i);
			if("static".equals(rcd.getString("rule_type"))){
				MonitorNodeTrigger trigger=new MonitorNodeTrigger();
				trigger.setNodeId(nodeId);
				trigger.setName(rcd.getString("name"));
				trigger.setRuleType(rcd.getString("rule_type"));
				trigger.setMonitorTplCode(rcd.getString("monitor_tpl_code"));
				trigger.setWarnLevel(rcd.getString("warn_level"));
				trigger.setRule(rcd.getString("rule"));
				trigger.setContentValue(rcd.getString("content_value"));
				trigger.setTriggerId(rcd.getString("trigger_id"));
				trigger.setStatus(rcd.getString("status"));
				monitorNodeTriggerService.insert(trigger,false);
			}else if("dynamic".equals(rcd.getString("rule_type"))) {
				String ctl = rcd.getString("rule_discovery");
				JSONObject ctlJson = JSONObject.parseObject(ctl);
				String source = ctlJson.getString("source");
				String mapping = ctlJson.getString("mapping");
				String sql2 = "select \n" +
						"node_id,\n" +
						mapping + ",\n" +
						"max(record_time) rtime\n" +
						"from ops_monitor_node_value where result_status='sucess' \n" +
						"and deleted=0 and indicator_code=? and node_id=?\n" +
						"group by node_id,\n" + mapping;
				RcdSet rs2 = dao.query(sql2, source, nodeId);
				for (int j = 0; j < rs2.size(); j++) {
					Rcd rcd2 = rs2.getRcd(j);
					MonitorNodeTrigger trigger2 = new MonitorNodeTrigger();
					trigger2.setNodeId(nodeId);
					trigger2.setStatus(rcd.getString("status"));
					trigger2.setName(rcd.getString("name"));
					trigger2.setRuleType(rcd.getString("rule_type"));
					trigger2.setMonitorTplCode(rcd.getString("monitor_tpl_code"));
					trigger2.setWarnLevel(rcd.getString("warn_level"));
					String rule_value = rcd.getString("rule");
					String mapping_value = rcd2.getString(mapping);
					trigger2.setRule(rule_value.replaceAll("#<" + mapping + ">#", mapping_value));
					trigger2.setContentValue(rcd.getString("content_value"));
					trigger2.setTriggerId(rcd.getString("trigger_id"));
					if(StringUtil.isBlank(mapping_value)){
						Logger.info("node:"+nodeId+",mapping_value is null");
					}else{
						monitorNodeTriggerService.insert(trigger2, false);
					}

				}
			}
		}
		return ErrorDesc.success();
	}
	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param monitorTplTrigger  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MonitorTplTrigger monitorTplTrigger,boolean throwsException) {
		Result r=super.insert(monitorTplTrigger,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param monitorTplTrigger 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MonitorTplTrigger monitorTplTrigger) {
		return this.insert(monitorTplTrigger,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param monitorTplTriggerList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MonitorTplTrigger> monitorTplTriggerList) {
		return super.insertList(monitorTplTriggerList);
	}

	
	/**
	 * 按主键删除触发器
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MonitorTplTrigger monitorTplTrigger = new MonitorTplTrigger();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		monitorTplTrigger.setId(id);
		try {
			boolean suc = dao.deleteEntity(monitorTplTrigger);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除触发器
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MonitorTplTrigger monitorTplTrigger = new MonitorTplTrigger();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		monitorTplTrigger.setId(id);
		monitorTplTrigger.setDeleted(true);
		monitorTplTrigger.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		monitorTplTrigger.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(monitorTplTrigger,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param monitorTplTrigger 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MonitorTplTrigger monitorTplTrigger , SaveMode mode) {
		return this.update(monitorTplTrigger,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param monitorTplTrigger 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MonitorTplTrigger monitorTplTrigger , SaveMode mode,boolean throwsException) {
		Result r=super.update(monitorTplTrigger , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param monitorTplTriggerList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MonitorTplTrigger> monitorTplTriggerList , SaveMode mode) {
		return super.updateList(monitorTplTriggerList , mode);
	}

	
	/**
	 * 按主键更新触发器
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取触发器
	 *
	 * @param id 主键
	 * @return MonitorTplTrigger 数据对象
	 */
	public MonitorTplTrigger getById(String id) {
		MonitorTplTrigger sample = new MonitorTplTrigger();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<MonitorTplTrigger> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<MonitorTplTrigger> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MonitorTplTrigger> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MonitorTplTrigger::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MonitorTplTrigger> queryList(MonitorTplTriggerVO sample) {
		return super.queryList(sample);
	}


	public List<MonitorTplTrigger> queryCollectDataList() {
		MonitorTplTriggerVO sample=new MonitorTplTriggerVO();
		ConditionExpr expr=new ConditionExpr();
		expr.and("monitor_tpl_code in (select distinct c.code from ops_monitor_node a,ops_monitor_node_tpl_item b,ops_monitor_tpl c \n" +
				"where a.deleted=0 and b.deleted=0 and c.deleted=0\n" +
				"and a.id=b.node_id and a.status='online' and c.status='enable'\n" +
				"and b.tpl_code=c.code)");
		return super.queryList(sample,expr);
	}



	public Result collectData() {
		MonitorNodeVO vo=new MonitorNodeVO();
		ConditionExpr expr=new ConditionExpr();
		expr.and("1=1");
		List<MonitorNode> nodeList=monitorNodeService.queryList(vo,expr);
		dao.fill(nodeList).with(MonitorNodeMeta.TRIGGER_LIST).execute();
		Logger.info("collectData,find node number:"+nodeList.size());
		// 创建 ForkJoin 工具，其中 输入一个 Integer 元素的 List ，输出 Long 元素的 List ，每个线程处理 若干元素 ，此处为 5 个
		SimpleJoinForkTask<MonitorNode,Result> task=new SimpleJoinForkTask<>(nodeList,20);
		// 并行执行
		List<Result> rvs=task.execute(els->{
			// 打印当前线程信息
			Logger.info(Thread.currentThread().getName());
			// 处理当前分到的 若干元素，此处为 5 个
			List<Result> rs=new ArrayList<>();
			for (MonitorNode node : els) {
				Result result=collectMonitorTriggerData(node);
				if(!result.isSuccess()){
					Logger.info("node :"+node.getNodeNameShow()+",message:"+result.getMessage());
				}
				rs.add(result);
			}
			// 处理完毕，返回本批次的处理结果，由 SimpleJoinForkTask 负责合并全部结果，并由 rvs 变量接收
			return rs;
		});
		return ErrorDesc.success();
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
		Logger.info("calculationValue"+r);
		if (null ==r) {
			return "";
		}
		return r.toString();
	}



	public Result collectMonitorTriggerData(MonitorNode node) {
		List<MonitorNodeTrigger> triggerList=node.getTriggerList();
		if(triggerList!=null&& triggerList.size()>0){
			for(MonitorNodeTrigger trigger:triggerList){
				Result r=collectTriggerNodeData(node,trigger);
			}
		}
		return ErrorDesc.success();

	}

	public Result actionToAlert(MonitorAlert alert){
		String nodeId=alert.getNodeId();
		String warnLevel=alert.getWarnLevel();
		ConcurrentHashMap map=new ConcurrentHashMap();
		String sql="select distinct id from (\n" +
				"select a.id\n" +
				"from ops_monitor_alert_book a,ops_monitor_alert_book_rule alertLevel \n" +
				"where a.status='enable' and a.monitor_is_all='yes' and a.id=alertLevel.book_id \n" +
				"and alertLevel.type='alert_level' and alertLevel.value='#<LEVEL>#'\n" +
				"union all\n" +
				"select a.id\n" +
				"from ops_monitor_alert_book a,ops_monitor_alert_book_rule alertLevel,\n" +
				"ops_monitor_alert_book_rule alertNodeGroup \n" +
				"where a.status='enable' and a.monitor_is_all='no' \n" +
				"and alertLevel.book_id =a.id and alertLevel.type='alert_level' and alertLevel.value='#<LEVEL>#'\n" +
				"and alertNodeGroup.book_id =a.id and alertNodeGroup.type='alert_node_group' \n" +
				"and alertNodeGroup.value in (select value from ops_monitor_alert_book_rule where type='node_group' and book_id='#<NODE_ID>#')\n" +
				"union all\n" +
				"select a.id\n" +
				"from ops_monitor_alert_book a,ops_monitor_alert_book_rule alertLevel,\n" +
				"ops_monitor_alert_book_rule alertNode \n" +
				"where a.status='enable' and a.monitor_is_all='no' \n" +
				"and alertLevel.book_id =a.id and alertLevel.type='alert_level' and alertLevel.value='#<LEVEL>#'\n" +
				"and alertNode.book_id =a.id and alertNode.type='alert_node' \n" +
				"and alertNode.value='#<NODE_ID>#'\n" +
				")t";
		MonitorAlertBookVO book=new MonitorAlertBookVO();
		ConditionExpr expr=new ConditionExpr();
		expr.and("id in ("+sql.replaceAll("#<NODE_ID>#",nodeId).replaceAll("#<LEVEL>#",warnLevel)+")");
		List<MonitorAlertBook> bookList=monitorAlertBookService.queryList(book,expr);
		if(bookList.size()>0){
			dao.fill(bookList).with(MonitorAlertBookMeta.USER_LIST).with(MonitorAlertBookMeta.USER_GROUP_USER_LIST).with(MonitorAlertBookMeta.ALERT_METHOD_LIST).execute();
			for(int i=0;i<bookList.size();i++) {
				List<MonitorAlertMethod> methodList=bookList.get(i).getAlertMethodList();
				List<Employee> user1List=bookList.get(i).getUserList();
				List<Employee> user2List=bookList.get(i).getUserGroupUserList();
				user1List.addAll(user2List);
				for(int m=0;m<methodList.size();m++){
					for(int u=0;u<user1List.size();u++) {
						Employee user=user1List.get(u);
						MonitorAlertMethod method=methodList.get(m);
						String key=user.getId()+"_"+method.getId()+"_"+alert.getId();
						if(map.containsKey(key)){
							Logger.info("本条已处理，不需要重复处理,key:"+key);
							continue;
						}else{
							actionToAlertNotice(alert,method,user);
						}
					}
				}
			}
		}
		return ErrorDesc.success();
	}

	public Result actionToAlertNotice(MonitorAlert alert,MonitorAlertMethod method,Employee user){

		if("enable".equals(method.getStatus())){
			DateFormat d=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SSS毫秒");
			String body=method.getBody()
					.replace("#<NODE>#",alert.getNodeShowName())
					.replace("#<ACTION>#","告警")
					.replace("#<WARN_LEVEL>#",EnumUtil.parseByCode(MonitorWarnLevelEnum.class,alert.getWarnLevel()).text())
					.replace("#<TRIGGER_NAME>#",alert.getTriggerName())
					.replace("#<RULE_NAME>#",alert.getTriggerRuleDesc())
					.replace("#<VALUE>#",alert.getAlertValue())
					.replace("#<WARN_TIME>#",d.format(alert.getWarnTime()));
			MonitorAlertLog log=new MonitorAlertLog();
			log.setAlertId(alert.getId());
			log.setUserId(user.getId());
			log.setMsg(body);
			log.setRcdTime(new Date());
			if("shell".equals(method.getType())){
				log.setAlertMethod("脚本");
				log.setActionResultStatus(MonitorAlertMethodProcessStatusEnum.SUCCESS.code());
				String cmd=method.getCmd()
						.replace("#<NODE>#",alert.getNodeShowName())
						.replace("#<ACTION>#","告警")
						.replace("#<WARN_LEVEL>#",EnumUtil.parseByCode(MonitorWarnLevelEnum.class,alert.getWarnLevel()).text())
						.replace("#<TRIGGER_NAME>#",alert.getTriggerName())
						.replace("#<RULE_NAME>#",alert.getTriggerRuleDesc())
						.replace("#<VALUE>#",alert.getAlertValue())
						.replace("#<WARN_TIME>#",d.format(alert.getWarnTime()))
						.replace("#<MOBILE>#",user.getPhone()==null?"0000":user.getPhone())
						.replace("#<MSG>#",body);
				try {
					Logger.info("执行脚本:"+cmd);
					Process process = Runtime.getRuntime().exec(cmd);
					BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line;
					while((line = reader.readLine()) != null) {
						Logger.info(line);
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					log.setActionResultStatus(MonitorAlertMethodProcessStatusEnum.FAILED.code());
					log.setActionResult(e.getMessage());
				}
			}else if("api".equals(method.getType())){
				log.setAlertMethod("接口");
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("node",alert.getNodeShowName());
				params.put("action","告警");
				params.put("warn_level",EnumUtil.parseByCode(MonitorWarnLevelEnum.class,alert.getWarnLevel()).text());
				params.put("trigger_name",alert.getTriggerName());
				params.put("rule_name",alert.getTriggerRuleDesc());
				params.put("value",alert.getAlertValue());
				params.put("warn_time",d.format(alert.getWarnTime()));
				params.put("mobile",user.getPhone()==null?"0000":user.getPhone());
				Result<Object> res=CommonServiceProxy.api().callMagicAPIService("execute","POST",method.getCmd(),params);
				if(res.success()){
					Logger.info("接口返回:"+res.data().toString());
					log.setActionResultStatus(MonitorAlertMethodProcessStatusEnum.SUCCESS.code());
					if(res.data().toString().contains("success=true")){
						log.setActionResultStatus(MonitorAlertMethodProcessStatusEnum.SUCCESS.code());
					}else{
						log.setActionResultStatus(MonitorAlertMethodProcessStatusEnum.FAILED.code());
						log.setActionResult("调用异常");
					}
				}else{
					log.setActionResultStatus(MonitorAlertMethodProcessStatusEnum.FAILED.code());
					log.setActionResult(res.getMessage());
				}
			}
			monitorAlertLogService.insert(log,true);
		}
		return ErrorDesc.success();
	}


	public Result collectTriggerNodeData(MonitorNode node,MonitorNodeTrigger trigger) {

		if(!"enable".equals(trigger.getStatus())){
			return ErrorDesc.success();
		}
		Result res=new Result();
	 	String rule=trigger.getRule();
		String ct=trigger.getContentValue();
		Map<String, Object> map = new HashMap<String, Object>();
		node.setCalIndicatorTplCode(trigger.getMonitorTplCode());
		node.setTriggerDataList(new ArrayList<>());
		map.put("node", node);
		Object result = calculationValue(rule,map);
		String[] msg=trigger.getContentValue().split("#<");
		List<String> keyList=new ArrayList<>();
		for(int i=0;i<msg.length;i++){
			if(msg[i].contains(">#")){
				String[] key= msg[i].split(">#") ;
				keyList.add(key[0]);
			}
		}
		if("true".equals(result)){
			res.success(true);
			MonitorNodeTriggerLastData triggerData=node.getTriggerData();
			if(triggerData!=null){
				ConditionExpr expr=new ConditionExpr();
				//List<String> ids=triggerDataList.stream().map(MonitorNodeTriggerLastData::getId).collect(Collectors.toList());
				expr.and("event_id=?",triggerData.getId());
				List<MonitorAlertEvent> list= monitorAlertEventService.queryList(new MonitorAlertEventVO(),expr);
				if(list.size()>0){
					Logger.info("当前Event已记录过");
				}else {
					Logger.info("当前Event需要告警");
//					for (int i = 0; i < triggerDataList.size(); i++) {
						MonitorAlert alert = new MonitorAlert();
						alert.setNodeId(node.getId());
						alert.setNodeShowName(node.getNodeNameShow());
						alert.setWarnTime(new Date());
						alert.setTriggerId(trigger.getId());
						alert.setTriggerName(trigger.getName());
						alert.setTriggerRuleDesc(trigger.getName());
						alert.setWarnLevel(trigger.getWarnLevel());
						Logger.info("开始替换内容,triggerDataList.get(i)",triggerData.getSourceData());
						for(String key:keyList ){
							Logger.info(key);
							String keyValue=triggerData.getSourceData().getString(key);
							if(keyValue!=null){
								ct=ct.replaceAll("#<"+key+">#",keyValue);
							}
						}
						alert.setAlertValue(ct);
						alert.setStatus(MonitorWarnProcessStatusEnum.NOT_CONFIRM.code());
						monitorAlertService.insert(alert, true);
						actionToAlert(alert);
						MonitorAlertEvent event = new MonitorAlertEvent();
						event.setEventId(triggerData.getId());
						event.setAlertId(alert.getId());
						monitorAlertEventService.insert(event, true);
					}
				//}
			}
		}else if("false".equals(result)){
			res.success(false);
		}
		return res;
	}
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<MonitorTplTrigger> queryPagedList(MonitorTplTriggerVO sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}

	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<MonitorTplTrigger> queryPagedList(MonitorTplTrigger sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param monitorTplTrigger 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MonitorTplTrigger monitorTplTrigger) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(monitorTplTrigger, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}





}