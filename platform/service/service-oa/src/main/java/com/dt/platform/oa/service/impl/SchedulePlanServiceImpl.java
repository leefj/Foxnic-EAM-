package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.RcdSet;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.oa.SchedulePlan;
import com.dt.platform.domain.oa.SchedulePlanVO;
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
import com.dt.platform.oa.service.ISchedulePlanService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 日程安排服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-25 10:32:46
*/


@Service("OaSchedulePlanService")

public class SchedulePlanServiceImpl extends SuperService<SchedulePlan> implements ISchedulePlanService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private final DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param schedulePlan  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(SchedulePlan schedulePlan,boolean throwsException) {
		schedulePlan.setUserId(SessionUser.getCurrent().getActivatedEmployeeId()) ;
		Result r=super.insert(schedulePlan,throwsException);
		return r;
	}

	@Override
	public Result<JSONArray> queryPlan(String startStr, String endStr) {
		String userId=SessionUser.getCurrent().getActivatedEmployeeId();
		Result<JSONArray> res=new Result<>();
		String sql="select full_day,id,content title,rank,date_format(f_time,'%Y-%m-%d %H:%i:%s')start,date_format(t_time,'%Y-%m-%d %H:%i:%s')end from oa_schedule_plan where user_id=? and deleted=0 ";
		if(!StringUtil.isBlank(startStr)){
			sql=sql+" and f_time>=date_format('"+startStr+"','%Y-%m-%d %H:%i:%s')";
		}
		if(!StringUtil.isBlank(endStr)){
			sql=sql+" and f_time<=date_format('"+endStr+"','%Y-%m-%d %H:%i:%s')";
		}
		RcdSet rs=dao.query(sql,userId);
		JSONArray data=new JSONArray();
		for(int i=0;i<rs.size();i++){
			JSONObject obj=rs.getRcd(i).toJSONObject();
			System.out.println("rs.getRcd(i).getString(\"full_day\")"+rs.getRcd(i).getString("full_day"));
			if("1".equals(rs.getRcd(i).getString("full_day"))){
				obj.put("allDay",true);
			}
			data.add(obj);
		}
		res.data(data);
		res.success(true);
		return res;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param schedulePlan 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(SchedulePlan schedulePlan) {
		return this.insert(schedulePlan,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param schedulePlanList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<SchedulePlan> schedulePlanList) {
		return super.insertList(schedulePlanList);
	}

	
	/**
	 * 按主键删除日程安排
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		SchedulePlan schedulePlan = new SchedulePlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		schedulePlan.setId(id);
		try {
			boolean suc = dao.deleteEntity(schedulePlan);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除日程安排
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		SchedulePlan schedulePlan = new SchedulePlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		schedulePlan.setId(id);
		schedulePlan.setDeleted(true);
		schedulePlan.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		schedulePlan.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(schedulePlan,SaveMode.NOT_NULL_FIELDS);
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
	 * @param schedulePlan 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(SchedulePlan schedulePlan , SaveMode mode) {
		return this.update(schedulePlan,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param schedulePlan 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(SchedulePlan schedulePlan , SaveMode mode,boolean throwsException) {
		Result r=super.update(schedulePlan , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param schedulePlanList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<SchedulePlan> schedulePlanList , SaveMode mode) {
		return super.updateList(schedulePlanList , mode);
	}

	
	/**
	 * 按主键更新日程安排
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取日程安排
	 *
	 * @param id ID
	 * @return SchedulePlan 数据对象
	 */
	public SchedulePlan getById(String id) {
		SchedulePlan sample = new SchedulePlan();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<SchedulePlan> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<SchedulePlan> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, SchedulePlan> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, SchedulePlan::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<SchedulePlan> queryList(SchedulePlanVO sample) {
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
	public PagedList<SchedulePlan> queryPagedList(SchedulePlanVO sample, int pageSize, int pageIndex) {
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
	public PagedList<SchedulePlan> queryPagedList(SchedulePlan sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param schedulePlan 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(SchedulePlan schedulePlan) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(schedulePlan, SYS_ROLE.NAME);
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