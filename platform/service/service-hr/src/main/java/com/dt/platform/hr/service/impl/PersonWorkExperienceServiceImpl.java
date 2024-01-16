package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.hr.ApprovalResultStatusEnum;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.PersonSocialRelation;
import com.dt.platform.hr.service.IPersonService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.hr.PersonWorkExperience;
import com.dt.platform.domain.hr.PersonWorkExperienceVO;
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
import com.dt.platform.hr.service.IPersonWorkExperienceService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 工作经历服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 16:02:17
*/


@Service("HrPersonWorkExperienceService")

public class PersonWorkExperienceServiceImpl extends SuperService<PersonWorkExperience> implements IPersonWorkExperienceService {

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
	 * @param personWorkExperience  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(PersonWorkExperience personWorkExperience,boolean throwsException) {

		if("0".equals(personService.queryOperParameterValue("hr.personWork"))){
			return ErrorDesc.failureMessage("未开放员工更新权限，当前不允许更新");
		}

		personWorkExperience.setStatus(ApprovalStatusEnum.WAIT.code());
		if(StringUtil.isBlank(personWorkExperience.getEmployeeId())){
			personWorkExperience.setEmployeeId(SessionUser.getCurrent().getActivatedEmployeeId());
		}


		Rcd rs=dao.queryRecord("select * from hr_person where deleted=0 and employee_id=?",SessionUser.getCurrent().getActivatedEmployeeId());
		if(rs==null){
			return ErrorDesc.failureMessage("当前用户未创建个人基本信息,请创建后在进行该操作");
		}
		personWorkExperience.setPersonId(rs.getString("id"));

		Result r=super.insert(personWorkExperience,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param personWorkExperience 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(PersonWorkExperience personWorkExperience) {
		return this.insert(personWorkExperience,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param personWorkExperienceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<PersonWorkExperience> personWorkExperienceList) {
		return super.insertList(personWorkExperienceList);
	}

	@Override
	public Result directUpdate(PersonWorkExperience personWorkExperience, SaveMode mode, boolean throwsException) {
		Result r=super.update(personWorkExperience , mode , throwsException);
		return r;
	}

	@Override
	public Result directInsert(PersonWorkExperience personWorkExperience, boolean throwsException) {
		if(StringUtil.isBlank(personWorkExperience.getPersonId())){
			return ErrorDesc.failureMessage("没有选定人员");
		}
		Rcd rs=dao.queryRecord("select * from hr_person where deleted=0 and id=?",personWorkExperience.getPersonId());
		if(rs!=null){
			personWorkExperience.setEmployeeId("employee_id");
		}
		Result r=super.insert(personWorkExperience,throwsException);
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
			PersonWorkExperience obj=this.getById(id);
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
					dao.execute("update hr_person_work_experience set deleted=1 where id=?",id);
				}else{
					obj.setStatus(status);
					super.update(obj,SaveMode.NOT_NULL_FIELDS,false);
				}
			}
		}
		return ErrorDesc.success();
	}
	
	/**
	 * 按主键删除工作经历
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		PersonWorkExperience personWorkExperience = new PersonWorkExperience();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		personWorkExperience.setId(id);
		try {
			boolean suc = dao.deleteEntity(personWorkExperience);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除工作经历
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		PersonWorkExperience personWorkExperience = new PersonWorkExperience();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		personWorkExperience.setId(id);
		personWorkExperience.setDeleted(true);
		personWorkExperience.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		personWorkExperience.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(personWorkExperience,SaveMode.NOT_NULL_FIELDS);
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
	 * @param personWorkExperience 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PersonWorkExperience personWorkExperience , SaveMode mode) {
		return this.update(personWorkExperience,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param personWorkExperience 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PersonWorkExperience personWorkExperience , SaveMode mode,boolean throwsException) {
		PersonWorkExperience sourceData =this.getById(personWorkExperience.getId());
		if("0".equals(personService.queryOperParameterValue("hr.personCertificate"))){
			return ErrorDesc.failureMessage("未开放员工更新权限，当前不允许更新");
		}
		Result r=null;
		String sId=personWorkExperience.getId();
		String relId=personWorkExperience.getRelId();
		if(ApprovalStatusEnum.WAIT.code().equals(sourceData.getStatus())){
			//如果是wait 可以直接更新
			super.update(personWorkExperience , mode , throwsException);
			return ErrorDesc.success();
		}else if (ApprovalStatusEnum.FINISH.code().equals(sourceData.getStatus())){
			//判断是否已有审批记录，如果有审批记录，请在审批中修改
			PersonWorkExperience q=new PersonWorkExperience();
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
					personWorkExperience.setStatus(ApprovalStatusEnum.WAIT.code());
					personWorkExperience.setRelId(sId);
					personWorkExperience.setId(sourceData.getId());
					super.update(personWorkExperience , mode , throwsException);
				}else{
					return ErrorDesc.failureMessage("relId不为空");
				}
			}
		}else if(ApprovalStatusEnum.FAILED.code().equals(sourceData.getStatus())){
			personWorkExperience.setStatus(ApprovalStatusEnum.WAIT.code());
			super.update(personWorkExperience , mode , throwsException);
			return ErrorDesc.success();
		}
		return ErrorDesc.success();
	}

	/**
	 * 更新实体集，事务内
	 * @param personWorkExperienceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<PersonWorkExperience> personWorkExperienceList , SaveMode mode) {
		return super.updateList(personWorkExperienceList , mode);
	}

	
	/**
	 * 按主键更新工作经历
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
	 * 按主键获取工作经历
	 *
	 * @param id 主键
	 * @return PersonWorkExperience 数据对象
	 */
	public PersonWorkExperience getById(String id) {
		PersonWorkExperience sample = new PersonWorkExperience();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<PersonWorkExperience> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<PersonWorkExperience> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, PersonWorkExperience> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, PersonWorkExperience::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<PersonWorkExperience> queryList(PersonWorkExperienceVO sample) {
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
	public PagedList<PersonWorkExperience> queryPagedList(PersonWorkExperienceVO sample, int pageSize, int pageIndex) {
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
	public PagedList<PersonWorkExperience> queryPagedList(PersonWorkExperience sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param personWorkExperience 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(PersonWorkExperience personWorkExperience) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(personWorkExperience, SYS_ROLE.NAME);
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