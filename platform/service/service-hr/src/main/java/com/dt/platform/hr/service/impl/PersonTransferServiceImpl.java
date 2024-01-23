package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.hr.PersonBillStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonTransferRcd;
import com.dt.platform.hr.service.IPersonService;
import com.dt.platform.hr.service.IPersonTransferRcdService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.hr.PersonTransfer;
import com.dt.platform.domain.hr.PersonTransferVO;
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
import com.dt.platform.hr.service.IPersonTransferService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 员工调动服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-23 20:08:38
*/


@Service("HrPersonTransferService")

public class PersonTransferServiceImpl extends SuperService<PersonTransfer> implements IPersonTransferService {


	@Autowired
	private IPersonTransferRcdService personTransferRcdService;


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
	 * @param personTransfer  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(PersonTransfer personTransfer,boolean throwsException) {
		if(StringUtil.isBlank(personTransfer.getBusinessCode())){
			personTransfer.setBusinessCode(IDGenerator.getSnowflakeIdString());
		}
		personTransfer.setOperUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		personTransfer.setStatus(PersonBillStatusEnum.DRAFT.code());
		List<String> idsList=personTransfer.getPersonIds();
		if(personTransfer.getPersonIds()==null||personTransfer.getPersonIds().size()==0){
			return ErrorDesc.failureMessage("请选择人员");
		}
		Result r=super.insert(personTransfer,throwsException);
		if(r.isSuccess()){
			for(int i=0;i<idsList.size();i++){
				PersonTransferRcd rcd=new PersonTransferRcd();
				rcd.setStatus(PersonBillStatusEnum.DRAFT.code());
				rcd.setPersonId(idsList.get(i));
				rcd.setTransferId(personTransfer.getId());
				rcd.setOperUserId(SessionUser.getCurrent().getActivatedEmployeeId());
				personTransferRcdService.insert(rcd,false);
			}
		}
		return r;
	}

	@Override
	public Result sure(String id) {
		PersonTransfer personTransfer=this.getById(id);
		if(PersonBillStatusEnum.DRAFT.code().equals(personTransfer.getStatus())){
			personTransfer.setStatus(PersonBillStatusEnum.FINISH.code());
			super.update(personTransfer,SaveMode.NOT_NULL_FIELDS,false);
			PersonTransferRcd query=new PersonTransferRcd();
			query.setTransferId(personTransfer.getId());
			List<PersonTransferRcd> rcdList=personTransferRcdService.queryList(query);
			for(int i=0;i<rcdList.size();i++){
				PersonTransferRcd r=rcdList.get(i);
				r.setStatus(PersonBillStatusEnum.FINISH.code());
				r.setOperUserId(SessionUser.getCurrent().getActivatedEmployeeId());
				r.setOperTime(new Date());
				r.setContent(personTransfer.getContent());
				r.setTransferDate(personTransfer.getTransferDate());
				personTransferRcdService.update(r,SaveMode.NOT_NULL_FIELDS,false);
				//修改人员
				if(StringUtil.isBlank(personTransfer.getOrgId())&&StringUtil.isBlank(personTransfer.getPositionCode())){
					Logger.info("不需要修改");
				}else{
					Person person=new Person();
					person.setUpdateTime(new Date());
					person.setId(PersonTransferRcd.create().getPersonId());
					if(!StringUtil.isBlank(personTransfer.getOrgId())){
						person.setOrgId(personTransfer.getOrgId());
					}
					if(!StringUtil.isBlank(personTransfer.getPositionCode())){
						person.setPositionCode(personTransfer.getPositionCode());
					}
					personService.update(person,SaveMode.NOT_NULL_FIELDS,false);
				}
			}
		}else{
			return ErrorDesc.failureMessage("当前状态不能进行修改");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result cancel(String id) {
		PersonTransfer personTransfer=this.getById(id);
		if(PersonBillStatusEnum.DRAFT.code().equals(personTransfer.getStatus())){
			personTransfer.setStatus(PersonBillStatusEnum.CANCEL.code());
			super.update(personTransfer,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态不能进行修改");
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param personTransfer 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(PersonTransfer personTransfer) {
		return this.insert(personTransfer,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param personTransferList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<PersonTransfer> personTransferList) {
		return super.insertList(personTransferList);
	}

	
	/**
	 * 按主键删除员工调动
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		PersonTransfer personTransfer = new PersonTransfer();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		personTransfer.setId(id);
		try {
			boolean suc = dao.deleteEntity(personTransfer);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除员工调动
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		PersonTransfer personTransfer = new PersonTransfer();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		personTransfer.setId(id);
		personTransfer.setDeleted(true);
		personTransfer.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		personTransfer.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(personTransfer,SaveMode.NOT_NULL_FIELDS);
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
	 * @param personTransfer 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PersonTransfer personTransfer , SaveMode mode) {
		return this.update(personTransfer,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param personTransfer 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PersonTransfer personTransfer , SaveMode mode,boolean throwsException) {
		Result r=super.update(personTransfer , mode , throwsException);
		List<String> idsList=personTransfer.getPersonIds();
		if(personTransfer.getPersonIds()==null||personTransfer.getPersonIds().size()==0){
			return ErrorDesc.failureMessage("请选择人员");
		}
		if(r.isSuccess()){
			dao.execute("delete from hr_person_transfer_rcd where transfer_id=?",personTransfer.getId());
			for(int i=0;i<idsList.size();i++){
				PersonTransferRcd rcd=new PersonTransferRcd();
				rcd.setStatus(PersonBillStatusEnum.DRAFT.code());
				rcd.setPersonId(idsList.get(i));
				rcd.setTransferId(personTransfer.getId());
				personTransferRcdService.insert(rcd,false);
			}
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param personTransferList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<PersonTransfer> personTransferList , SaveMode mode) {
		return super.updateList(personTransferList , mode);
	}

	
	/**
	 * 按主键更新员工调动
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
	 * 按主键获取员工调动
	 *
	 * @param id 主键
	 * @return PersonTransfer 数据对象
	 */
	public PersonTransfer getById(String id) {
		PersonTransfer sample = new PersonTransfer();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<PersonTransfer> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<PersonTransfer> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, PersonTransfer> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, PersonTransfer::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<PersonTransfer> queryList(PersonTransferVO sample) {
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
	public PagedList<PersonTransfer> queryPagedList(PersonTransferVO sample, int pageSize, int pageIndex) {
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
	public PagedList<PersonTransfer> queryPagedList(PersonTransfer sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param personTransfer 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(PersonTransfer personTransfer) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(personTransfer, SYS_ROLE.NAME);
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