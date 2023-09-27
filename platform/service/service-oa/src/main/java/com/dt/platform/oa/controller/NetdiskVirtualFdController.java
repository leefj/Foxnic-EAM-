package com.dt.platform.oa.controller;

import java.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.oa.NetDiskRootEnum;
import com.dt.platform.constants.enums.oa.NetdiskVirtualFdTypeEnum;
import com.dt.platform.oa.service.INetdiskFileService;
import com.dt.platform.oa.service.INetdiskOriginFileService;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.RcdSet;
import com.alibaba.fastjson.JSONObject;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.oa.NetdiskVirtualFdServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskVirtualFdVOMeta;
import com.dt.platform.domain.oa.NetdiskVirtualFd;
import com.dt.platform.domain.oa.NetdiskVirtualFdVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;

import com.github.foxnic.api.error.ErrorDesc;

import java.util.Map;

import com.dt.platform.domain.oa.meta.NetdiskVirtualFdMeta;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.dt.platform.oa.service.INetdiskVirtualFdService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 虚拟文件接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 21:00:45
 */
@InDoc
@Api(tags = "虚拟文件")
@RestController("OaNetdiskVirtualFdController")
public class NetdiskVirtualFdController extends SuperController {

    @Autowired
    private INetdiskVirtualFdService netdiskVirtualFdService;

    @Autowired
    private INetdiskFileService netdiskFileService;

    @Autowired
    private INetdiskOriginFileService netdiskOriginFileService;


    /**
     * 删除虚拟文件
     */
    @ApiOperation(value = "删除虚拟文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskVirtualFdServiceProxy.DELETE)
    public Result deleteById(String id, String type) {
        Result result = netdiskVirtualFdService.delete(id, type);
        return result;
    }


    /**
     * 分享
     */
    @ApiOperation(value = "分享")
    @ApiImplicitParams({
            @ApiImplicitParam(name = NetdiskVirtualFdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
    })
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.SHARE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskVirtualFdServiceProxy.SHARE)
    public Result share(String data, List<String> userIds,String shareId) {
        Result result = netdiskVirtualFdService.share(data,userIds,shareId);
        return result;
    }


    /**
     * 下载文件
     */
    @ApiOperation(value = "下载文件")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskVirtualFdServiceProxy.BATCH_DELETE)
    public Result batchDelete(String data) {
        return netdiskVirtualFdService.batchDelete(data);
    }

    /**
     * 下载
     */
    @ApiOperation(value = "下载")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.DOWNLOAD_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(NetdiskVirtualFdServiceProxy.DOWNLOAD_BY_ID)
    public void downloadById(HttpServletRequest request, HttpServletResponse response,String id,String fdId,String fdType,String inline) throws Exception {
        if(StringUtil.isBlank(inline)){
            inline="false";
        }
        Boolean il = DataParser.parseBoolean(inline);
        if(il==null) il=false;

        if(!StringUtil.isBlank(fdId)){
            id=netdiskFileService.getById(fdId).getOriginFileId();
        }
        if(StringUtil.isBlank(fdType)){
            fdType=NetdiskVirtualFdTypeEnum.FILE.code();
        }
        if(NetdiskVirtualFdTypeEnum.FILE.code().equals(fdType)){
            netdiskOriginFileService.downloadFile(id, il, response);
        }

    }

    /**
     * 上传文件
     */
    @ApiOperation(value = "上传文件")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.UPLOAD_FILE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskVirtualFdServiceProxy.UPLOAD_FILE)
    public void uploadFile(MultipartHttpServletRequest request, HttpServletResponse response)  throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, MultipartFile> map = request.getFileMap();
        String dir=request.getParameter("dir");
        if (map == null || map.size() == 0) {
            response.getWriter().write(JSON.toJSONString(ErrorDesc.failure(CommonError.FILE_INVALID)));
            return;
        }
        // 校验文件清单
        List<Result> subs = new ArrayList<Result>();
        for (String f : map.keySet()) {
            MultipartFile mf = map.get(f);
            if (mf.getSize() <= 0) {
                subs.add(ErrorDesc.failure(CommonError.FILE_INVALID).data(mf.getName()));
            }
        }
        if (subs.size() > 0) {
            response.getWriter().write(JSON.toJSONString(ErrorDesc.failure(CommonError.FILE_INVALID)));
            return;
        }
        //
        JSONArray list = new JSONArray();
        JSONObject ret = new JSONObject();
        Result<NetdiskOriginFile> fileInfoResult=null;
        Boolean addRight=true;
        for (String f : map.keySet()) {
            MultipartFile mf = map.get(f);
            fileInfoResult = netdiskOriginFileService.uploadFile(mf,dir);
            String id = fileInfoResult.data().getId();
            ret.put("fileId", id);
            ret.put("fileName", mf.getOriginalFilename());
            ret.put("field", mf.getName());
            list.add(ret);
            if(!fileInfoResult.isSuccess()){
                addRight=false;
            }
            break;
        }
        if(addRight){
            response.getWriter().write(JSON.toJSONString(ErrorDesc.success().data(list)));
        }else{
            Result<JSONArray> r=new Result<>();
            r.success(false);
            r.data(list);
            r.message(fileInfoResult.getMessage());
            response.getWriter().write(JSON.toJSONString(r));
        }

    }


    /**
     * 上传文件夹
     */
    @ApiOperation(value = "上传文件夹")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.UPLOAD_FOLDER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskVirtualFdServiceProxy.UPLOAD_FOLDER)
    public Result uploadFolder(String id) {
        return netdiskVirtualFdService.uploadFolder(id);
    }






    /**
     * 查询虚拟文件
     */
    @ApiOperation(value = "查询虚拟文件")
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskVirtualFdVOMeta.PAGE_INDEX, NetdiskVirtualFdVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.RENAME, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskVirtualFdServiceProxy.RENAME)
    public Result rename(String id, String name, String type) {
        return netdiskVirtualFdService.rename(id, name, type);
    }

