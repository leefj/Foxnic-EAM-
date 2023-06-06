package com.dt.platform.hr.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dt.platform.proxy.hr.PersonAttendanceRecServiceProxy;
import com.dt.platform.domain.hr.meta.PersonAttendanceRecVOMeta;
import com.dt.platform.domain.hr.PersonAttendanceRec;
import com.dt.platform.domain.hr.PersonAttendanceRecVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.hr.meta.PersonAttendanceRecMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.Person;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonAttendanceRecService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员考勤接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 10:58:37
*/

@InDoc
@Api(tags = "人员考勤")
@RestController("HrPersonAttendanceRecController")
public class PersonAttendanceRecController extends SuperController {

	@Autowired
	private IPersonAttendanceRecService personAttendanceRecService;

	/**
	 * 添加人员考勤
	*/
	@ApiOperation(value = "添加人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.EMPLOYEE_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.USER_NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JB_CNT , value = "加班" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NJ_CNT , value = "年假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.SJ_CNT , value = "事假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.OTHER_CNT , value = "其他假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.CC_OUT , value = "出差" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAttendanceRecServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.INSERT)
	public Result insert(PersonAttendanceRecVO personAttendanceRecVO) {
		
		Result result=personAttendanceRecService.insert(personAttendanceRecVO,false);
		return result;
	}



	/**
	 * 删除人员考勤
	*/
	@ApiOperation(value = "删除人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAttendanceRecServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personAttendanceRecService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personAttendanceRecService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员考勤 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonAttendanceRecServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personAttendanceRecService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=personAttendanceRecService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personAttendanceRecService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新人员考勤
	*/
	@ApiOperation(value = "更新人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.EMPLOYEE_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.USER_NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JB_CNT , value = "加班" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NJ_CNT , value = "年假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.SJ_CNT , value = "事假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.OTHER_CNT , value = "其他假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.CC_OUT , value = "出差" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonAttendanceRecVOMeta.PAGE_INDEX , PersonAttendanceRecVOMeta.PAGE_SIZE , PersonAttendanceRecVOMeta.SEARCH_FIELD , PersonAttendanceRecVOMeta.FUZZY_FIELD , PersonAttendanceRecVOMeta.SEARCH_VALUE , PersonAttendanceRecVOMeta.DIRTY_FIELDS , PersonAttendanceRecVOMeta.SORT_FIELD , PersonAttendanceRecVOMeta.SORT_TYPE , PersonAttendanceRecVOMeta.DATA_ORIGIN , PersonAttendanceRecVOMeta.QUERY_LOGIC , PersonAttendanceRecVOMeta.REQUEST_ACTION , PersonAttendanceRecVOMeta.IDS } )
	@SentinelResource(value = PersonAttendanceRecServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.UPDATE)
	public Result update(PersonAttendanceRecVO personAttendanceRecVO) {
		
		Result result=personAttendanceRecService.update(personAttendanceRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存人员考勤
	*/
	@ApiOperation(value = "保存人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.EMPLOYEE_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.USER_NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JB_CNT , value = "加班" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NJ_CNT , value = "年假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.SJ_CNT , value = "事假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.OTHER_CNT , value = "其他假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.CC_OUT , value = "出差" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonAttendanceRecVOMeta.PAGE_INDEX , PersonAttendanceRecVOMeta.PAGE_SIZE , PersonAttendanceRecVOMeta.SEARCH_FIELD , PersonAttendanceRecVOMeta.FUZZY_FIELD , PersonAttendanceRecVOMeta.SEARCH_VALUE , PersonAttendanceRecVOMeta.DIRTY_FIELDS , PersonAttendanceRecVOMeta.SORT_FIELD , PersonAttendanceRecVOMeta.SORT_TYPE , PersonAttendanceRecVOMeta.DATA_ORIGIN , PersonAttendanceRecVOMeta.QUERY_LOGIC , PersonAttendanceRecVOMeta.REQUEST_ACTION , PersonAttendanceRecVOMeta.IDS } )
	@SentinelResource(value = PersonAttendanceRecServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.SAVE)
	public Result save(PersonAttendanceRecVO personAttendanceRecVO) {
		
		Result result=personAttendanceRecService.save(personAttendanceRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取人员考勤
	*/
	@ApiOperation(value = "获取人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAttendanceRecServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.GET_BY_ID)
	public Result<PersonAttendanceRec> getById(String id) {
		
		Result<PersonAttendanceRec> result=new Result<>();
		PersonAttendanceRec personAttendanceRec=personAttendanceRecService.getById(id);
		// join 关联的对象
		personAttendanceRecService.dao().fill(personAttendanceRec)
			.with(PersonAttendanceRecMeta.PERSON)
			.with(PersonAttendanceRecMeta.EMPLOYEE)
			.execute();
		result.success(true).data(personAttendanceRec);
		return result;
	}


	/**
	 * 批量获取人员考勤 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员考勤")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonAttendanceRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonAttendanceRecServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.GET_BY_IDS)
	public Result<List<PersonAttendanceRec>> getByIds(List<String> ids) {
		
		Result<List<PersonAttendanceRec>> result=new Result<>();
		List<PersonAttendanceRec> list=personAttendanceRecService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员考勤
	*/
	@ApiOperation(value = "查询人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.EMPLOYEE_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.USER_NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JB_CNT , value = "加班" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NJ_CNT , value = "年假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.SJ_CNT , value = "事假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.OTHER_CNT , value = "其他假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.CC_OUT , value = "出差" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonAttendanceRecVOMeta.PAGE_INDEX , PersonAttendanceRecVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonAttendanceRecServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.QUERY_LIST)
	public Result<List<PersonAttendanceRec>> queryList(PersonAttendanceRecVO sample) {
		
		Result<List<PersonAttendanceRec>> result=new Result<>();
		List<PersonAttendanceRec> list=personAttendanceRecService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员考勤
	*/
	@ApiOperation(value = "分页查询人员考勤")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.EMPLOYEE_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.USER_NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.JB_CNT , value = "加班" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NJ_CNT , value = "年假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.SJ_CNT , value = "事假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.OTHER_CNT , value = "其他假" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.CC_OUT , value = "出差" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAttendanceRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAttendanceRecServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonAttendanceRec>> queryPagedList(PersonAttendanceRecVO sample) {
		
		Result<PagedList<PersonAttendanceRec>> result=new Result<>();
		PagedList<PersonAttendanceRec> list=personAttendanceRecService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personAttendanceRecService.dao().fill(list)
			.with(PersonAttendanceRecMeta.PERSON)
			.with(PersonAttendanceRecMeta.EMPLOYEE)
			.execute();
		result.success(true).data(list);
		return result;
	}




	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = PersonAttendanceRecServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PersonAttendanceRecServiceProxy.EXPORT_EXCEL)
	public void exportExcel(PersonAttendanceRecVO  sample,HttpServletResponse response) throws Exception {
		
		try{
			//生成 Excel 数据
			ExcelWriter ew=personAttendanceRecService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}

	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = PersonAttendanceRecServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PersonAttendanceRecServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		
		try{
			//生成 Excel 模版
			ExcelWriter ew=personAttendanceRecService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}

	@SentinelResource(value = PersonAttendanceRecServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAttendanceRecServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}

		List<ValidateResult> errors=personAttendanceRecService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}
}