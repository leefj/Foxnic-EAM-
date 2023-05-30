package com.dt.platform.common.service.impl;

import javax.annotation.Resource;

import com.dt.platform.domain.common.ReportCategory;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.sql.expr.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.common.FormCategory;
import com.dt.platform.domain.common.FormCategoryVO;
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
import com.dt.platform.common.service.IFormCategoryService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 表单类型服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 08:15:49
*/


@Service("SysFormCategoryService")

public class FormCategoryServiceImpl extends SuperService<FormCategory> implements IFormCategoryService {

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
	 * @param formCategory  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(FormCategory formCategory,boolean throwsException) {
		Result r=super.insert(formCategory,throwsException);
		return r;
	}

	@Override
	public Result updateHierarchy(String id) {
		FormCategory category= getById(id);
		String hierarchy=category.getHierarchy();
		String split="/";
		String afterHierarchyName="";
		String[] ids = hierarchy.split(split);
		for (int i = 0; i < ids.length;i++) {
			afterHierarchyName = afterHierarchyName + split+ getById(ids[i]).getName();
		}
		afterHierarchyName = afterHierarchyName.replaceFirst(split, "");
		Update ups = new Update("sys_form_category");
		ups.set("hierarchy_name", afterHierarchyName);
		ups.where().and("id=?", id);
		dao.execute(ups);
		List<FormCategory> positionList=queryList(FormCategory.create().setParentId(id));
		for (int j = 0; j < positionList.size(); j++) {
			updateHierarchy(positionList.get(j).getId());
		}
		Result r=new Result();
		r.success(true);
		r.message(CommonError.SUCCESS_TEXT);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param formCategory 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(FormCategory formCategory) {
		return this.insert(formCategory,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param formCategoryList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<FormCategory> formCategoryList) {
		return super.insertList(formCategoryList);
	}

	
	/**
	 * 按主键删除表单类型
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		FormCategory formCategory = new FormCategory();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		formCategory.setId(id);
		try {
			boolean suc = dao.deleteEntity(formCategory);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除表单类型
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		FormCategory formCategory = new FormCategory();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		formCategory.setId(id);
		formCategory.setDeleted(true);
		formCategory.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		formCategory.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(formCategory,SaveMode.NOT_NULL_FIELDS);
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
	 * @param formCategory 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(FormCategory formCategory , SaveMode mode) {
		return this.update(formCategory,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param formCategory 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(FormCategory formCategory , SaveMode mode,boolean throwsException) {
		Result r=super.update(formCategory , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param formCategoryList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<FormCategory> formCategoryList , SaveMode mode) {
		return super.updateList(formCategoryList , mode);
	}

	
	/**
	 * 按主键更新表单类型
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
	 * 按主键获取表单类型
	 *
	 * @param id 主键
	 * @return FormCategory 数据对象
	 */
	public FormCategory getById(String id) {
		FormCategory sample = new FormCategory();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<FormCategory> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<FormCategory> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, FormCategory> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, FormCategory::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<FormCategory> queryList(FormCategoryVO sample) {
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
	public PagedList<FormCategory> queryPagedList(FormCategoryVO sample, int pageSize, int pageIndex) {
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
	public PagedList<FormCategory> queryPagedList(FormCategory sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param formCategory 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(FormCategory formCategory) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(formCategory, SYS_ROLE.NAME);
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