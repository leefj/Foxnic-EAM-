package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.hr.ApprovalResultStatusEnum;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.hr.service.IPersonService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.hr.PersonCertificate;
import com.dt.platform.domain.hr.PersonCertificateVO;
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
import com.dt.platform.hr.service.IPersonCertificateService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 证书信息服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 17:07:10
*/


@Service("HrPersonCertificateService")

public class PersonCertificateServiceImpl extends SuperService<PersonCertificate> implements IPersonCertificateService {

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
	private IPersonService personService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param personCertificate  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(PersonCertificate personCertificate,boolean throwsException) {


		if("0".equals(personService.queryOperParameterValue("hr.personCertificate"))){
			return ErrorDesc.failureMessage("未开放员工更新权限，当前不允许更新");
		}
		personCertificate.setStatus(ApprovalStatusEnum.WAIT.code());
		if(StringUtil.isBlank(personCertificate.getEmployeeId())){
			personCertificate.setEmployeeId(SessionUser.getCurrent().getActivatedEmployeeId());
		}

		Rcd rs=dao.queryRecord("select * from hr_person where deleted=0 and employee_id=?",SessionUser.getCurrent().getActivatedEmployeeId());
		if(rs==null){
			return ErrorDesc.failureMessage("当前用户未创建个人基本信息,请创建后在进行该操作");
		}
		personCertificate.setPersonId(rs.getString("id"));


		Result r=super.insert(personCertificate,throwsException);
		return r;
	}

	@Override
	public Result directUpdate(PersonCertificate personCertificate, SaveMode mode, boolean throwsException) {
		Result r=super.update(personCertificate , mode , throwsException);
		return r;
	}

	@Override
	public Result directInsert(PersonCertificate personCertificate, boolean throwsException) {
		personCertificate.setStatus(ApprovalStatusEnum.FINISH.code());


		if(StringUtil.isBlank(personCertificate.getPersonId())){
			return ErrorDesc.failureMessage("没有选定人员");
		}
		Rcd rs=dao.queryRecord("select * from hr_person where deleted=0 and id=?",personCertificate.getPersonId());
		if(rs!=null){
			personCertificate.setEmployeeId("employee_id");
		}

		Result r=super.insert(personCertificate,throwsException);
		return r;
	}

	@Override
	public Result approve(List<String> ids, String act, String msg) {

		for(String id:ids){
			String status="";
			if(ApprovalResultStatusEnum.AGREE.code().equals(act)){
				status=ApprovalStatusEnum.FINISH.code();
			}else{
				status=ApprovalStatusEnum.FAILED.code();
			}
			PersonCertificate obj=this.getById(id);
			if(StringUtil.isBlank(obj.getRelId())){
				//新增
				obj.setStatus(status);
				super.update(obj,SaveMode.NOT_NULL_FIELDS,false);
			}else{
				//更新
				if(ApprovalResultStatusEnum.AGREE.code().equals(act)){
					obj.setStatus(status);
					obj.setId(obj.getRelId());
					obj.setRelId("");
					super.update(obj,SaveMode.NOT_NULL_FIELDS,false);
					dao.execute("update hr_person_certificate set deleted=1 where id=?",id);
				}else{
					obj.setStatus(status);
					super.update(obj,SaveMode.NOT_NULL_FIELDS,false);
				}
			}
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param personCertificate 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(PersonCertificate personCertificate) {
		return this.insert(personCertificate,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param personCertificateList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<PersonCertificate> personCertificateList) {
		return super.insertList(personCertificateList);
	}

	
	/**
	 * 按主键删除证书信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		PersonCertificate personCertificate = new PersonCertificate();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		personCertificate.setId(id);
		try {
			boolean suc = dao.deleteEntity(personCertificate);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除证书信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		PersonCertificate personCertificate = new PersonCertificate();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		personCertificate.setId(id);
		personCertificate.setDeleted(true);
		personCertificate.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		personCertificate.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(personCertificate,SaveMode.NOT_NULL_FIELDS);
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
	 * @param personCertificate 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PersonCertificate personCertificate , SaveMode mode) {
		return this.update(personCertificate,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param personCertificate 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功 用于员工更新接口
	 * */
	@Override
	public Result update(PersonCertificate personCertificate , SaveMode mode,boolean throwsException) {

		PersonCertificate sourceData =this.getById(personCertificate.getId());
		if("0".equals(personService.queryOperParameterValue("hr.personCertificate"))){
			return ErrorDesc.failureMessage("未开放员工更新权限，当前不允许更新");
		}
		Result r=null;
		String sId=personCertificate.getId();
		String relId=personCertificate.getRelId();
		if(ApprovalStatusEnum.WAIT.code().equals(sourceData.getStatus())){
			//如果是wait 可以直接更新
			super.update(personCertificate , mode , throwsException);
			return ErrorDesc.success();
		}else if (ApprovalStatusEnum.FINISH.code().equals(sourceData.getStatus())){
			//判断是否已有审批记录，如果有审批记录，请在审批中修改
			PersonCertificateVO q=new PersonCertificateVO();
			q.setStatus(ApprovalStatusEnum.WAIT.code());
			q.setRelId(sId);
			if(this.queryList(q).size()>0){
				return ErrorDesc.failureMessage("当前记录已生生成未审批的记录条目,如需更新修改该条目。");
			}else{
				if(StringUtil.isBlank(relId)){
					//插入一条原始记录
					sourceData.setId(null);
					super.insert(sourceData,throwsException);
					//更新记录
					personCertificate.setStatus(ApprovalStatusEnum.WAIT.code());
					personCertificate.setRelId(sId);
					personCertificate.setId(sourceData.getId());
					super.update(personCertificate , mode , throwsException);
				}else{
					return ErrorDesc.failureMessage("relId不为空");
				}
			}
		}else if(ApprovalStatusEnum.FAILED.code().equals(sourceData.getStatus())){
			personCertificate.setStatus(ApprovalStatusEnum.WAIT.code());
			super.update(personCertificate , mode , throwsException);
			return ErrorDesc.success();
		}
		return ErrorDesc.success();
	}

	/**
	 * 更新实体集，事务内
	 * @param personCertificateList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<PersonCertificate> personCertificateList , SaveMode mode) {
		return super.updateList(personCertificateList , mode);
	}

	
	/**
	 * 按主键更新证书信息
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
	 * 按主键获取证书信息
	 *
	 * @param id 主键
	 * @return PersonCertificate 数据对象
	 */
	public PersonCertificate getById(String id) {
		PersonCertificate sample = new PersonCertificate();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<PersonCertificate> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<PersonCertificate> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, PersonCertificate> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, PersonCertificate::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<PersonCertificate> queryList(PersonCertificateVO sample) {
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
	public PagedList<PersonCertificate> queryPagedList(PersonCertificateVO sample, int pageSize, int pageIndex) {
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
	public PagedList<PersonCertificate> queryPagedList(PersonCertificate sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param personCertificate 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(PersonCertificate personCertificate) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(personCertificate, SYS_ROLE.NAME);
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