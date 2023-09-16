package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.oa.CustomerLockStatusEnum;
import com.dt.platform.constants.enums.oa.CustomerRolePosEnum;
import com.dt.platform.constants.enums.oa.CustomerTeamUserRoleEnum;
import com.dt.platform.constants.enums.oa.TransactionStatusEnum;
import com.dt.platform.domain.oa.*;
import com.dt.platform.oa.service.ICrmCustomerCareService;
import com.dt.platform.oa.service.ICrmCustomerRecordService;
import com.dt.platform.oa.service.ICrmCustomerTeamService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


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
import com.dt.platform.oa.service.ICrmCustomerService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 客户服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:49
*/


@Service("OaCrmCustomerService")

public class CrmCustomerServiceImpl extends SuperService<CrmCustomer> implements ICrmCustomerService {


	@Autowired
	private ICrmCustomerRecordService crmCustomerRecordService;

	@Autowired
	private ICrmCustomerTeamService crmCustomerTeamService;

	@Autowired
	private ICrmCustomerCareService crmCustomerCareService;

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
	 * @param crmCustomer  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CrmCustomer crmCustomer,boolean throwsException) {

		if(StringUtil.isBlank(crmCustomer.getOriginatorId())){
			crmCustomer.setOriginatorId(SessionUser.getCurrent().getActivatedEmployeeId());
		}


		if(StringUtil.isBlank(crmCustomer.getLocked())){
			crmCustomer.setLocked(CustomerLockStatusEnum.UNLOCK.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(crmCustomer.getCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(CodeModuleEnum.OA_CRM_CUSTOMER.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				crmCustomer.setCode(codeResult.getData().toString());
			}
		}

		if(StringUtil.isBlank(crmCustomer.getTransactionStatus())){
			crmCustomer.setTransactionStatus(TransactionStatusEnum.NOT_DEAL.code());
		}

		String role=crmCustomer.getRolePos();
		if(StringUtil.isBlank(role)){
			crmCustomer.setRolePos(role);
		}else{
			if(CustomerRolePosEnum.INVALID.code().equals(role)
					|| CustomerRolePosEnum.OPEN_SEA.code().equals(role) ){
				crmCustomer.setRolePos(role);
			}else if(CustomerRolePosEnum.COLLECTED.code().equals(role)){
				crmCustomer.setRolePos(role);
				crmCustomer.setOwnerId(SessionUser.getCurrent().getActivatedEmployeeId());
			}else{
				crmCustomer.setRolePos(CustomerRolePosEnum.OPEN_SEA.code());
			}
		}


		Result r=super.insert(crmCustomer,throwsException);
		return r;
	}

	@Override
	public Result care(String customerId) {
		String userId=SessionUser.getCurrent().getActivatedEmployeeId();
		CrmCustomerCareVO careQuery=new CrmCustomerCareVO();
		careQuery.setCustomerId(customerId);
		careQuery.setUserId(userId);
		List<CrmCustomerCare> list=crmCustomerCareService.queryList(careQuery);
		if(list.size()==0){
			CrmCustomerCare care=new CrmCustomerCare();
			care.setCustomerId(customerId);
			care.setUserId(userId);
			crmCustomerCareService.insert(care,false);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result careCancel(String customerId) {
		String userId=SessionUser.getCurrent().getActivatedEmployeeId();
		CrmCustomerCareVO careQuery=new CrmCustomerCareVO();
		careQuery.setCustomerId(customerId);
		careQuery.setUserId(userId);
		List<CrmCustomerCare> list=crmCustomerCareService.queryList(careQuery);
		if(list.size()>0){
			crmCustomerCareService.deleteByIdLogical(list.get(0).getId());
		}
		return ErrorDesc.success();
	}

	@Override
	public Result unlock(String customerId) {

		dao.execute("update oa_crm_customer set locked=? where id=?",CustomerLockStatusEnum.UNLOCK.code(),customerId);
		CrmCustomerRecord rcd=new CrmCustomerRecord();
		rcd.setCustomerId(customerId);
		rcd.setRcdTime(new Date());
		rcd.setOriginatorId(SessionUser.getCurrent().getActivatedEmployeeId());
		rcd.setContent("客户解锁");
		crmCustomerRecordService.insert(rcd,false);
		return ErrorDesc.success();
	}

	@Override
	public Result lock(String customerId) {

		dao.execute("update oa_crm_customer set locked=? where id=?",CustomerLockStatusEnum.LOCKED.code(),customerId);
		CrmCustomerRecord rcd=new CrmCustomerRecord();
		rcd.setCustomerId(customerId);
		rcd.setRcdTime(new Date());
		rcd.setOriginatorId(SessionUser.getCurrent().getActivatedEmployeeId());
		rcd.setContent("客户被锁定");
		crmCustomerRecordService.insert(rcd,false);

		return ErrorDesc.success();
	}

	@Override
	public Result deal(String customerId) {

		CrmCustomer customer=this.getById(customerId);
		if(TransactionStatusEnum.DEAL.code().equals(customer.getTransactionStatus())){
			return ErrorDesc.failureMessage("当前状态为已成交，不需要修改");
		}
		dao.execute("update oa_crm_customer set transaction_status=? where id=?", TransactionStatusEnum.DEAL.code(),customerId);
		CrmCustomerRecord rcd=new CrmCustomerRecord();
		rcd.setCustomerId(customerId);
		rcd.setRcdTime(new Date());
		rcd.setOriginatorId(SessionUser.getCurrent().getActivatedEmployeeId());
		rcd.setContent("客户状态修改为成交");
		crmCustomerRecordService.insert(rcd,false);
		return ErrorDesc.success();
	}

	@Override
	public Result toValid(String customerId) {
		CrmCustomer crmCustomer=this.getById(customerId);
		if(TransactionStatusEnum.DEAL.code().equals(crmCustomer.getTransactionStatus())){
			return ErrorDesc.failureMessage("当前状态为已成交，不能进行操作");
		}
		if(CustomerLockStatusEnum.LOCKED.code().equals(crmCustomer.getLocked())){
			return ErrorDesc.failureMessage("当前客户锁定，不能进行操作");
		}

		crmCustomer.setRolePos(CustomerRolePosEnum.INVALID.code());
		crmCustomer.setOwnerId("");
		Result r=super.update(crmCustomer,SaveMode.NOT_NULL_FIELDS,true);
		if(r.isSuccess()){
			CrmCustomerRecord rcd=new CrmCustomerRecord();
			rcd.setCustomerId(customerId);
			rcd.setRcdTime(new Date());
			rcd.setOriginatorId(SessionUser.getCurrent().getActivatedEmployeeId());
			rcd.setContent("移入无效客户区域");
			crmCustomerRecordService.insert(rcd,false);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result toOpenSea(String customerId) {
		CrmCustomer crmCustomer= this.getById(customerId);
		if(TransactionStatusEnum.DEAL.code().equals(crmCustomer.getTransactionStatus())){
			return ErrorDesc.failureMessage("当前状态为已成交，不能进行操作");
		}
		if(CustomerLockStatusEnum.LOCKED.code().equals(crmCustomer.getLocked())){
			return ErrorDesc.failureMessage("当前客户锁定，不能进行操作");
		}

		crmCustomer.setRolePos(CustomerRolePosEnum.OPEN_SEA.code());
		crmCustomer.setOwnerId("");
		Result r=super.update(crmCustomer,SaveMode.NOT_NULL_FIELDS,true);
		if(r.isSuccess()){
			CrmCustomerRecord rcd=new CrmCustomerRecord();
			rcd.setCustomerId(customerId);
			rcd.setRcdTime(new Date());
			rcd.setOriginatorId(SessionUser.getCurrent().getActivatedEmployeeId());
			rcd.setContent("移入公海客户区");
			crmCustomerRecordService.insert(rcd,false);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result collect(String customerId) {
		CrmCustomer crmCustomer= this.getById(customerId);
		if(TransactionStatusEnum.DEAL.code().equals(crmCustomer.getTransactionStatus())){
			return ErrorDesc.failureMessage("当前状态为已成交，不能进行操作");
		}
		if(CustomerRolePosEnum.COLLECTED.code().equals(crmCustomer.getRolePos())){
			return ErrorDesc.failureMessage("当前客户已被领用，不能进行操作");
		}

		crmCustomer.setRolePos(CustomerRolePosEnum.COLLECTED.code());
		crmCustomer.setOwnerId(SessionUser.getCurrent().getActivatedEmployeeId());
		Result r=super.update(crmCustomer,SaveMode.NOT_NULL_FIELDS,true);
		if(r.isSuccess()){
			CrmCustomerRecord rcd=new CrmCustomerRecord();
			rcd.setCustomerId(customerId);
			rcd.setRcdTime(new Date());
			rcd.setOriginatorId(SessionUser.getCurrent().getActivatedEmployeeId());
			rcd.setContent("客户被领用,领用人:"+SessionUser.getCurrent().getRealName());
			crmCustomerRecordService.insert(rcd,false);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result allocate(String customerId, String userId) {
		Result res=new Result();
		res.success(true);
		String msg="操作成功!";
		if(StringUtil.isBlank(userId)){
			return ErrorDesc.failureMessage("未选择用户");
		}
		Rcd rs=dao.queryRecord("select p.name from hrm_employee e,hrm_person p where e.person_id=p.id and e.id=?",userId);
		if(rs==null){
			return ErrorDesc.failureMessage("所选用户不存在");
		}
		//检查是否可以被分配
		CrmCustomer customer=this.getById(customerId);
		if(CustomerRolePosEnum.COLLECTED.code().equals(customer.getRolePos())){
			res.success(false);
			msg="已被领用";
			res.data(customer);
		}

		dao.execute("update oa_crm_customer set owner_id=?,role_pos=? where id=?", userId,CustomerRolePosEnum.COLLECTED.code(),customerId);
		CrmCustomerRecord rcd=new CrmCustomerRecord();
		rcd.setCustomerId(customerId);
		rcd.setOriginatorId(userId);
		rcd.setRcdTime(new Date());
		rcd.setContent("本客户分配给"+rs.getString("name"));
		crmCustomerRecordService.insert(rcd,false);

		res.message(msg);
		return res;
	}

	@Override
	public Result batchAllocate(String customerIds, String userId) {
		JSONArray customerIdsArr=JSONArray.parseArray(customerIds);
		if(customerIdsArr==null||customerIdsArr.size()==0){
			return ErrorDesc.failureMessage("未选择客户");
		}
		if(StringUtil.isBlank(userId)){
			return ErrorDesc.failureMessage("未选择用户");
		}
		Rcd rs=dao.queryRecord("select p.name from hrm_employee e,hrm_person p where e.person_id=p.id where e.id=?",userId);
		if(rs==null){
			return ErrorDesc.failureMessage("所选择用户不存在");
		}
		for(int i=0;i<customerIdsArr.size();i++){
			String customerId=customerIdsArr.getString(i);
			allocate(customerId,userId);
		}
		return ErrorDesc.success();
	}


	//共享
	@Override
	public Result addUsers(String customerId, String userIds) {

		String[] userIdsArr=userIds.split(",");
		if(userIdsArr==null||userIdsArr.length==0){
			return ErrorDesc.failureMessage("未选择用户");
		}
		if(StringUtil.isBlank(customerId)){
			return ErrorDesc.failureMessage("未选择客户");
		}
		for(int i=0;i<userIdsArr.length;i++){
			String userId=userIdsArr[i];
			if(dao.queryRecord("select 1 from oa_crm_customer_team where customer_id=? and user_id=?",customerId,userId)==null){
				Rcd rs=dao.queryRecord("select p.name from hrm_employee e,hrm_person p where e.person_id=p.id and e.id=?",userId);
				if(rs!=null){
					CrmCustomerTeam teamUser=new CrmCustomerTeam();
					teamUser.setCustomerId(customerId);
					teamUser.setUserId(userId);
					teamUser.setUserRole(CustomerTeamUserRoleEnum.MEMBER.code());
					crmCustomerTeamService.insert(teamUser,false);

					CrmCustomerRecord rcd=new CrmCustomerRecord();
					rcd.setCustomerId(customerId);
					rcd.setOriginatorId(userId);
					rcd.setRcdTime(new Date());
					rcd.setContent("本客户添加共享成员，"+rs.getString("name"));
					crmCustomerRecordService.insert(rcd,false);

				}
			}
		}
		return ErrorDesc.success();
	}

	@Override
	public Result transfer(String customerId,String userId) {
		CrmCustomer crmCustomer= this.getById(customerId);
		if(CustomerRolePosEnum.OPEN_SEA.code().equals(crmCustomer.getRolePos())
				||CustomerRolePosEnum.INVALID.code().equals(crmCustomer.getRolePos())){
			return ErrorDesc.failureMessage("当前客户未被领用，不能进行操作");
		}

		Rcd rs=dao.queryRecord("select p.name from hrm_employee e,hrm_person p where e.person_id=p.id where e.id=?",userId);
		if(rs==null){
			return ErrorDesc.failureMessage("所选择用户不存在");
		}
		dao.execute("update oa_crm_customer set owner_id=? where id=?", customerId,userId);
		CrmCustomerRecord rcd=new CrmCustomerRecord();
		rcd.setCustomerId(customerId);
		rcd.setOriginatorId(userId);
		rcd.setContent("本客户已转移至"+rs.getString("name"));
		crmCustomerRecordService.insert(rcd,false);
		return ErrorDesc.success();
	}

	@Override
	public Result batchTransfer(String customerIds, String userId) {
		JSONArray customerIdsArr=JSONArray.parseArray(customerIds);
		if(customerIdsArr==null||customerIdsArr.size()==0){
			return ErrorDesc.failureMessage("未选择客户");
		}
		if(StringUtil.isBlank(userId)){
			return ErrorDesc.failureMessage("未选择用户");
		}
		Rcd rs=dao.queryRecord("select p.name from hrm_employee e,hrm_person p where e.person_id=p.id where e.id=?",userId);
		if(rs==null){
			return ErrorDesc.failureMessage("所选择用户不存在");
		}
		for(int i=0;i<customerIdsArr.size();i++){
			String customerId=customerIdsArr.getString(i);
			transfer(customerId,userId);
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param crmCustomer 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CrmCustomer crmCustomer) {
		return this.insert(crmCustomer,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param crmCustomerList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CrmCustomer> crmCustomerList) {
		return super.insertList(crmCustomerList);
	}

	/**
	 * 按主键删除客户
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CrmCustomer crmCustomer = new CrmCustomer();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		crmCustomer.setId(id);
		try {
			boolean suc = dao.deleteEntity(crmCustomer);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除客户
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CrmCustomer crmCustomer = new CrmCustomer();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		crmCustomer.setId(id);
		crmCustomer.setDeleted(true);
		crmCustomer.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		crmCustomer.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(crmCustomer,SaveMode.NOT_NULL_FIELDS);
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
	 * @param crmCustomer 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CrmCustomer crmCustomer , SaveMode mode) {
		return this.update(crmCustomer,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param crmCustomer 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CrmCustomer crmCustomer , SaveMode mode,boolean throwsException) {
		Result r=super.update(crmCustomer , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param crmCustomerList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CrmCustomer> crmCustomerList , SaveMode mode) {
		return super.updateList(crmCustomerList , mode);
	}

	
	/**
	 * 按主键更新客户
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
	 * 按主键获取客户
	 *
	 * @param id 主键
	 * @return CrmCustomer 数据对象
	 */
	public CrmCustomer getById(String id) {
		CrmCustomer sample = new CrmCustomer();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<CrmCustomer> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<CrmCustomer> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, CrmCustomer> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, CrmCustomer::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CrmCustomer> queryList(CrmCustomerVO sample) {
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
	public PagedList<CrmCustomer> queryPagedList(CrmCustomerVO sample, int pageSize, int pageIndex) {

		String searchType=sample.getSearchCustomerType();
		ConditionExpr expr=new ConditionExpr();
		if("myCustomer".equals(searchType)){
			expr.and("owner_id=?",SessionUser.getCurrent().getActivatedEmployeeId());
		}else if( "mySubordinates".equals(searchType)){
			expr.and("owner_id=?",SessionUser.getCurrent().getActivatedEmployeeId());
		}else if( "shareToMe".equals(searchType)){
			expr.and("id in (select customer_id from oa_crm_customer_team where user_id=? and deleted=0)",SessionUser.getCurrent().getActivatedEmployeeId());
		}else if( "myCare".equals(searchType)){
			expr.and("id in (select customer_id from oa_crm_customer_care where user_id=? and deleted=0)",SessionUser.getCurrent().getActivatedEmployeeId());
		}
		return super.queryPagedList(sample,expr, pageSize, pageIndex);
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
	public PagedList<CrmCustomer> queryPagedList(CrmCustomer sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param crmCustomer 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CrmCustomer crmCustomer) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(crmCustomer, SYS_ROLE.NAME);
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