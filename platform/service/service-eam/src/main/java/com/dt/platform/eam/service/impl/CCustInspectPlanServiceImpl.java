package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.CCustInspectTaskStatusEnum;
import com.dt.platform.domain.eam.CCustInspectTask;
import com.dt.platform.domain.eam.CCustInspectUserS;
import com.dt.platform.domain.eam.meta.CCustInspectPlanMeta;
import com.dt.platform.eam.service.ICCustInspectTaskService;
import com.dt.platform.eam.service.ICCustInspectUserSService;
import com.foxnicweb.web.constants.enums.contract.StatusEnum;
import org.github.foxnic.web.domain.hrm.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.eam.CCustInspectPlan;
import com.dt.platform.domain.eam.CCustInspectPlanVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import com.dt.platform.eam.service.ICCustInspectPlanService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 巡检计划服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-07 10:57:13
*/


@Service("EamCCustInspectPlanService")

public class CCustInspectPlanServiceImpl extends SuperService<CCustInspectPlan> implements ICCustInspectPlanService {

	@Autowired
	private ICCustInspectTaskService cCustInspectTaskService;


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
	private ICCustInspectUserSService cCustInspectUserSService;



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param cCustInspectPlan  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CCustInspectPlan cCustInspectPlan,boolean throwsException) {
		Result r=super.insert(cCustInspectPlan,throwsException);
		if(r.isSuccess()){
			List<String> userIds=cCustInspectPlan.getMemberIds();
			if(userIds!=null){
				for(String userId:userIds){
					CCustInspectUserS u=new CCustInspectUserS();
					u.setUserId(userId);
					u.setOwnerId(cCustInspectPlan.getId());
					cCustInspectUserSService.insert(u,false);
				}
			}

		}

		return r;
	}

	@Override
	public Result execute(String id, String type) {
		CCustInspectPlan plan=this.getById(id);
		if(!StatusEnum.VALID.code().equals(plan.getStatus())){
			return ErrorDesc.failureMessage("当前计划单状态无效，无法生成任务单");
		}
		dao().fill(plan).with("leader").with(CCustInspectPlanMeta.CUST_INSPECT_ITEM_LIST).with(CCustInspectPlanMeta.MEMBER_LIST).with(CCustInspectPlanMeta.CUST_INSPECT_TPL).execute();
		CCustInspectTask task=new CCustInspectTask();
		task.setStatus(CCustInspectTaskStatusEnum.WAIT.code());
		task.setTenantId(plan.getTenantId());
		task.setName(plan.getName());
		task.setTplId(plan.getTplId());
		task.setActionAdd(plan.getActionAdd());
		task.setInspectUserId(plan.getInspectUserId());
		List<Employee> users=plan.getMemberList();
		List<String> userIds=new ArrayList<>();
		if(users!=null&& users.size()>0){
			for(Employee user:users){
				 userIds.add(user.getId());
			}
		}
		task.setMemberIds(userIds);
		cCustInspectTaskService.insert(task,false);
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param cCustInspectPlan 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CCustInspectPlan cCustInspectPlan) {
		return this.insert(cCustInspectPlan,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param cCustInspectPlanList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CCustInspectPlan> cCustInspectPlanList) {
		return super.insertList(cCustInspectPlanList);
	}

	
	/**
	 * 按主键删除巡检计划
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CCustInspectPlan cCustInspectPlan = new CCustInspectPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		cCustInspectPlan.setId(id);
		try {
			boolean suc = dao.deleteEntity(cCustInspectPlan);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除巡检计划
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CCustInspectPlan cCustInspectPlan = new CCustInspectPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		cCustInspectPlan.setId(id);
		cCustInspectPlan.setDeleted(true);
		cCustInspectPlan.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		cCustInspectPlan.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(cCustInspectPlan,SaveMode.NOT_NULL_FIELDS);
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
	 * @param cCustInspectPlan 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CCustInspectPlan cCustInspectPlan , SaveMode mode) {
		return this.update(cCustInspectPlan,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param cCustInspectPlan 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CCustInspectPlan cCustInspectPlan , SaveMode mode,boolean throwsException) {
		Result r=super.update(cCustInspectPlan , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from eam_c_cust_inspect_user_s where owner_id=?",cCustInspectPlan.getId());
			List<String> userIds=cCustInspectPlan.getMemberIds();
			if(userIds!=null){
				for(String userId:userIds){
					CCustInspectUserS u=new CCustInspectUserS();
					u.setUserId(userId);
					u.setOwnerId(cCustInspectPlan.getId());
					cCustInspectUserSService.insert(u,false);
				}
			}
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param cCustInspectPlanList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CCustInspectPlan> cCustInspectPlanList , SaveMode mode) {
		return super.updateList(cCustInspectPlanList , mode);
	}

	
	/**
	 * 按主键更新巡检计划
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
	 * 按主键获取巡检计划
	 *
	 * @param id 主键
	 * @return CCustInspectPlan 数据对象
	 */
	public CCustInspectPlan getById(String id) {
		CCustInspectPlan sample = new CCustInspectPlan();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<CCustInspectPlan> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<CCustInspectPlan> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, CCustInspectPlan> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, CCustInspectPlan::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CCustInspectPlan> queryList(CCustInspectPlanVO sample) {
		return super.queryList(sample);
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
	public PagedList<CCustInspectPlan> queryPagedList(CCustInspectPlanVO sample, int pageSize, int pageIndex) {
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
	public PagedList<CCustInspectPlan> queryPagedList(CCustInspectPlan sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param cCustInspectPlan 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CCustInspectPlan cCustInspectPlan) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(cCustInspectPlan, SYS_ROLE.NAME);
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