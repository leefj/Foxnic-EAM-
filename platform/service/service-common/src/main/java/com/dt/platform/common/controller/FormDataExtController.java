package com.dt.platform.common.controller;

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


import com.dt.platform.proxy.common.FormDataExtServiceProxy;
import com.dt.platform.domain.common.meta.FormDataExtVOMeta;
import com.dt.platform.domain.common.FormDataExt;
import com.dt.platform.domain.common.FormDataExtVO;
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
import com.dt.platform.domain.common.meta.FormDataExtMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IFormDataExtService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据扩展接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:56
*/

@InDoc
@Api(tags = "数据扩展")
@RestController("SysFormDataExtController")
public class FormDataExtController extends SuperController {

	@Autowired
	private IFormDataExtService formDataExtService;

	/**
	 * 添加数据扩展
	*/
	@ApiOperation(value = "添加数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "715640582852050944"),
		@ApiImplicitParam(name = FormDataExtVOMeta.DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "715640563604389888"),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS4 , value = "字符串4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS5 , value = "字符串5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS6 , value = "字符串6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS7 , value = "字符串7" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS8 , value = "字符串8" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS9 , value = "字符串9" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS10 , value = "字符串10" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S11 , value = "字符串11" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S12 , value = "字符串12" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S13 , value = "字符串13" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S14 , value = "字符串14" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S15 , value = "字符串15" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S16 , value = "字符串16" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S17 , value = "字符串17" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S18 , value = "字符串18" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S19 , value = "字符串19" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S20 , value = "字符串20" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS1 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS2 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS3 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS4 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS5 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS1 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS2 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS3 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS4 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D1 , value = "时间1" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D2 , value = "时间2" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D3 , value = "时间3" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D4 , value = "时间4" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D5 , value = "时间5" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D6 , value = "时间6" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I1 , value = "整形1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I2 , value = "整形2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I3 , value = "整形3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I4 , value = "整形4" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I5 , value = "整形5" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F1 , value = "浮点1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F2 , value = "浮点2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F3 , value = "浮点3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F4 , value = "浮点4" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F5 , value = "浮点5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F6 , value = "浮点6" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F7 , value = "浮点7" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F8 , value = "浮点8" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F9 , value = "浮点9" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F10 , value = "浮点10" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataExtServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.INSERT)
	public Result insert(FormDataExtVO formDataExtVO) {
		
		Result result=formDataExtService.insert(formDataExtVO,false);
		return result;
	}



