package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import ch.qos.logback.classic.jmx.MBeanUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AttendanceRcdProcessStatusEnum;
import com.dt.platform.constants.enums.hr.AttendanceTplDayTypeEnum;
import com.dt.platform.constants.enums.hr.EmployeeStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.hr.service.IAttendanceDataProcessService;
import com.dt.platform.hr.service.IAttendanceRecordService;
import com.dt.platform.hr.service.IPersonService;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.sql.expr.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.math.BigDecimal;
import java.text.ParseException;
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
import com.dt.platform.hr.service.IAttendanceDataService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 考勤汇总服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 15:02:21
*/


@Service("HrAttendanceDataService")

public class AttendanceDataServiceImpl extends SuperService<AttendanceData> implements IAttendanceDataService {

	@Autowired
	private IAttendanceDataProcessService attendanceDataProcessService;

	@Autowired
	private IAttendanceDataService attendanceDataService;

	@Autowired
	private IAttendanceRecordService attendanceRecordService;

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
	 * @param attendanceData  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AttendanceData attendanceData,boolean throwsException) {
		Result r=super.insert(attendanceData,throwsException);
		return r;
	}

	@Override
	public Result<JSONArray> queryDataForCal(String type,String personId,String startStr,String endStr) {
		Result<JSONArray> res=new Result<>();
		JSONArray arr=new JSONArray();
		if(StringUtil.isBlank(personId)){
			personId="none";
		}
		String sql="select '1' all_day, '' title, id,  date_format(on_work_time,'%H:%i')on_work_time_str,date_format(off_work_time,'%H:%i')off_work_time_str, date_format(attendance_date,'%Y-%m-%d')start,result,is_work_day from hr_attendance_data where person_id=? and deleted=0 ";
		if(!StringUtil.isBlank(startStr)){
			sql=sql+" and attendance_date>=date_format('"+startStr+"','%Y-%m-%d %H:%i:%s')";
		}
		if(!StringUtil.isBlank(endStr)){
			sql=sql+" and attendance_date<=date_format('"+endStr+"','%Y-%m-%d %H:%i:%s')";
		}
		RcdSet rs=dao.query(sql,personId);
		JSONArray data=new JSONArray();
		for(int i=0;i<rs.size();i++){
			JSONObject obj=rs.getRcd(i).toJSONObject();
			System.out.println("rs.getRcd(i).getString(\"full_day\")"+rs.getRcd(i).getString("full_day"));
			if("1".equals(rs.getRcd(i).getString("full_day"))){
				obj.put("allDay",true);
			}
			String title="";
			if("yes".equals(rs.getRcd(i).getString("is_work_day"))){
				title="上班:"+rs.getRcd(i).getString("on_work_time_str")+",下班"+rs.getRcd(i).getString("off_work_time_str")+" "+rs.getRcd(i).getString("result");
			}else{
				title="休息日";
			}
			obj.put("title",title);
			data.add(obj);
		}
		res.success();
		res.data(data);
 		return res;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param attendanceData 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AttendanceData attendanceData) {
		return this.insert(attendanceData,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param attendanceDataList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AttendanceData> attendanceDataList) {
		return super.insertList(attendanceDataList);
	}

	
	/**
	 * 按主键删除考勤汇总
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AttendanceData attendanceData = new AttendanceData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		attendanceData.setId(id);
		try {
			boolean suc = dao.deleteEntity(attendanceData);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除考勤汇总
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AttendanceData attendanceData = new AttendanceData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		attendanceData.setId(id);
		attendanceData.setDeleted(true);
		attendanceData.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		attendanceData.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(attendanceData,SaveMode.NOT_NULL_FIELDS);
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
	 * @param attendanceData 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AttendanceData attendanceData , SaveMode mode) {
		return this.update(attendanceData,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param attendanceData 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AttendanceData attendanceData , SaveMode mode,boolean throwsException) {
		Result r=super.update(attendanceData , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param attendanceDataList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AttendanceData> attendanceDataList , SaveMode mode) {
		return super.updateList(attendanceDataList , mode);
	}

	
	/**
	 * 按主键更新考勤汇总
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
	 * 按主键获取考勤汇总
	 *
	 * @param id 主键
	 * @return AttendanceData 数据对象
	 */
	public AttendanceData getById(String id) {
		AttendanceData sample = new AttendanceData();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AttendanceData> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AttendanceData> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AttendanceData> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AttendanceData::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AttendanceData> queryList(AttendanceDataVO sample) {
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
	public PagedList<AttendanceData> queryPagedList(AttendanceDataVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AttendanceData> queryPagedList(AttendanceData sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	@Override
	public PagedList<AttendanceData> queryMonthPagedList(AttendanceDataVO sample, int pageSize, int pageIndex) {

		JSONObject searchValue=JSONObject.parseObject(sample.getSearchValue());
		String personId="";
		String dateStr="";
		if(searchValue.containsKey("personId")){
			JSONObject value=searchValue.getJSONObject("personId");
			if(!StringUtil.isBlank(value.getJSONArray("value"))){
				JSONArray arr=value.getJSONArray("value");
				if(arr.size()>0){
					personId=arr.getString(0);
				}
			}
		}
		if(!StringUtil.isBlank(sample.getPersonId())){
			personId=sample.getPersonId();
		}
		if(searchValue.containsKey("attendanceDate")){
			JSONObject value=searchValue.getJSONObject("attendanceDate");
			if(!StringUtil.isBlank(value.getString("begin"))){
				dateStr=value.getString("begin");
			}
		}
		String sql= "select person_id,date_format(attendance_date,'%Y-%m') attendance_date ,count(1) days, \n" +
				"sum(normal_day)  normal_day ,\n" +
				"sum(need_day)  need_day ,\n" +
				"sum(leave_early)  leave_early ,\n" +
				"sum(leave_early_time)  leave_early_time ,\n" +
				"sum(leave_late)  leave_late ,\n" +
				"sum(leave_late_time)  leave_late_time ,\n" +
				"sum(loss_early)  loss_early ,\n" +
				"sum(loss_late)  loss_late ,\n" +
				"sum(loss_process)  loss_process ,\n" +
				"sum(jb_gzr)  jb_gzr ,\n" +
				"sum(jb_xxr)  jb_xxr ,\n" +
				"sum(jb_jjr)  jb_jjr ,\n" +
				"sum(cc)  cc ,\n" +
				"sum(qj_nj)  qj_nj ,\n" +
				"sum(qj_gsj)  qj_gsj ,\n" +
				"sum(qj_cj)  qj_cj ,\n" +
				"sum(qj_hj)  qj_hj ,\n" +
				"sum(qj_bj)  qj_bj ,\n" +
				"sum(qj_sj)  qj_sj ,\n" +
				"sum(qj_txj)  qj_txj ,\n" +
				"sum(qj_plj)  qj_plj \n" +
				"from hr_attendance_data where 1=1";
		if(!StringUtil.isBlank(personId)){
			sql=sql+" and person_id='"+personId+"'";
		}
		if(!StringUtil.isBlank(dateStr)){
			sql=sql+"attendance_date>= str_to_date('"+dateStr+"', '%Y-%m')";
		}
		sql=sql+" group by person_id,date_format(attendance_date,'%Y-%m')  order by 2 desc  ";
		RcdSet rs=dao.query(sql);
		List<AttendanceData> list=new ArrayList<>();
		for(int i=0;i<rs.size();i++){
			JSONObject obj=rs.getRcd(i).toJSONObject();
			AttendanceData data=BeanUtil.toJavaObject(obj,AttendanceData.class);
			list.add(data);
		}
		int pageCount=rs.size()/pageSize;
		int pageCount2=rs.size()%pageSize;
		if(pageCount2>0){
			pageCount=pageCount+1;
		}
		PagedList<AttendanceData> pageList=new PagedList<>(list,pageSize,pageIndex,pageCount,rs.size());
		return pageList;
	}

	@Override
	public PagedList<AttendanceData> queryAbnormalPagedList(AttendanceData sample, OrderBy orderBy, int pageSize, int pageIndex) {
		return null;
	}


	@Override
	public Result processSourceData(String dateStr, String code) {
		Logger.info("dateStr:"+dateStr,"code:"+code);
		PersonVO personQuery=new PersonVO();
		ConditionExpr expr=new ConditionExpr();
		expr.and("1=1");
		List<Person> list=personService.queryList(personQuery,expr);
		Date sDate=new Date();
		String batchCode=IDGenerator.getSnowflakeIdString();
		Logger.info("任务:"+batchCode+",开始运行");
		for(int i=0;i<list.size();i++){
			processSourceDataByPerson(dateStr,list.get(i),batchCode);
		}
		Date eDate=new Date();
		long diffInMillis = Math.abs(eDate.getTime() - sDate.getTime()); // 计算两个日期之间的毫秒差值
		Logger.info("任务:"+batchCode+",运行结束,耗时:"+(double)diffInMillis / (1000));

		return ErrorDesc.success();
	}

	private String getWeekByDate(String datetime){
		String res="w1";

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



	@Override
	public Result processSourceDataByPerson(String dateStr, Person person,String batchCode) {
		Logger.info("process user:"+person.getName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 定义日期格式
		Date date = null; //
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//判断，如果没有考勤组设置，则返回
		if(person.getAttendanceTpl()==null){
			dao.fill(person).with(PersonMeta.ATTENDANCE_TPL).execute();
		}


		if(person.getAttendanceTpl()==null){
			AttendanceDataProcess rcd=new AttendanceDataProcess();
			rcd.setPersonId(person.getId());
			rcd.setProcessDate(new Date());
			rcd.setKqRq(date);
			rcd.setNotes("失败,没有配置考勤组。");
			rcd.setStatus(AttendanceRcdProcessStatusEnum.PROCESS_FAILED.code());
			attendanceDataProcessService.insert(rcd,false);
			return ErrorDesc.failureMessage("失败,没有配置考勤组。");
		}

		//离职的，退休的不在跑批
		if(EmployeeStatusEnum.OFFLINE.code().equals(person.getEmployeeStatus())||EmployeeStatusEnum.RETIRED.code().equals(person.getEmployeeStatus())){
			AttendanceDataProcess rcd=new AttendanceDataProcess();
			rcd.setPersonId(person.getId());
			rcd.setProcessDate(new Date());
			rcd.setKqRq(date);
			rcd.setStatus(AttendanceRcdProcessStatusEnum.PROCESS_FAILED.code());
			rcd.setNotes("员工状态离职或退休");
			attendanceDataProcessService.insert(rcd,false);
			return ErrorDesc.failureMessage("失败,没有配置考勤组。");
		}


		AttendanceTpl tpl=person.getAttendanceTpl();
		AttendanceData attendanceData=new AttendanceData();
		attendanceData.setAttendanceDateStr(dateStr);
		attendanceData.setAttendanceDate(date);
		attendanceData.setPersonId(person.getId());
		attendanceData.setAttendanceTplCode(tpl.getCode());
		if(!StringUtil.isBlank(batchCode)){
			attendanceData.setBatchCode(batchCode);
		}

		String week=getWeekByDate(dateStr);
		String tplCode=tpl.getCode();
		String sql= "select \n" +
				"(select statutory_holiday from hr_attendance_date where date_str='2024-02-20' and deleted=0) statutory_holidy,\n" +
				"(select is_work_day from hr_attendance_tpl_dtl b where b.owner_id='default' and week='w1' and b.deleted=0) is_work_day,\n" +
				"(select day_type from hr_attendance_tpl_dtl b where b.owner_id='default' and week='w1' and b.deleted=0) tpl_day_type,\n" +
				"(select str_to_date(concat('2024-02-20 ', date_format(on_work_time,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default')\n" +
				" tpl_on_work_time,\n" +
				"(select str_to_date(concat('2024-02-20 ', date_format(off_work_time,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				") tpl_off_work_time,\n" +
				"\n" +
				"(select count(1) from sys_mapping_owner a,hr_attendance_date b where a.owner_id=b.id and selected_code='default' and a.owner='def' and b.date_str='2024-02-20' and a.deleted=0 and a.deleted=0) force_no_work,\n" +
				"(select count(1) from sys_mapping_owner a,hr_attendance_date b where a.owner_id=b.id and selected_code='default' and a.owner='need' and b.date_str='2024-02-20' and a.deleted=0 and a.deleted=0) force_work,\n" +
				"max(cur_day_min_time) cur_day_min_time,\n" +
				"max(cur_day_max_time) cur_day_max_time,\n" +
				"max(on_work_time) on_work_time,\n" +
				"max(on_work_time_valid) on_work_time_valid,\n" +
				"max(on_work_time_invalid) on_work_time_invalid,\n" +
				"max(off_work_time) off_work_time,\n" +
				"max(off_work_time_valid) off_work_time_valid,\n" +
				"max(off_work_time_invalid) off_work_time_invalid\n" +
				"from ( \n" +
				"select\n" +
				"min(rcd_time) cur_day_min_time,\n" +
				"max(rcd_time) cur_day_max_time,\n" +
				"null on_work_time,\n" +
				"null on_work_time_valid,\n" +
				"null on_work_time_invalid,\n" +
				"null off_work_time,\n" +
				"null off_work_time_valid,\n" +
				"null off_work_time_invalid\n" +
				"from hr_attendance_record where rcd_time>=str_to_date('2024-02-20 00:00:00','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time<=str_to_date('2024-02-20 23:59:59','%Y-%m-%d %H:%i:%s')\n" +
				"and person_id='808426740073365504'\n" +
				"and deleted=0\n" +
				"union all \n" +
				"select \n" +
				"null cur_day_min_time,\n" +
				"null cur_day_max_time,\n" +
				"min(rcd_time) on_work_time,\n" +
				"null on_work_time_valid,\n" +
				"null on_work_time_invalid,\n" +
				"null off_work_time,\n" +
				"null off_work_time_valid,\n" +
				"null off_work_time_invalid\n" +
				"from hr_attendance_record\n" +
				"where rcd_time>=str_to_date('2024-02-20 00:00:00','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time<=str_to_date('2024-02-20 23:59:59','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time>=(select str_to_date(concat('2024-02-20 ', date_format(on_work_time_up,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and rcd_time<=(select str_to_date(concat('2024-02-20 ', date_format(on_work_time_down,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and deleted=0\n" +
				"and person_id='808426740073365504'\n" +
				"union all\n" +
				"select \n" +
				"null cur_day_min_time,\n" +
				"null cur_day_max_time,\n" +
				"null on_work_time,\n" +
				"min(rcd_time)  on_work_time_valid,\n" +
				"null on_work_time_invalid,\n" +
				"null off_work_time,\n" +
				"null off_work_time_valid,\n" +
				"null off_work_time_invalid\n" +
				"from hr_attendance_record\n" +
				"where rcd_time>=str_to_date('2024-02-20 00:00:00','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time<=str_to_date('2024-02-20 23:59:59','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time>=(select str_to_date(concat('2024-02-20 ', date_format(on_work_time_up,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and rcd_time<=(select str_to_date(concat('2024-02-20 ', date_format(on_work_time,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and deleted=0\n" +
				"and person_id='808426740073365504'\n" +
				"union all \n" +
				"select \n" +
				"null cur_day_min_time,\n" +
				"null cur_day_max_time,\n" +
				"null on_work_time,\n" +
				"null on_work_time_valid,\n" +
				"max(rcd_time) on_work_time_invalid,\n" +
				"null off_work_time,\n" +
				"null off_work_time_valid,\n" +
				"null off_work_time_invalid\n" +
				"from hr_attendance_record\n" +
				"where rcd_time>=str_to_date('2024-02-20 00:00:00','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time<=str_to_date('2024-02-20 23:59:59','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time>=(select str_to_date(concat('2024-02-20 ', date_format(on_work_time,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and rcd_time<=(select str_to_date(concat('2024-02-20 ', date_format(on_work_time_down,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and deleted=0\n" +
				"and person_id='808426740073365504'\n" +
				"union all\n" +
				"select \n" +
				"null cur_day_min_time,\n" +
				"null cur_day_max_time,\n" +
				"null on_work_time,\n" +
				"null on_work_time_valid,\n" +
				"null on_work_time_invalid,\n" +
				"max(rcd_time) off_work_time,\n" +
				"null off_work_time_valid,\n" +
				"null off_work_time_invalid\n" +
				"from hr_attendance_record\n" +
				"where rcd_time>=str_to_date('2024-02-20 00:00:00','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time<=str_to_date('2024-02-20 23:59:59','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time>=(select str_to_date(concat('2024-02-20 ', date_format(off_work_time_up,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and rcd_time<=(select str_to_date(concat('2024-02-20 ', date_format(off_work_time_down,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and deleted=0\n" +
				"and person_id='808426740073365504'\n" +
				"union all\n" +
				"select \n" +
				"null cur_day_min_time,\n" +
				"null cur_day_max_time,\n" +
				"null on_work_time,\n" +
				"null on_work_time_valid,\n" +
				"null on_work_time_invalid,\n" +
				"null off_work_time,\n" +
				"max(rcd_time)off_work_time_valid,\n" +
				"null off_work_time_invalid\n" +
				"from hr_attendance_record\n" +
				"where rcd_time>=str_to_date('2024-02-20 00:00:00','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time<=str_to_date('2024-02-20 23:59:59','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time>=(select str_to_date(concat('2024-02-20 ', date_format(off_work_time,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and rcd_time<=(select str_to_date(concat('2024-02-20 ', date_format(off_work_time_down,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and deleted=0\n" +
				"and person_id='808426740073365504'\n" +
				"union all\n" +
				"select \n" +
				"null cur_day_min_time,\n" +
				"null cur_day_max_time,\n" +
				"null on_work_time,\n" +
				"null on_work_time_valid,\n" +
				"null on_work_time_invalid,\n" +
				"null off_work_time,\n" +
				"null off_work_time_valid,\n" +
				"max(rcd_time)  off_work_time_invalid\n" +
				"from hr_attendance_record\n" +
				"where rcd_time>=str_to_date('2024-02-20 00:00:00','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time<=str_to_date('2024-02-20 23:59:59','%Y-%m-%d %H:%i:%s')\n" +
				"and rcd_time>=(select str_to_date(concat('2024-02-20 ', date_format(off_work_time_up,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and rcd_time<=(select str_to_date(concat('2024-02-20 ', date_format(off_work_time,'%H:%i:%s')),'%Y-%m-%d %H:%i:%s') \n" +
				"from hr_attendance_tpl_group a,hr_attendance_tpl_dtl b where a.id=b.first_work and b.deleted=0 and b.week='w1' and b.owner_id='default'\n" +
				")\n" +
				"and deleted=0\n" +
				"and person_id='808426740073365504'\n" +
				")end ";

		sql=sql.replaceAll("2024-02-20",dateStr).replaceAll("w1",week).replaceAll("default",tplCode).replaceAll("808426740073365504",person.getId());
		Rcd rs=dao.queryRecord(sql);

		//不用上班：考勤组在不用上班组里。
		//需要上班，法定假🌞，在需要上班组
		String statutory_holidy=rs.getString("statutory_holidy");
		String is_work_day=rs.getString("is_work_day");
		String force_no_work=rs.getInteger("force_no_work")>0?"yes":"no";
		String force_work=rs.getInteger("force_work")>0?"yes":"no";
		String isWork="";
		if("yes".equals(is_work_day)){
			isWork=YesNoEnum.YES.code();
		}else{
			isWork=YesNoEnum.no.code();
		}
		if("yes".equals(statutory_holidy)){
			//法定假如不需要上班
			isWork=YesNoEnum.no.code();
			//如果需要上班
			if("yes".equals(force_work)){
				isWork=YesNoEnum.YES.code();
			}
		}else{
			//不是法定假日
			if("yes".equals(force_work)){
				isWork=YesNoEnum.YES.code();
			}
			if("yes".equals(force_no_work)){
				isWork=YesNoEnum.no.code();
			}
		}
		String workDayType=rs.getString("tpl_day_type");
		Double normalDay=1.0;
		Double needDay=1.0;
		if("yes".equals(isWork)){
			if(AttendanceTplDayTypeEnum.DAY_FULL.code().equals(workDayType)){
				normalDay=1.0;
				needDay=1.0;
			}else if(AttendanceTplDayTypeEnum.DAY_HALF.code().equals(workDayType)){
				normalDay=0.5;
				needDay=0.5;
			}
		}else{
			normalDay=0.0;
			needDay=0.0;
		}

		//当天最早打卡，最晚打卡
		Date cur_day_min_time=rs.getDate("cur_day_min_time");
		Date cur_day_max_time=rs.getDate("cur_day_max_time");

		Date tpl_on_work_time=rs.getDate("tpl_on_work_time");
		Date tpl_off_work_time=rs.getDate("tpl_off_work_time");

		//上班时间段打卡
		Date on_work_time=rs.getDate("on_work_time");
		//有效打卡
		Date on_work_time_valid=rs.getDate("on_work_time_valid");
		//无效打卡
		Date on_work_time_invalid=rs.getDate("on_work_time_invalid");
		//下班时间段打卡
		//时间端内打卡
		Date off_work_time=rs.getDate("off_work_time");
		//有效打卡
		Date off_work_time_valid=rs.getDate("off_work_time_valid");
		//无效打卡
		Date off_work_time_invalid=rs.getDate("off_work_time_invalid");
		//写入是否需要工作
		//迟到计算,打过卡，要求的打卡时间中
		int leave_early=0;
		double leave_early_time=0;
		if(on_work_time_valid==null&&on_work_time!=null){
			long diffInMillis = Math.abs(tpl_on_work_time.getTime() - on_work_time_invalid.getTime()); // 计算两个日期之间的毫秒差值
			leave_early_time = (double)diffInMillis / (1000 * 60); // 将毫秒差值转换成分钟
			leave_early=1;
		}
		//早退计算
		int leave_late=0;
		double leave_late_time=0;
		if(off_work_time_valid==null&&off_work_time!=null){
			leave_late=1;
			long diffInMillis = Math.abs(tpl_off_work_time.getTime() - off_work_time_invalid.getTime()); // 计算两个日期之间的毫秒差值
			leave_late_time = (double)diffInMillis / (1000 * 60); // 将毫秒差值转换成分钟
		}
		//缺卡计算,在上班和下班给给定时间端内未打卡
		int lossEarly=0;

		if(on_work_time==null){
			lossEarly=1;
		}
		int lossLate=0;
		if(off_work_time==null){
			lossLate=1;
		}


		String res="";
		if(YesNoEnum.YES.code().equals(isWork)){
			if (lossEarly==1&&lossLate==1){
				res=res+" 旷工";
				normalDay=0.0;
			}else if(lossEarly==1&&lossLate==0){
				res=res+" 上班未打卡";
				normalDay=normalDay/2;
			}else if(lossEarly==0&&lossLate==1){
				res=res+" 下班未打卡";
				normalDay=normalDay/2;
			}
			if(leave_early==1){
				res=res+" 迟到";
			}
			if(leave_late==1){
				res=res+" 早退";
			}
			if (lossEarly==0&&lossLate==0&&leave_early==0&&leave_early==0){
				res="正常";
			}
		}else{
			res="休息日";
			normalDay=0.0;
			needDay=0.0;
		}


		//考勤信息
		attendanceData.setNeedDay(new BigDecimal(needDay));
		attendanceData.setNormalDay(new BigDecimal(normalDay));

		attendanceData.setIsWorkDay(isWork);
		attendanceData.setOnWorkTime(on_work_time);
		attendanceData.setOffWorkTime(off_work_time);
		attendanceData.setOnWorkTime2(cur_day_min_time);
		attendanceData.setOffWorkTime2(cur_day_max_time);
		attendanceData.setLossEarly(lossEarly);
		attendanceData.setLossLate(lossLate);
		attendanceData.setLeaveEarly(leave_early);
		attendanceData.setLeaveEarlyTime(new BigDecimal(leave_early_time));
		attendanceData.setLeaveLate(leave_late);
		attendanceData.setLeaveLateTime(new BigDecimal(leave_late_time));
		attendanceData.setResult(res);
		//更新考勤数据
		attendanceData.setRcdTime(new Date());
		Rcd kqRs=dao.queryRecord("select id from hr_attendance_data where person_id=? and attendance_date_str=?",person.getId(),dateStr);
		if(kqRs!=null){
			dao.execute("delete from hr_attendance_data where id=?",kqRs.getString("id"));
		}
		attendanceDataService.insert(attendanceData,false);
//		if(kqRs==null){
//			attendanceDataService.insert(attendanceData,false);
//		}else{
//			attendanceData.setId(kqRs.getString("id"));
//			attendanceDataService.update(attendanceData,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
//		}
		return ErrorDesc.success();
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param attendanceData 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AttendanceData attendanceData) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(attendanceData, SYS_ROLE.NAME);
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