package com.dt.platform.eam.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskPointStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.InspectionTaskPointMeta;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.proxy.eam.CheckItemServiceProxy;
import com.dt.platform.proxy.eam.MaintainProjectServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.eam.InspectionPointServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPointVOMeta;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;

import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.eam.meta.InspectionPointMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPointService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 巡检点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-11 08:31:05
 */
@Api(tags = "巡检点")
@ApiSort(0)
@RestController("EamInspectionPointController")
public class InspectionPointController extends SuperController {

    @Autowired
    private IInspectionPointService inspectionPointService;

    /**
     * 添加巡检点
     */
    @ApiOperation(value = "添加巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE, value = "点位编码", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME, value = "点位名称", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS, value = "启用状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class, example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS, value = "位置详情", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_ID, value = "点位位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.ASSET_ID, value = "关联设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = InspectionPointServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(InspectionPointVO inspectionPointVO) {
        Result result = inspectionPointService.insert(inspectionPointVO, false);
        return result;
    }

    /**
     * 删除巡检点
     */
    @ApiOperation(value = "删除巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "571598323383795712")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = InspectionPointServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = inspectionPointService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除巡检点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InspectionPointServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = inspectionPointService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新巡检点
     */
    @ApiOperation(value = "更新巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE, value = "点位编码", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME, value = "点位名称", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS, value = "启用状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class, example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS, value = "位置详情", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_ID, value = "点位位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.ASSET_ID, value = "关联设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { InspectionPointVOMeta.PAGE_INDEX, InspectionPointVOMeta.PAGE_SIZE, InspectionPointVOMeta.SEARCH_FIELD, InspectionPointVOMeta.FUZZY_FIELD, InspectionPointVOMeta.SEARCH_VALUE, InspectionPointVOMeta.DIRTY_FIELDS, InspectionPointVOMeta.SORT_FIELD, InspectionPointVOMeta.SORT_TYPE, InspectionPointVOMeta.IDS })
    @SentinelResource(value = InspectionPointServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(InspectionPointVO inspectionPointVO) {
        Result result = inspectionPointService.update(inspectionPointVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存巡检点
     */
    @ApiOperation(value = "保存巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE, value = "点位编码", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME, value = "点位名称", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS, value = "启用状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class, example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS, value = "位置详情", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_ID, value = "点位位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.ASSET_ID, value = "关联设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InspectionPointVOMeta.PAGE_INDEX, InspectionPointVOMeta.PAGE_SIZE, InspectionPointVOMeta.SEARCH_FIELD, InspectionPointVOMeta.FUZZY_FIELD, InspectionPointVOMeta.SEARCH_VALUE, InspectionPointVOMeta.DIRTY_FIELDS, InspectionPointVOMeta.SORT_FIELD, InspectionPointVOMeta.SORT_TYPE, InspectionPointVOMeta.IDS })
    @SentinelResource(value = InspectionPointServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(InspectionPointVO inspectionPointVO) {
        Result result = inspectionPointService.save(inspectionPointVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取巡检点
     */
    @ApiOperation(value = "获取巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = InspectionPointServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.GET_BY_ID)
    public Result<InspectionPoint> getById(String id) {
        Result<InspectionPoint> result = new Result<>();
        InspectionPoint inspectionPoint = inspectionPointService.getById(id);
        // join 关联的对象
        inspectionPointService.dao().fill(inspectionPoint).with(InspectionPointMeta.ASSET).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.INSPECTION_POINT_POS).execute();
        result.success(true).data(inspectionPoint);
        return result;
    }

    /**
     * 批量获取巡检点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InspectionPointServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.GET_BY_IDS)
    public Result<List<InspectionPoint>> getByIds(List<String> ids) {
        Result<List<InspectionPoint>> result = new Result<>();
        List<InspectionPoint> list = inspectionPointService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询巡检点
     */
    @ApiOperation(value = "查询巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE, value = "点位编码", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME, value = "点位名称", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS, value = "启用状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class, example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS, value = "位置详情", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_ID, value = "点位位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.ASSET_ID, value = "关联设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InspectionPointVOMeta.PAGE_INDEX, InspectionPointVOMeta.PAGE_SIZE })
    @SentinelResource(value = InspectionPointServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.QUERY_LIST)
    public Result<List<InspectionPoint>> queryList(InspectionPointVO sample) {
        Result<List<InspectionPoint>> result = new Result<>();
        List<InspectionPoint> list = inspectionPointService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询巡检点
     */
    @ApiOperation(value = "分页查询巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE, value = "点位编码", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME, value = "点位名称", required = false, dataTypeClass = String.class, example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS, value = "启用状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class, example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS, value = "位置详情", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_ID, value = "点位位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.ASSET_ID, value = "关联设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = InspectionPointServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<InspectionPoint>> queryPagedList(InspectionPointVO sample) {
        Result<PagedList<InspectionPoint>> result = new Result<>();
        PagedList<InspectionPoint> list = inspectionPointService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        inspectionPointService.dao().fill(list).with(InspectionPointMeta.CHECK_ITEM_LIST).with(InspectionPointMeta.ASSET).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.INSPECTION_POINT_POS).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询保养项目
     */
    @ApiOperation(value = "分页查询项目")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 10)
    @SentinelResource(value = InspectionPointServiceProxy.QUERY_PAGED_LIST_BY_SELECT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.QUERY_PAGED_LIST_BY_SELECT)
    public Result<PagedList<InspectionPoint>> queryPagedListBySelect(InspectionPointVO sample, String ownerId, String ownerType) {
        Result<PagedList<InspectionPoint>> result = new Result<>();
        PagedList<InspectionPoint> list = inspectionPointService.queryPagedListBySelect(sample, ownerId, ownerType);
        // join 关联的对象
        inspectionPointService.dao().fill(list).with(InspectionPointMeta.CHECK_ITEM_LIST).with(InspectionPointMeta.ASSET).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.INSPECTION_POINT_POS).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询保养项目
     */
    @ApiOperation(value = "分页查询项目")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 11)
    @SentinelResource(value = InspectionPointServiceProxy.QUERY_PAGED_LIST_BY_SELECTED, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.QUERY_PAGED_LIST_BY_SELECTED)
    public Result<PagedList<InspectionPoint>> queryPagedListBySelected(InspectionPointVO sample, String ownerId, String ownerType) {
        Result<PagedList<InspectionPoint>> result = new Result<>();
        PagedList<InspectionPoint> list = inspectionPointService.queryPagedListBySelected(sample, ownerId, ownerType);
        // join 关联的对象
        inspectionPointService.dao().fill(list).with(InspectionPointMeta.CHECK_ITEM_LIST).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.INSPECTION_POINT_POS).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询保养项目
     */
    @ApiOperation(value = "选择")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 12)
    @SentinelResource(value = InspectionPointServiceProxy.SELECTED, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.SELECTED)
    public Result selected(List<String> ids, String ownerId, String selectedCode) {
        return inspectionPointService.selected(ids, ownerId, selectedCode);
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = InspectionPointServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InspectionPointServiceProxy.EXPORT_EXCEL)
    public void exportExcel(InspectionPointVO sample, HttpServletResponse response) throws Exception {
        String code="eam_asset_insepect_point";
        InputStream inputstream = inspectionPointService.buildExcelTemplate(code);
        try{
            File f = TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_"+code+".xls");
            List<InspectionPoint> list= inspectionPointService.queryList(sample);
            inspectionPointService.dao().fill(list).with(InspectionPointMeta.ASSET).with(InspectionPointMeta.ROUTE).with(InspectionPointMeta.INSPECTION_POINT_POS).execute();
            List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
            for(int i=0;i<list.size();i++){
                InspectionPoint item=list.get(i);
                Map<String, Object> assetMap= BeanUtil.toMap(item);
                if(item.getAsset()!=null){
                    assetMap.put("relAssetCode",item.getAsset().getAssetCode());
                    assetMap.put("relAssetName",item.getAsset().getName());
                    assetMap.put("relAssetModel",item.getAsset().getModel());
                }
                if(item.getInspectionPointPos()!=null){
                    assetMap.put("posName",item.getInspectionPointPos().getHierarchyName());
                }
                CodeTextEnum status= EnumUtil.parseByCode(StatusEnableEnum.class,item.getStatus());
                assetMap.put("statusName",status==null?"":status.text());
                listMap.add(assetMap);
            }
            Map<String,Object> map=new HashMap<>();
            map.put("dataList", listMap);
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            DownloadUtil.writeToOutput(response, workbook, "巡检点位.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response,e);
        }
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionPointServiceProxy.SELECT_SAVE_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.SELECT_SAVE_IDS)
    public Result selectSaveIds(String ownerId, String ids, String selectedCode) {
        return inspectionPointService.selectSaveIds(ownerId, ids, selectedCode);
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionPointServiceProxy.SELECT_DELETE_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionPointServiceProxy.SELECT_DELETE_BY_ID)
    public Result selectDeleteById(String ownerId, String id, String selectedCode) {
        return inspectionPointService.selectDeleteById(ownerId, id, selectedCode);
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = InspectionPointServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InspectionPointServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = inspectionPointService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = InspectionPointServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InspectionPointServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        String code="eam_asset_insepect_point";
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
        List<ValidateResult> errors = inspectionPointService.importExcel(input, 0, code);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            Logger.info("import Result:");
            String msg = "导入失败";
            for (int i = 0; i < errors.size(); i++) {
                Logger.info(i + ":" + errors.get(i).message);
                msg = errors.get(i).message;
            }
            return ErrorDesc.failure().message(msg).data(errors);
        }
    }
}
