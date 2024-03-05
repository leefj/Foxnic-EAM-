package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.YesNoEnum;
import com.github.foxnic.sql.expr.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import com.dt.platform.domain.hr.AttendanceDate;
import com.dt.platform.domain.hr.AttendanceDateVO;
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
import com.dt.platform.hr.service.IAttendanceDateService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 考勤日期服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 09:11:25
*/


@Service("HrAttendanceDateService")

public class AttendanceDateServiceImpl extends SuperService<AttendanceDate> implements IAttendanceDateService {

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


	public  String dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "w7", "w1", "w2", "w3", "w4", "w5", "w6" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param attendanceDate  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AttendanceDate attendanceDate,boolean throwsException) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

		if(YesNoEnum.YES.code().equals(attendanceDate.getConfCreateDate())){
			int max=1000;
			int i=0;
			Date cur=attendanceDate.getConfSDate();
			while (cur.getTime()<=attendanceDate.getConfEDate().getTime()){
				String curDateStr=sdf.format(cur);
				String curDateYearStr=sdfYear.format(cur);
				dao.execute("delete from hr_attendance_date where date_str=?",curDateStr);
				AttendanceDate ins=new AttendanceDate();
				ins.setId(IDGenerator.getSnowflakeIdString());
				ins.setDateStr(curDateStr);
				ins.setYear(curDateYearStr);
				String week=dateToWeek(curDateStr);
				ins.setWeek(week);
				if("w6".equals(week)||"w7".equals(week)){
					ins.setAttendancSign(YesNoEnum.no.code());
				}else{
					ins.setAttendancSign(YesNoEnum.YES.code());
				}
				Result r=super.insert(ins,throwsException);
				System.out.println("process date: " + curDateStr);
				//处理后加一天
				Calendar calendar = Calendar.getInstance();
				// 将 Calendar 设置为当前日期
				calendar.setTime(cur);
				// 为 Calendar 增加一天
				calendar.add(Calendar.DATE, 1);
				// 获取增加一天后的日期
				Date nextDate = calendar.getTime();
				cur=nextDate;
				System.out.println("next date: " + cur);
				i++;
				if(i>max){
					break;
				}
			}
			return ErrorDesc.success();
		}else{
			Result r=super.insert(attendanceDate,throwsException);
			if(r.isSuccess()){
				List<String> idsList=attendanceDate.getAttendanceTplIdsList();
				for(String itemId:idsList){
					Insert ins= new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",attendanceDate.getId());
					ins.set("selected_code",itemId);
					dao.execute(ins);
				}

				List<String> idsList2=attendanceDate.getAttendanceTplIdsList2();
				for(String itemId:idsList2){
					Insert ins= new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",attendanceDate.getId());
					ins.set("owner","need");
					ins.set("selected_code",itemId);
					dao.execute(ins);
				}

				List<String> idsList3=attendanceDate.getAttendanceTplIdsList3();
				if(idsList3!=null){
					for(String itemId:idsList3){
						Insert ins= new Insert("sys_mapping_owner");
						ins.set("id",IDGenerator.getSnowflakeIdString());
						ins.set("owner_id",attendanceDate.getId());
						ins.set("owner","half");
						ins.set("selected_code",itemId);
						dao.execute(ins);
					}
				}

			}
			return r;
		}
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param attendanceDate 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AttendanceDate attendanceDate) {
		return this.insert(attendanceDate,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param attendanceDateList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AttendanceDate> attendanceDateList) {
		return super.insertList(attendanceDateList);
	}

	
	/**
	 * 按主键删除考勤日期
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AttendanceDate attendanceDate = new AttendanceDate();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		attendanceDate.setId(id);
		try {
			boolean suc = dao.deleteEntity(attendanceDate);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除考勤日期
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AttendanceDate attendanceDate = new AttendanceDate();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		attendanceDate.setId(id);
		attendanceDate.setDeleted(true);
		attendanceDate.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		attendanceDate.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(attendanceDate,SaveMode.NOT_NULL_FIELDS);
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
	 * @param attendanceDate 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AttendanceDate attendanceDate , SaveMode mode) {
		return this.update(attendanceDate,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param attendanceDate 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AttendanceDate attendanceDate , SaveMode mode,boolean throwsException) {
		Result r=super.update(attendanceDate , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from sys_mapping_owner where owner_id=?",attendanceDate.getId());
			List<String> idsList=attendanceDate.getAttendanceTplIdsList();
			for(String itemId:idsList){
				Insert ins= new Insert("sys_mapping_owner");
				ins.set("id",IDGenerator.getSnowflakeIdString());
				ins.set("owner_id",attendanceDate.getId());
				ins.set("selected_code",itemId);
				dao.execute(ins);
			}

			List<String> idsList2=attendanceDate.getAttendanceTplIdsList2();

			for(String itemId:idsList2){
				Insert ins= new Insert("sys_mapping_owner");
				ins.set("id",IDGenerator.getSnowflakeIdString());
				ins.set("owner_id",attendanceDate.getId());
				ins.set("owner","need");
				ins.set("selected_code",itemId);
				dao.execute(ins);
			}

			List<String> idsList3=attendanceDate.getAttendanceTplIdsList3();
			if(idsList3!=null){
				for(String itemId:idsList3){
					Insert ins= new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",attendanceDate.getId());
					ins.set("owner","half");
					ins.set("selected_code",itemId);
					dao.execute(ins);
				}
			}


		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param attendanceDateList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AttendanceDate> attendanceDateList , SaveMode mode) {
		return super.updateList(attendanceDateList , mode);
	}

	
	/**
	 * 按主键更新考勤日期
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
	 * 按主键获取考勤日期
	 *
	 * @param id 主键
	 * @return AttendanceDate 数据对象
	 */
	public AttendanceDate getById(String id) {
		AttendanceDate sample = new AttendanceDate();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AttendanceDate> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AttendanceDate> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AttendanceDate> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AttendanceDate::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AttendanceDate> queryList(AttendanceDateVO sample) {
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
	public PagedList<AttendanceDate> queryPagedList(AttendanceDateVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AttendanceDate> queryPagedList(AttendanceDate sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param attendanceDate 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AttendanceDate attendanceDate) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(attendanceDate, SYS_ROLE.NAME);
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