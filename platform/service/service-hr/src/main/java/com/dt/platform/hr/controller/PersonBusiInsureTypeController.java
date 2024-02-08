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


import com.dt.platform.proxy.hr.PersonBusiInsureTypeServiceProxy;
import com.dt.platform.domain.hr.meta.PersonBusiInsureTypeVOMeta;
import com.dt.platform.domain.hr.PersonBusiInsureType;
import com.dt.platform.domain.hr.PersonBusiInsureTypeVO;
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
import com.dt.platform.domain.hr.meta.PersonBusiInsureTypeMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonBusiInsureTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商业保险类别接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-06 13:12:19
*/

@InDoc
@Api(tags = "商业保险类别")
@RestController("HrPersonBusiInsureTypeController")
public class PersonBusiInsureTypeController extends SuperController {

	@Autowired
	private IPersonBusiInsureTypeService personBusiInsureTypeService;

	/**
	 * 添加商业保险类别
	*/
	@ApiOperation(value = "添加商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "807203493323472896"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "类别A"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.RECYCLE , value = "保险周期" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.MONEY , value = "保险金额" , required = false , dataTypeClass=BigDecimal.class , example = "2000.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.INSERT)
	public Result insert(PersonBusiInsureTypeVO personBusiInsureTypeVO) {
		
		Result result=personBusiInsureTypeService.insert(personBusiInsureTypeVO,false);
		return result;
	}



	/**
	 * 删除商业保险类别
	*/
	@ApiOperation(value = "删除商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "807203493323472896")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personBusiInsureTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personBusiInsureTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除商业保险类别 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personBusiInsureTypeService.hasRefers(ids);
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
			Result result=personBusiInsureTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personBusiInsureTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新商业保险类别
	*/
	@ApiOperation(value = "更新商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "807203493323472896"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "类别A"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.RECYCLE , value = "保险周期" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.MONEY , value = "保险金额" , required = false , dataTypeClass=BigDecimal.class , example = "2000.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonBusiInsureTypeVOMeta.PAGE_INDEX , PersonBusiInsureTypeVOMeta.PAGE_SIZE , PersonBusiInsureTypeVOMeta.SEARCH_FIELD , PersonBusiInsureTypeVOMeta.FUZZY_FIELD , PersonBusiInsureTypeVOMeta.SEARCH_VALUE , PersonBusiInsureTypeVOMeta.DIRTY_FIELDS , PersonBusiInsureTypeVOMeta.SORT_FIELD , PersonBusiInsureTypeVOMeta.SORT_TYPE , PersonBusiInsureTypeVOMeta.DATA_ORIGIN , PersonBusiInsureTypeVOMeta.QUERY_LOGIC , PersonBusiInsureTypeVOMeta.REQUEST_ACTION , PersonBusiInsureTypeVOMeta.IDS } )
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.UPDATE)
	public Result update(PersonBusiInsureTypeVO personBusiInsureTypeVO) {
		
		Result result=personBusiInsureTypeService.update(personBusiInsureTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存商业保险类别
	*/
	@ApiOperation(value = "保存商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "807203493323472896"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "类别A"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.RECYCLE , value = "保险周期" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.MONEY , value = "保险金额" , required = false , dataTypeClass=BigDecimal.class , example = "2000.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonBusiInsureTypeVOMeta.PAGE_INDEX , PersonBusiInsureTypeVOMeta.PAGE_SIZE , PersonBusiInsureTypeVOMeta.SEARCH_FIELD , PersonBusiInsureTypeVOMeta.FUZZY_FIELD , PersonBusiInsureTypeVOMeta.SEARCH_VALUE , PersonBusiInsureTypeVOMeta.DIRTY_FIELDS , PersonBusiInsureTypeVOMeta.SORT_FIELD , PersonBusiInsureTypeVOMeta.SORT_TYPE , PersonBusiInsureTypeVOMeta.DATA_ORIGIN , PersonBusiInsureTypeVOMeta.QUERY_LOGIC , PersonBusiInsureTypeVOMeta.REQUEST_ACTION , PersonBusiInsureTypeVOMeta.IDS } )
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.SAVE)
	public Result save(PersonBusiInsureTypeVO personBusiInsureTypeVO) {
		
		Result result=personBusiInsureTypeService.save(personBusiInsureTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取商业保险类别
	*/
	@ApiOperation(value = "获取商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.GET_BY_ID)
	public Result<PersonBusiInsureType> getById(String id) {
		
		Result<PersonBusiInsureType> result=new Result<>();
		PersonBusiInsureType personBusiInsureType=personBusiInsureTypeService.getById(id);
		result.success(true).data(personBusiInsureType);
		return result;
	}


	/**
	 * 批量获取商业保险类别 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取商业保险类别")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonBusiInsureTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.GET_BY_IDS)
	public Result<List<PersonBusiInsureType>> getByIds(List<String> ids) {
		
		Result<List<PersonBusiInsureType>> result=new Result<>();
		List<PersonBusiInsureType> list=personBusiInsureTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询商业保险类别
	*/
	@ApiOperation(value = "查询商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "807203493323472896"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "类别A"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.RECYCLE , value = "保险周期" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.MONEY , value = "保险金额" , required = false , dataTypeClass=BigDecimal.class , example = "2000.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonBusiInsureTypeVOMeta.PAGE_INDEX , PersonBusiInsureTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.QUERY_LIST)
	public Result<List<PersonBusiInsureType>> queryList(PersonBusiInsureTypeVO sample) {
		
		Result<List<PersonBusiInsureType>> result=new Result<>();
		List<PersonBusiInsureType> list=personBusiInsureTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询商业保险类别
	*/
	@ApiOperation(value = "分页查询商业保险类别")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "807203493323472896"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "类别A"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.RECYCLE , value = "保险周期" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.MONEY , value = "保险金额" , required = false , dataTypeClass=BigDecimal.class , example = "2000.00"),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonBusiInsureTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonBusiInsureTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonBusiInsureTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonBusiInsureType>> queryPagedList(PersonBusiInsureTypeVO sample) {
		
		Result<PagedList<PersonBusiInsureType>> result=new Result<>();
		PagedList<PersonBusiInsureType> list=personBusiInsureTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}