//    /**
//     * 查询虚拟文件
//     */
//    @ApiOperation(value = "查询虚拟文件")
//    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskVirtualFdVOMeta.PAGE_INDEX, NetdiskVirtualFdVOMeta.PAGE_SIZE })
//    @SentinelResource(value = NetdiskVirtualFdServiceProxy.FAVOURITE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
//    @PostMapping(NetdiskVirtualFdServiceProxy.FAVOURITE)
//    public Result favourite(String id, String type) {
//        return netdiskVirtualFdService.favourite(id, type);
//    }

    /**
     * 查询虚拟文件
     */
//    @ApiOperation(value = "查询虚拟文件")
//    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskVirtualFdVOMeta.PAGE_INDEX, NetdiskVirtualFdVOMeta.PAGE_SIZE })
//    @SentinelResource(value = NetdiskVirtualFdServiceProxy.FAVOURITE_CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
//    @PostMapping(NetdiskVirtualFdServiceProxy.FAVOURITE_CANCEL)
//    public Result favouriteCancel(String id, String type) {
//        return netdiskVirtualFdService.favouriteCancel(id, type);
//    }


    /**
     * 分页查询虚拟文件
     */
    @ApiOperation(value = "分页查询虚拟文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FD_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FD_NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FD_TYPE, value = "fd类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FD_SIZE, value = "大小", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FOLDER_ID, value = "文件夹", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FD_FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FD_HIERARCHY, value = "路径编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskVirtualFdVOMeta.FD_HIERARCHY_NAME, value = "路径名称", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskVirtualFdServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskVirtualFdServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskVirtualFd>> queryPagedList(NetdiskVirtualFdVO sample) {
        String currentId = sample.getFdId();
        if (StringUtil.isBlank(currentId)) {
            currentId = NetDiskRootEnum.SPACE.code();
        }
        String fdType=sample.getFdType();

        String fdFileType=sample.getFdFileType();
        if(!StringUtil.isBlank(fdFileType)){
            fdType= NetdiskVirtualFdTypeEnum.FILE.code();
        }
        //目前只有，只查询文件，或者文件+文件夹
        String folderSql = "select id id,id fd_id,name fd_name,'-' fd_size,user_id,parent_id ,create_time,'folder' fd_type,0 sn,hierarchy fd_hierarchy, hierarchy_name fd_hierarchy_name from oa_netdisk_folder where user_id='"+ SessionUser.getCurrent().getActivatedEmployeeId() +"' and deleted=0 and in_recycle='N' and parent_id=?";
        String fileSql   = "select id id,id fd_id,file_name fd_name,file_size fd_size,user_id,folder_id, create_time,'file' fd_type, 1 sn,'-' fd_hierarchy, '-' fd_hierarchy_name from oa_netdisk_file where user_id='"+SessionUser.getCurrent().getActivatedEmployeeId() +"' and deleted=0 and in_recycle='N' and folder_id=?";
        String sql="";
        if(!StringUtil.isBlank(sample.getFdName())){
            fileSql=fileSql+" and file_name like '%"+sample.getFdName()+"%'";
        }
        if(NetdiskVirtualFdTypeEnum.FILE.code().equals(fdType)){
             sql=fileSql + " order by create_time desc";
        }else{
            sql= "select * from ("+ folderSql+" union all "+fileSql +" ) hz order by fd_type desc,create_time desc";
        }
        String countSql = "select count(1) cnt from (" + sql + ") end";
        Integer countVal = netdiskVirtualFdService.dao().queryRecord(countSql, currentId, currentId).getInteger("cnt");
        RcdSet rs = netdiskVirtualFdService.dao().query(sql, currentId, currentId);
        ArrayList<NetdiskVirtualFd> fdList = new ArrayList<>();
        for (int i = 0; i < rs.size(); i++) {
            NetdiskVirtualFd obj = new NetdiskVirtualFd();
            obj.setId(rs.getRcd(i).getString("id"));
            obj.setFdId(rs.getRcd(i).getString("fd_id"));
            obj.setFdName(rs.getRcd(i).getString("fd_name"));
            obj.setFdSize(rs.getRcd(i).getString("fd_size"));
            obj.setFdType(rs.getRcd(i).getString("fd_type"));
            obj.setFdHierarchy(rs.getRcd(i).getString("fd_hierarchy"));
            obj.setFdHierarchyName(rs.getRcd(i).getString("fd_hierarchy_name"));
            obj.setCreateTime(new Date());
            fdList.add(obj);
        }
        int pageCount=countVal%sample.getPageSize()>0?countVal/sample.getPageSize()+1:countVal/sample.getPageSize();
        PagedList<NetdiskVirtualFd> pageList = new PagedList<>(fdList, sample.getPageSize(), sample.getPageIndex(), pageCount, countVal);
        netdiskVirtualFdService.dao().fill(pageList).with(NetdiskVirtualFdMeta.NETDISK_ORIGIN_FILE).execute();
        Result<PagedList<NetdiskVirtualFd>> result = new Result<>();
        result.success(true).data(pageList);
        return result;
    }
}
