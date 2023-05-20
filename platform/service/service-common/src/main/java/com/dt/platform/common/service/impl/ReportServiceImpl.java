package com.dt.platform.common.service.impl;

import javax.annotation.Resource;

import com.dt.platform.common.service.IReportUDefService;
import com.dt.platform.domain.common.ReportUDef;
import com.github.foxnic.commons.lang.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.common.Report;
import com.dt.platform.domain.common.ReportVO;
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
import com.dt.platform.common.service.IReportService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 报表列服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-19 18:23:36
*/


@Service("SysReportService")

public class ReportServiceImpl extends SuperService<Report> implements IReportService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;


	@Autowired
	private IReportUDefService reportUDefService;


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
	 * @param report  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Report report,boolean throwsException) {

		if(StringUtil.isBlank(report.getReportTplId())){
			return ErrorDesc.failureMessage("请选择模版");
		}
		Result r=super.insert(report,throwsException);
		ReportUDef def=reportUDefService.getById(report.getReportTplId());
		String newId=IDGenerator.getSnowflakeIdString();
		def.setId(newId);
		def.setOwnerType("inst");
		def.setCreateTime(new Date());
		def.setUpdateTime(new Date());
		def.setFileName(newId+".ureport.xml");
		reportUDefService.insert(def,true);
		report.setReportTplDefId(newId);
		report.setRoute("/ureport/preview?_u=db:"+newId+".ureport.xml");
		super.update(report,SaveMode.NOT_NULL_FIELDS);
		return r;
	}

	@Override
	public Result copyData(String id) {
		Report report=this.getById(id);

		String defId=report.getReportTplDefId();
		ReportUDef def=reportUDefService.getById(defId);
		String newId=IDGenerator.getSnowflakeIdString();
		def.setId(newId);
		def.setOwnerType("inst");
		def.setCreateTime(new Date());
		def.setUpdateTime(new Date());
		def.setFileName(newId+".ureport.xml");
		reportUDefService.insert(def,true);

		String newReportId=IDGenerator.getSnowflakeIdString();
		report.setCode(newReportId);
		report.setId(newReportId);
		report.setName(report.getName()+"复制");
		report.setReportTplDefId(newId);
		report.setCreateTime(new Date());
		report.setUpdateTime(new Date());
		report.setReportTplDefId(newId);
		report.setRoute("/ureport/preview?_u=db:"+newId+".ureport.xml");
		super.insert(report,true);
		return ErrorDesc.success();

	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param report 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Report report) {
		return this.insert(report,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param reportList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Report> reportList) {
		return super.insertList(reportList);
	}

	
	/**
	 * 按主键删除报表列
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Report report = new Report();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		report.setId(id);
		try {
			boolean suc = dao.deleteEntity(report);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除报表列
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Report report = new Report();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		report.setId(id);
		report.setDeleted(true);
		report.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		report.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(report,SaveMode.NOT_NULL_FIELDS);
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
	 * @param report 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Report report , SaveMode mode) {
		return this.update(report,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param report 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Report report , SaveMode mode,boolean throwsException) {
		Result r=super.update(report , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param reportList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Report> reportList , SaveMode mode) {
		return super.updateList(reportList , mode);
	}

	
	/**
	 * 按主键更新报表列
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
	 * 按主键获取报表列
	 *
	 * @param id 主键
	 * @return Report 数据对象
	 */
	public Report getById(String id) {
		Report sample = new Report();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<Report> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<Report> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, Report> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, Report::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Report> queryList(ReportVO sample) {
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
	public PagedList<Report> queryPagedList(ReportVO sample, int pageSize, int pageIndex) {
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
	public PagedList<Report> queryPagedList(Report sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param report 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(Report report) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(report, SYS_ROLE.NAME);
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