	/**
	 * 删除数据扩展
	*/
	@ApiOperation(value = "删除数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "715640582852050944")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataExtServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  formDataExtService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=formDataExtService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据扩展 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = FormDataExtServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = formDataExtService.hasRefers(ids);
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
			Result result=formDataExtService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=formDataExtService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据扩展
	*/
	@ApiOperation(value = "更新数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "715640582852050944"),
		@ApiImplicitParam(name = FormDataExtVOMeta.DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "715640563604389888"),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS4 , value = "字符串4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS5 , value = "字符串5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS6 , value = "字符串6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS7 , value = "字符串7" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS8 , value = "字符串8" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS9 , value = "字符串9" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS10 , value = "字符串10" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S11 , value = "字符串11" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S12 , value = "字符串12" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S13 , value = "字符串13" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S14 , value = "字符串14" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S15 , value = "字符串15" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S16 , value = "字符串16" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S17 , value = "字符串17" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S18 , value = "字符串18" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S19 , value = "字符串19" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S20 , value = "字符串20" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS1 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS2 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS3 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS4 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS5 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS1 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS2 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS3 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS4 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D1 , value = "时间1" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D2 , value = "时间2" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D3 , value = "时间3" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D4 , value = "时间4" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D5 , value = "时间5" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D6 , value = "时间6" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I1 , value = "整形1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I2 , value = "整形2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I3 , value = "整形3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I4 , value = "整形4" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I5 , value = "整形5" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F1 , value = "浮点1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F2 , value = "浮点2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F3 , value = "浮点3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F4 , value = "浮点4" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F5 , value = "浮点5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F6 , value = "浮点6" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F7 , value = "浮点7" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F8 , value = "浮点8" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F9 , value = "浮点9" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F10 , value = "浮点10" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormDataExtVOMeta.PAGE_INDEX , FormDataExtVOMeta.PAGE_SIZE , FormDataExtVOMeta.SEARCH_FIELD , FormDataExtVOMeta.FUZZY_FIELD , FormDataExtVOMeta.SEARCH_VALUE , FormDataExtVOMeta.DIRTY_FIELDS , FormDataExtVOMeta.SORT_FIELD , FormDataExtVOMeta.SORT_TYPE , FormDataExtVOMeta.DATA_ORIGIN , FormDataExtVOMeta.QUERY_LOGIC , FormDataExtVOMeta.REQUEST_ACTION , FormDataExtVOMeta.IDS } )
	@SentinelResource(value = FormDataExtServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.UPDATE)
	public Result update(FormDataExtVO formDataExtVO) {
		
		Result result=formDataExtService.update(formDataExtVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据扩展
	*/
	@ApiOperation(value = "保存数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "715640582852050944"),
		@ApiImplicitParam(name = FormDataExtVOMeta.DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "715640563604389888"),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS4 , value = "字符串4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS5 , value = "字符串5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS6 , value = "字符串6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS7 , value = "字符串7" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS8 , value = "字符串8" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS9 , value = "字符串9" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS10 , value = "字符串10" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S11 , value = "字符串11" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S12 , value = "字符串12" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S13 , value = "字符串13" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S14 , value = "字符串14" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S15 , value = "字符串15" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S16 , value = "字符串16" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S17 , value = "字符串17" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S18 , value = "字符串18" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S19 , value = "字符串19" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S20 , value = "字符串20" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS1 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS2 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS3 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS4 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS5 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS1 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS2 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS3 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS4 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D1 , value = "时间1" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D2 , value = "时间2" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D3 , value = "时间3" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D4 , value = "时间4" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D5 , value = "时间5" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D6 , value = "时间6" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I1 , value = "整形1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I2 , value = "整形2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I3 , value = "整形3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I4 , value = "整形4" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I5 , value = "整形5" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F1 , value = "浮点1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F2 , value = "浮点2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F3 , value = "浮点3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F4 , value = "浮点4" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F5 , value = "浮点5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F6 , value = "浮点6" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F7 , value = "浮点7" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F8 , value = "浮点8" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F9 , value = "浮点9" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F10 , value = "浮点10" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FormDataExtVOMeta.PAGE_INDEX , FormDataExtVOMeta.PAGE_SIZE , FormDataExtVOMeta.SEARCH_FIELD , FormDataExtVOMeta.FUZZY_FIELD , FormDataExtVOMeta.SEARCH_VALUE , FormDataExtVOMeta.DIRTY_FIELDS , FormDataExtVOMeta.SORT_FIELD , FormDataExtVOMeta.SORT_TYPE , FormDataExtVOMeta.DATA_ORIGIN , FormDataExtVOMeta.QUERY_LOGIC , FormDataExtVOMeta.REQUEST_ACTION , FormDataExtVOMeta.IDS } )
	@SentinelResource(value = FormDataExtServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.SAVE)
	public Result save(FormDataExtVO formDataExtVO) {
		
		Result result=formDataExtService.save(formDataExtVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据扩展
	*/
	@ApiOperation(value = "获取数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataExtServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.GET_BY_ID)
	public Result<FormDataExt> getById(String id) {
		
		Result<FormDataExt> result=new Result<>();
		FormDataExt formDataExt=formDataExtService.getById(id);
		result.success(true).data(formDataExt);
		return result;
	}


	/**
	 * 批量获取数据扩展 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据扩展")
		@ApiImplicitParams({
				@ApiImplicitParam(name = FormDataExtVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = FormDataExtServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.GET_BY_IDS)
	public Result<List<FormDataExt>> getByIds(List<String> ids) {
		
		Result<List<FormDataExt>> result=new Result<>();
		List<FormDataExt> list=formDataExtService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据扩展
	*/
	@ApiOperation(value = "查询数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "715640582852050944"),
		@ApiImplicitParam(name = FormDataExtVOMeta.DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "715640563604389888"),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS4 , value = "字符串4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS5 , value = "字符串5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS6 , value = "字符串6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS7 , value = "字符串7" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS8 , value = "字符串8" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS9 , value = "字符串9" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS10 , value = "字符串10" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S11 , value = "字符串11" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S12 , value = "字符串12" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S13 , value = "字符串13" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S14 , value = "字符串14" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S15 , value = "字符串15" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S16 , value = "字符串16" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S17 , value = "字符串17" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S18 , value = "字符串18" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S19 , value = "字符串19" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S20 , value = "字符串20" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS1 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS2 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS3 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS4 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS5 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS1 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS2 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS3 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS4 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D1 , value = "时间1" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D2 , value = "时间2" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D3 , value = "时间3" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D4 , value = "时间4" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D5 , value = "时间5" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D6 , value = "时间6" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I1 , value = "整形1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I2 , value = "整形2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I3 , value = "整形3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I4 , value = "整形4" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I5 , value = "整形5" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F1 , value = "浮点1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F2 , value = "浮点2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F3 , value = "浮点3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F4 , value = "浮点4" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F5 , value = "浮点5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F6 , value = "浮点6" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F7 , value = "浮点7" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F8 , value = "浮点8" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F9 , value = "浮点9" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F10 , value = "浮点10" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormDataExtVOMeta.PAGE_INDEX , FormDataExtVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FormDataExtServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.QUERY_LIST)
	public Result<List<FormDataExt>> queryList(FormDataExtVO sample) {
		
		Result<List<FormDataExt>> result=new Result<>();
		List<FormDataExt> list=formDataExtService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据扩展
	*/
	@ApiOperation(value = "分页查询数据扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "715640582852050944"),
		@ApiImplicitParam(name = FormDataExtVOMeta.DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "715640563604389888"),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS4 , value = "字符串4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS5 , value = "字符串5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS6 , value = "字符串6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS7 , value = "字符串7" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS8 , value = "字符串8" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS9 , value = "字符串9" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.SS10 , value = "字符串10" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S11 , value = "字符串11" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S12 , value = "字符串12" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S13 , value = "字符串13" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S14 , value = "字符串14" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S15 , value = "字符串15" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S16 , value = "字符串16" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S17 , value = "字符串17" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S18 , value = "字符串18" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S19 , value = "字符串19" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.S20 , value = "字符串20" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS1 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS2 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS3 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS4 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.LS5 , value = "长字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS1 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS2 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS3 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.TS4 , value = "文本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D1 , value = "时间1" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D2 , value = "时间2" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D3 , value = "时间3" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D4 , value = "时间4" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D5 , value = "时间5" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.D6 , value = "时间6" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I1 , value = "整形1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I2 , value = "整形2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I3 , value = "整形3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I4 , value = "整形4" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.I5 , value = "整形5" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F1 , value = "浮点1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F2 , value = "浮点2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F3 , value = "浮点3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F4 , value = "浮点4" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F5 , value = "浮点5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F6 , value = "浮点6" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F7 , value = "浮点7" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F8 , value = "浮点8" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F9 , value = "浮点9" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = FormDataExtVOMeta.F10 , value = "浮点10" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataExtServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataExtServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<FormDataExt>> queryPagedList(FormDataExtVO sample) {
		
		Result<PagedList<FormDataExt>> result=new Result<>();
		PagedList<FormDataExt> list=formDataExtService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}