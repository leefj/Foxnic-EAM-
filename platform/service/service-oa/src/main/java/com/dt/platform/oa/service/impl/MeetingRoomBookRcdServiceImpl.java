package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.oa.MeetingRoomBookStatusEnum;
import com.dt.platform.constants.enums.oa.MeetingRoomStatusEnum;
import com.dt.platform.domain.oa.meta.MeetingRoomBookRcdMeta;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.RcdSet;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;


import com.dt.platform.domain.oa.MeetingRoomBookRcd;
import com.dt.platform.domain.oa.MeetingRoomBookRcdVO;
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
import com.dt.platform.oa.service.IMeetingRoomBookRcdService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 会议室预定服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 21:40:41
*/


@Service("OaMeetingRoomBookRcdService")

public class MeetingRoomBookRcdServiceImpl extends SuperService<MeetingRoomBookRcd> implements IMeetingRoomBookRcdService {

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
	 * @param meetingRoomBookRcd  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MeetingRoomBookRcd meetingRoomBookRcd,boolean throwsException) {
		meetingRoomBookRcd.setStatus(MeetingRoomBookStatusEnum.APPLY.code());
		meetingRoomBookRcd.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		Result r=super.insert(meetingRoomBookRcd,throwsException);
		return r;
	}

	@Override
	public Result<JSONArray> queryData(String roomId, String startStr, String endStr) {
		Result<JSONArray> res=new Result<>();
		ConditionExpr expr=new ConditionExpr();
		JSONArray data=new JSONArray();
		if(!StringUtil.isBlank(startStr)){
			expr.and(" start_time>=date_format('"+startStr+"','%Y-%m-%d %H:%i:%s')");
		}
		if(!StringUtil.isBlank(endStr)){
			expr.and(" start_time<=date_format('"+endStr+"','%Y-%m-%d %H:%i:%s')");
		}
		if(!StringUtil.isBlank(roomId)){
			expr.and(" room_id=?",roomId);
		}
		List<MeetingRoomBookRcd> rcdList=this.queryList(expr);
		dao.fill(rcdList).with(MeetingRoomBookRcdMeta.MEETING_ROOM).execute();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<rcdList.size();i++){
			JSONObject obj=new JSONObject();
			MeetingRoomBookRcd rcd=rcdList.get(i);
			String roomName=rcd.getMeetingRoom()==null?"Unknow":rcd.getMeetingRoom().getName();
			String statusName="未知";
			if(MeetingRoomBookStatusEnum.APPLY.code().equals(rcd.getStatus())){
				statusName=MeetingRoomBookStatusEnum.APPLY.text();
			}else if(MeetingRoomBookStatusEnum.BOOKED.code().equals(rcd.getStatus())){
				statusName=MeetingRoomBookStatusEnum.BOOKED.text();
			}else if(MeetingRoomBookStatusEnum.FINISH.code().equals(rcd.getStatus())){
				statusName=MeetingRoomBookStatusEnum.FINISH.text();
			}else if(MeetingRoomBookStatusEnum.CANCEL.code().equals(rcd.getStatus())){
				statusName=MeetingRoomBookStatusEnum.CANCEL.text();
			}
			obj.put("title","会议室:"+roomName+","+statusName);
			obj.put("start",sdf.format(rcd.getStartTime()));
			obj.put("end",sdf.format(rcd.getEndTime()));
			data.add(obj);
		}
		res.data(data);
		res.success(true);
		return res;
	}

	@Override
	public Result sure(String id) {
		MeetingRoomBookRcd data=this.getById(id);
		if(MeetingRoomBookStatusEnum.APPLY.code().equals(data.getStatus())){
			dao.execute("update oa_meeting_room_book_rcd set status=? where id=?",MeetingRoomBookStatusEnum.APPLY.code(),id);
		}else{
			return ErrorDesc.failureMessage("当前会议室状态无法进行该操作");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result cancel(String id) {
		MeetingRoomBookRcd data=this.getById(id);
		if(MeetingRoomBookStatusEnum.APPLY.code().equals(data.getStatus()) ||MeetingRoomBookStatusEnum.BOOKED.code().equals(data.getStatus()) ){
			dao.execute("update oa_meeting_room_book_rcd set status=? where id=?",MeetingRoomBookStatusEnum.CANCEL.code(),id);
		}else{
			return ErrorDesc.failureMessage("当前会议室状态无法进行该操作");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result finish(String id) {
		MeetingRoomBookRcd data=this.getById(id);
		if(MeetingRoomBookStatusEnum.BOOKED.code().equals(data.getStatus())){
			dao.execute("update oa_meeting_room_book_rcd set status=? where id=?",MeetingRoomBookStatusEnum.FINISH.code(),id);
		}else{
			return ErrorDesc.failureMessage("当前会议室状态无法进行该操作");
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param meetingRoomBookRcd 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MeetingRoomBookRcd meetingRoomBookRcd) {
		return this.insert(meetingRoomBookRcd,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param meetingRoomBookRcdList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MeetingRoomBookRcd> meetingRoomBookRcdList) {
		return super.insertList(meetingRoomBookRcdList);
	}

	
	/**
	 * 按主键删除会议室预定
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MeetingRoomBookRcd meetingRoomBookRcd = new MeetingRoomBookRcd();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		meetingRoomBookRcd.setId(id);
		try {
			boolean suc = dao.deleteEntity(meetingRoomBookRcd);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除会议室预定
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MeetingRoomBookRcd meetingRoomBookRcd = new MeetingRoomBookRcd();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		meetingRoomBookRcd.setId(id);
		meetingRoomBookRcd.setDeleted(true);
		meetingRoomBookRcd.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		meetingRoomBookRcd.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(meetingRoomBookRcd,SaveMode.NOT_NULL_FIELDS);
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
	 * @param meetingRoomBookRcd 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MeetingRoomBookRcd meetingRoomBookRcd , SaveMode mode) {
		return this.update(meetingRoomBookRcd,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param meetingRoomBookRcd 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MeetingRoomBookRcd meetingRoomBookRcd , SaveMode mode,boolean throwsException) {
		Result r=super.update(meetingRoomBookRcd , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param meetingRoomBookRcdList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MeetingRoomBookRcd> meetingRoomBookRcdList , SaveMode mode) {
		return super.updateList(meetingRoomBookRcdList , mode);
	}

	
	/**
	 * 按主键更新会议室预定
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
	 * 按主键获取会议室预定
	 *
	 * @param id 主键
	 * @return MeetingRoomBookRcd 数据对象
	 */
	public MeetingRoomBookRcd getById(String id) {
		MeetingRoomBookRcd sample = new MeetingRoomBookRcd();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<MeetingRoomBookRcd> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<MeetingRoomBookRcd> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MeetingRoomBookRcd> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MeetingRoomBookRcd::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MeetingRoomBookRcd> queryList(MeetingRoomBookRcdVO sample) {
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
	public PagedList<MeetingRoomBookRcd> queryPagedList(MeetingRoomBookRcdVO sample, int pageSize, int pageIndex) {
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
	public PagedList<MeetingRoomBookRcd> queryPagedList(MeetingRoomBookRcd sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param meetingRoomBookRcd 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MeetingRoomBookRcd meetingRoomBookRcd) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(meetingRoomBookRcd, SYS_ROLE.NAME);
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