package com.dt.platform.contract.controller;


import java.util.List;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.contract.ContractSignerServiceProxy;
import com.dt.platform.domain.contract.meta.ContractSignerVOMeta;
import com.dt.platform.domain.contract.ContractSigner;
import com.dt.platform.domain.contract.ContractSignerVO;
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
import com.dt.platform.domain.contract.meta.ContractSignerMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractSignerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 合同签订方接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-21 15:39:33
*/

@InDoc
@Api(tags = "合同管理/合同签订方")
@RestController("ContContractSignerController")
public class ContractSignerController extends SuperController {

	@Autowired
	private IContractSignerService contractSignerService;


	/**
	 * 添加合同签订方
	*/
	@ApiOperation(value = "添加合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "565281406238851072"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class , example = "565281320981233664"),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "part_a"),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class , example = "enterprise"),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ContractSignerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.INSERT)
	public Result insert(ContractSignerVO contractSignerVO) {
		Result result=contractSignerService.insert(contractSignerVO,false);
		return result;
	}



	/**
	 * 删除合同签订方
	*/
	@ApiOperation(value = "删除合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "565281406238851072")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ContractSignerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = contractSignerService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=contractSignerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除合同签订方 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = ContractSignerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = contractSignerService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=contractSignerService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=contractSignerService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新合同签订方
	*/
	@ApiOperation(value = "更新合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "565281406238851072"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class , example = "565281320981233664"),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "part_a"),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class , example = "enterprise"),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { ContractSignerVOMeta.PAGE_INDEX , ContractSignerVOMeta.PAGE_SIZE , ContractSignerVOMeta.SEARCH_FIELD , ContractSignerVOMeta.FUZZY_FIELD , ContractSignerVOMeta.SEARCH_VALUE , ContractSignerVOMeta.DIRTY_FIELDS , ContractSignerVOMeta.SORT_FIELD , ContractSignerVOMeta.SORT_TYPE , ContractSignerVOMeta.IDS } )
	@SentinelResource(value = ContractSignerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.UPDATE)
	public Result update(ContractSignerVO contractSignerVO) {
		Result result=contractSignerService.update(contractSignerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存合同签订方
	*/
	@ApiOperation(value = "保存合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "565281406238851072"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class , example = "565281320981233664"),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "part_a"),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class , example = "enterprise"),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractSignerVOMeta.PAGE_INDEX , ContractSignerVOMeta.PAGE_SIZE , ContractSignerVOMeta.SEARCH_FIELD , ContractSignerVOMeta.FUZZY_FIELD , ContractSignerVOMeta.SEARCH_VALUE , ContractSignerVOMeta.DIRTY_FIELDS , ContractSignerVOMeta.SORT_FIELD , ContractSignerVOMeta.SORT_TYPE , ContractSignerVOMeta.IDS } )
	@SentinelResource(value = ContractSignerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.SAVE)
	public Result save(ContractSignerVO contractSignerVO) {
		Result result=contractSignerService.save(contractSignerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取合同签订方
	*/
	@ApiOperation(value = "获取合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ContractSignerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.GET_BY_ID)
	public Result<ContractSigner> getById(String id) {
		Result<ContractSigner> result=new Result<>();
		ContractSigner contractSigner=contractSignerService.getById(id);
		result.success(true).data(contractSigner);
		return result;
	}


	/**
	 * 批量获取合同签订方 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取合同签订方")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContractSignerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = ContractSignerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.GET_BY_IDS)
	public Result<List<ContractSigner>> getByIds(List<String> ids) {
		Result<List<ContractSigner>> result=new Result<>();
		List<ContractSigner> list=contractSignerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询合同签订方
	*/
	@ApiOperation(value = "查询合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "565281406238851072"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class , example = "565281320981233664"),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "part_a"),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class , example = "enterprise"),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { ContractSignerVOMeta.PAGE_INDEX , ContractSignerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContractSignerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.QUERY_LIST)
	public Result<List<ContractSigner>> queryList(ContractSignerVO sample) {
		Result<List<ContractSigner>> result=new Result<>();
		List<ContractSigner> list=contractSignerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询合同签订方
	*/
	@ApiOperation(value = "分页查询合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "565281406238851072"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class , example = "565281320981233664"),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "part_a"),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class , example = "enterprise"),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = ContractSignerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ContractSigner>> queryPagedList(ContractSignerVO sample) {
		Result<PagedList<ContractSigner>> result=new Result<>();
		PagedList<ContractSigner> list=contractSignerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}