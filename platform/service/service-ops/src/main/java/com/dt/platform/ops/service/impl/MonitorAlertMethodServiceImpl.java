package com.dt.platform.ops.service.impl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.ops.MonitorAlertMethod;
import com.dt.platform.domain.ops.MonitorAlertMethodVO;
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
import com.dt.platform.ops.service.IMonitorAlertMethodService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 告警方式服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 07:43:20
*/


@Service("OpsMonitorAlertMethodService")

public class MonitorAlertMethodServiceImpl extends SuperService<MonitorAlertMethod> implements IMonitorAlertMethodService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

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
	 * @param monitorAlertMethod  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MonitorAlertMethod monitorAlertMethod,boolean throwsException) {
		Result r=super.insert(monitorAlertMethod,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param monitorAlertMethod 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MonitorAlertMethod monitorAlertMethod) {
		return this.insert(monitorAlertMethod,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param monitorAlertMethodList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MonitorAlertMethod> monitorAlertMethodList) {
		return super.insertList(monitorAlertMethodList);
	}

	
	/**
	 * 按主键删除告警方式
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MonitorAlertMethod monitorAlertMethod = new MonitorAlertMethod();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		monitorAlertMethod.setId(id);
		try {
			boolean suc = dao.deleteEntity(monitorAlertMethod);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除告警方式
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MonitorAlertMethod monitorAlertMethod = new MonitorAlertMethod();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		monitorAlertMethod.setId(id);
		monitorAlertMethod.setDeleted(true);
		monitorAlertMethod.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		monitorAlertMethod.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(monitorAlertMethod,SaveMode.NOT_NULL_FIELDS);
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
	 * @param monitorAlertMethod 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MonitorAlertMethod monitorAlertMethod , SaveMode mode) {
		return this.update(monitorAlertMethod,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param monitorAlertMethod 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MonitorAlertMethod monitorAlertMethod , SaveMode mode,boolean throwsException) {
		Result r=super.update(monitorAlertMethod , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param monitorAlertMethodList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MonitorAlertMethod> monitorAlertMethodList , SaveMode mode) {
		return super.updateList(monitorAlertMethodList , mode);
	}

	
	/**
	 * 按主键更新告警方式
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
	 * 按主键获取告警方式
	 *
	 * @param id 主键
	 * @return MonitorAlertMethod 数据对象
	 */
	public MonitorAlertMethod getById(String id) {
		MonitorAlertMethod sample = new MonitorAlertMethod();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<MonitorAlertMethod> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<MonitorAlertMethod> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MonitorAlertMethod> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MonitorAlertMethod::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MonitorAlertMethod> queryList(MonitorAlertMethodVO sample) {
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
	public PagedList<MonitorAlertMethod> queryPagedList(MonitorAlertMethodVO sample, int pageSize, int pageIndex) {
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
	public PagedList<MonitorAlertMethod> queryPagedList(MonitorAlertMethod sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param monitorAlertMethod 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MonitorAlertMethod monitorAlertMethod) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(monitorAlertMethod, SYS_ROLE.NAME);
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