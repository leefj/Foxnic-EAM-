package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.AttendanceProcessMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.hr.service.IAttendanceDataService;
import com.dt.platform.hr.service.IPersonService;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.sql.expr.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.text.SimpleDateFormat;
import java.util.*;


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
import com.dt.platform.hr.service.IAttendanceProcessService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 考勤跑批服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-25 15:10:10
*/


@Service("HrAttendanceProcessService")

public class AttendanceProcessServiceImpl extends SuperService<AttendanceProcess> implements IAttendanceProcessService {

	@Autowired
	private IAttendanceDataService attendanceDataService;

	@Autowired
	private IPersonService personService;

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
	 * @param attendanceProcess  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AttendanceProcess attendanceProcess,boolean throwsException) {
		Result r=super.insert(attendanceProcess,throwsException);
		if(r.isSuccess()){
			List<String> idsList=attendanceProcess.getPersonIds();
			for(String itemId:idsList){
				Insert ins= new Insert("sys_mapping_owner");
				ins.set("id",IDGenerator.getSnowflakeIdString());
				ins.set("owner_id",attendanceProcess.getId());
				ins.set("selected_code",itemId);
				ins.set("owner","def");
				dao.execute(ins);
			}
		}
		return r;
	}

	@Override
	public Result process(String id) {
		AttendanceProcess data=this.getById(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate=data.getSdate();
		Date eDate=data.getEdate();
		Date curDate=sDate;
		dao.fill(data).with(AttendanceProcessMeta.PERSON_LIST).execute();
		List<Person> personList=data.getPersonList();
		if(YesNoEnum.YES.code().equals(data.getIsAllPerson())){
			personList=personService.queryList(new PersonVO());
		}
		dao.fill(personList).with(PersonMeta.ATTENDANCE_TPL).execute();
		String batchCode=IDGenerator.getSnowflakeIdString();
		for(Person person:personList){
			Logger.info("当前用户:"+person.getName());
			curDate=sDate;
			while (curDate.getTime()<=eDate.getTime()){
				attendanceDataService.processSourceDataByPerson(sdf.format(curDate),person,batchCode);
				//处理后加一天
				Calendar calendar = Calendar.getInstance();
				// 将 Calendar 设置为当前日期
				calendar.setTime(curDate);
				// 为 Calendar 增加一天
				calendar.add(Calendar.DATE, 1);
				// 获取增加一天后的日期
				Date nextDate = calendar.getTime();
				curDate=nextDate;
			}

		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param attendanceProcess 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AttendanceProcess attendanceProcess) {
		return this.insert(attendanceProcess,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param attendanceProcessList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AttendanceProcess> attendanceProcessList) {
		return super.insertList(attendanceProcessList);
	}

	
	/**
	 * 按主键删除考勤跑批
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AttendanceProcess attendanceProcess = new AttendanceProcess();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		attendanceProcess.setId(id);
		try {
			boolean suc = dao.deleteEntity(attendanceProcess);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除考勤跑批
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AttendanceProcess attendanceProcess = new AttendanceProcess();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		attendanceProcess.setId(id);
		attendanceProcess.setDeleted(true);
		attendanceProcess.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		attendanceProcess.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(attendanceProcess,SaveMode.NOT_NULL_FIELDS);
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
	 * @param attendanceProcess 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AttendanceProcess attendanceProcess , SaveMode mode) {
		return this.update(attendanceProcess,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param attendanceProcess 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AttendanceProcess attendanceProcess , SaveMode mode,boolean throwsException) {
		Result r=super.update(attendanceProcess , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from sys_mapping_owner where owner_id=?",attendanceProcess.getId());
			List<String> idsList=attendanceProcess.getPersonIds();
			for(String itemId:idsList){
				Insert ins= new Insert("sys_mapping_owner");
				ins.set("id",IDGenerator.getSnowflakeIdString());
				ins.set("owner_id",attendanceProcess.getId());
				ins.set("selected_code",itemId);
				ins.set("owner","def");
				dao.execute(ins);
			}
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param attendanceProcessList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AttendanceProcess> attendanceProcessList , SaveMode mode) {
		return super.updateList(attendanceProcessList , mode);
	}

	
	/**
	 * 按主键更新考勤跑批
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
	 * 按主键获取考勤跑批
	 *
	 * @param id 主键
	 * @return AttendanceProcess 数据对象
	 */
	public AttendanceProcess getById(String id) {
		AttendanceProcess sample = new AttendanceProcess();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AttendanceProcess> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AttendanceProcess> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AttendanceProcess> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AttendanceProcess::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AttendanceProcess> queryList(AttendanceProcessVO sample) {
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
	public PagedList<AttendanceProcess> queryPagedList(AttendanceProcessVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AttendanceProcess> queryPagedList(AttendanceProcess sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param attendanceProcess 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AttendanceProcess attendanceProcess) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(attendanceProcess, SYS_ROLE.NAME);
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