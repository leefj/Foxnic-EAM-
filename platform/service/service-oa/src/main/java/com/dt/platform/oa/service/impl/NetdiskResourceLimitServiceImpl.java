package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;

import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.text.DecimalFormat;

import com.dt.platform.domain.oa.NetdiskResourceLimit;
import com.dt.platform.domain.oa.NetdiskResourceLimitVO;
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
import com.dt.platform.oa.service.INetdiskResourceLimitService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 资源限制服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-27 15:59:06
*/


@Service("OaNetdiskResourceLimitService")

public class NetdiskResourceLimitServiceImpl extends SuperService<NetdiskResourceLimit> implements INetdiskResourceLimitService {

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
	 * @param netdiskResourceLimit  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(NetdiskResourceLimit netdiskResourceLimit,boolean throwsException) {
		Result r=super.insert(netdiskResourceLimit,throwsException);
		return r;
	}

	private void formatSize(NetdiskResourceLimit netdiskResourceLimit){

		DecimalFormat format= new DecimalFormat("#.00");
		if(netdiskResourceLimit.getCapacitySizeM()<1024L){
			netdiskResourceLimit.setCapacitySizeValue(netdiskResourceLimit.getCapacitySizeM()+"M");
		}else if(netdiskResourceLimit.getCapacitySizeM()>=1024L&&netdiskResourceLimit.getCapacitySizeM()<1024L*1024L){
			Double d=(double)netdiskResourceLimit.getCapacitySizeM()/1024L;
			netdiskResourceLimit.setCapacitySizeValue(format.format(d)+"G");
		}else{
			Double d=(double)netdiskResourceLimit.getCapacitySizeM()/(1024L*1024L);
			netdiskResourceLimit.setCapacitySizeValue(format.format(d)+"T");
		}
		Long curSize=netdiskResourceLimit.getCurrentSizeB()==null?0:netdiskResourceLimit.getCurrentSizeB();
		String curSizeVale="";
		if(curSize<1024L){
			curSizeVale=curSize+"B";
		}else if(curSize>=1024L&&curSize<1024L*1024L){
			Double d=(curSize/(double)1024);
			curSizeVale=format.format(d)+"KB";
		}else if(curSize>=1024L*1024L&&curSize<1024L*1024L*1024L){
			Double d=curSize/((double)(1024*1024));
			curSizeVale=format.format(d)+"M";
		}else if(curSize>=1024L*1024L*1024L&&curSize<1024L*1024L*1024L*1024L){
			Double d=curSize/((double)(1024/1024/1024));
			curSizeVale=format.format(d)+"G";
		}else{
			Double d=curSize/((double)(1024*1024*1024));
			curSizeVale=format.format(d)+"G";
		}
		netdiskResourceLimit.setCurrentSizeValue(curSizeVale);
	}

	@Override
	public Result recalculate() {
		Result<List<Employee>> res=EmployeeServiceProxy.api().queryList(new EmployeeVO());
		if(res.isSuccess()){
			List<Employee> list=res.getData();
			for(int i=0;i<list.size();i++){
				String userId=list.get(i).getId();
				getByUserId(userId);
				dao.execute("update oa_netdisk_resource_limit set current_size_b=(select case when sum(a.file_size) is null then 0 else sum(a.file_size) end value from oa_netdisk_origin_file a,oa_netdisk_file b where a.id=b.origin_file_id and b.deleted=0 and b.user_id=?) where user_id=?",userId,userId);
			}
		}
		return ErrorDesc.success();
	}

	@Override
	public NetdiskResourceLimit getByUserId(String id) {
		NetdiskResourceLimit q=new NetdiskResourceLimit();
		q.setUserId(id);
		NetdiskResourceLimit netdiskResourceLimit=this.queryEntity(q);
		if(netdiskResourceLimit==null){
			//将默认的插入
			NetdiskResourceLimit q2=new NetdiskResourceLimit();
			q2.setUserId("default");
			NetdiskResourceLimit netdiskResourceLimit2=this.queryEntity(q2);
			netdiskResourceLimit2.setUserId(id);
			netdiskResourceLimit2.setId(null);
			netdiskResourceLimit2.setCurrentSizeB(0L);
			this.insert(netdiskResourceLimit2,false);

			formatSize(netdiskResourceLimit2);
			return netdiskResourceLimit2;
		}
		formatSize(netdiskResourceLimit);
		return netdiskResourceLimit;
	}

	@Override
	public NetdiskResourceLimit getMyResource() {
		return getByUserId(SessionUser.getCurrent().getActivatedEmployeeId());
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param netdiskResourceLimit 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(NetdiskResourceLimit netdiskResourceLimit) {
		return this.insert(netdiskResourceLimit,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param netdiskResourceLimitList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<NetdiskResourceLimit> netdiskResourceLimitList) {
		return super.insertList(netdiskResourceLimitList);
	}

	
	/**
	 * 按主键删除资源限制
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		NetdiskResourceLimit netdiskResourceLimit = new NetdiskResourceLimit();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskResourceLimit.setId(id);
		try {
			boolean suc = dao.deleteEntity(netdiskResourceLimit);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除资源限制
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		NetdiskResourceLimit netdiskResourceLimit = new NetdiskResourceLimit();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskResourceLimit.setId(id);
		netdiskResourceLimit.setDeleted(true);
		netdiskResourceLimit.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		netdiskResourceLimit.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(netdiskResourceLimit,SaveMode.NOT_NULL_FIELDS);
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
	 * @param netdiskResourceLimit 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskResourceLimit netdiskResourceLimit , SaveMode mode) {
		return this.update(netdiskResourceLimit,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param netdiskResourceLimit 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskResourceLimit netdiskResourceLimit , SaveMode mode,boolean throwsException) {
		Result r=super.update(netdiskResourceLimit , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param netdiskResourceLimitList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<NetdiskResourceLimit> netdiskResourceLimitList , SaveMode mode) {
		return super.updateList(netdiskResourceLimitList , mode);
	}

	
	/**
	 * 按主键更新资源限制
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
	 * 按主键获取资源限制
	 *
	 * @param id 主键
	 * @return NetdiskResourceLimit 数据对象
	 */
	public NetdiskResourceLimit getById(String id) {
		NetdiskResourceLimit sample = new NetdiskResourceLimit();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<NetdiskResourceLimit> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<NetdiskResourceLimit> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, NetdiskResourceLimit> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, NetdiskResourceLimit::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<NetdiskResourceLimit> queryList(NetdiskResourceLimitVO sample) {
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
	public PagedList<NetdiskResourceLimit> queryPagedList(NetdiskResourceLimitVO sample, int pageSize, int pageIndex) {
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
	public PagedList<NetdiskResourceLimit> queryPagedList(NetdiskResourceLimit sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param netdiskResourceLimit 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(NetdiskResourceLimit netdiskResourceLimit) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(netdiskResourceLimit, SYS_ROLE.NAME);
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