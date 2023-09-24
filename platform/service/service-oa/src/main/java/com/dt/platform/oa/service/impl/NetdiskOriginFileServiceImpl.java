package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dt.platform.constants.enums.oa.NetDiskEncryptedEnum;
import com.dt.platform.constants.enums.oa.NetDiskFileTypeEnum;
import com.dt.platform.constants.enums.oa.NetDiskStoragTypeEnum;
import com.dt.platform.oa.service.INetdiskStoreDataService;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.FileCatalog;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;


import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.domain.oa.NetdiskOriginFileVO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.dt.platform.oa.service.INetdiskOriginFileService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 源文件服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 15:18:14
 */


@Service("OaNetdiskOriginFileService")

public class NetdiskOriginFileServiceImpl extends SuperService<NetdiskOriginFile> implements INetdiskOriginFileService {



	@Autowired
	private NetdiskStoreDataDiskServiceImpl netdiskStoreDiskServiceImpl;


	@Autowired
	private NetdiskStoreDataMinioServiceImpl netdiskStoreDataMinioServiceImpl;


	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private final DAO dao=null;

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
	 * @param netdiskOriginFile  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(NetdiskOriginFile netdiskOriginFile,boolean throwsException) {
		Result r=super.insert(netdiskOriginFile,throwsException);
		return r;
	}


	@Override
	public NetdiskOriginFile uploadFile(MultipartFile multipartFile, String dir) {
		NetdiskOriginFile fileinfo=new NetdiskOriginFile();
		fileinfo.setDownloadCount(0L);
		fileinfo.setMediaType(multipartFile.getContentType());
//		//获取源文件名称
		String originalFileName = multipartFile.getOriginalFilename();
//		//获取文件后缀
		String extension = FileUtil.getExtName(originalFileName);
		if(extension.toLowerCase().endsWith("png")
				||extension.toLowerCase().equals(".jpg")
				||extension.toLowerCase().equals("jpeg")
				||extension.toLowerCase().equals("bmp")
				||extension.toLowerCase().equals("jpg")
				||extension.toLowerCase().equals("tif")
		){
			fileinfo.setFileType(NetDiskFileTypeEnum.FILE_PHOTO.code());
		}else if(extension.toLowerCase().equals("tar")
				||extension.toLowerCase().equals("7z")
				||extension.toLowerCase().equals("rar")
				||extension.toLowerCase().equals("gz")
				||extension.toLowerCase().equals("z")
				||extension.toLowerCase().equals("xz")
				||extension.toLowerCase().equals("compress")){
			fileinfo.setFileType(NetDiskFileTypeEnum.FILE_ZIP.code());
		}else if(extension.toLowerCase().equals("mp3")
				||extension.toLowerCase().equals("wav")
				||extension.toLowerCase().equals("mdi")
				||extension.toLowerCase().equals("flac")
				||extension.toLowerCase().equals("ape")
				||extension.toLowerCase().equals("alac")
				||extension.toLowerCase().equals("aac")
				||extension.toLowerCase().equals("ogg")
				||extension.toLowerCase().equals("m4a")
				||extension.toLowerCase().equals("mpa")
		){
			fileinfo.setFileType(NetDiskFileTypeEnum.FILE_MUSIC.code());
		}else if(extension.toLowerCase().equals("doc")
				||extension.toLowerCase().equals("docx")
				||extension.toLowerCase().equals("xls")
				||extension.toLowerCase().equals("xlt")
				||extension.toLowerCase().equals("xml")
				||extension.toLowerCase().equals("rtf")
				||extension.toLowerCase().equals("ppt")
				||extension.toLowerCase().equals("txt")
				||extension.toLowerCase().equals("pdf")
				||extension.toLowerCase().equals("sh")
				||extension.toLowerCase().equals("sql")
				||extension.toLowerCase().equals("pptx")
				||extension.toLowerCase().equals("xlsm")
				||extension.toLowerCase().equals("xlsx")
		){
			fileinfo.setFileType(NetDiskFileTypeEnum.FILE_DOC.code());
		}else if(extension.toLowerCase().equals("mp4")
				||extension.toLowerCase().equals("avi")
				||extension.toLowerCase().equals("mkv")
				||extension.toLowerCase().equals("wmv")
				||extension.toLowerCase().equals("mpeg")
				||extension.toLowerCase().equals("rmvb")
				||extension.toLowerCase().equals("rm")
				||extension.toLowerCase().equals("vob")
				||extension.toLowerCase().equals("3gp")
		){
			fileinfo.setFileType(NetDiskFileTypeEnum.FILE_VIDEO.code());
		}else{
			fileinfo.setFileType(NetDiskFileTypeEnum.FILE_OTHER.code());
		}
		fileinfo.setEncrypted(NetDiskEncryptedEnum.N.code());
		fileinfo.setExtValue(extension);
		fileinfo.setFileName(originalFileName);
		fileinfo.setFileSize(multipartFile.getSize());
		fileinfo.setReferenceCount(0);
		if(SessionUser.getCurrent()!=null&&SessionUser.getCurrent().getActivatedEmployeeId()!=null){
			fileinfo.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		}
		fileinfo=this.getStorageSupport(fileinfo).write(fileinfo,multipartFile,dir);
		this.insert(fileinfo);
		return fileinfo;
	}

	private void resurgence(String fileId,boolean dowloads) {
		resurgence(Arrays.asList(fileId),dowloads);
	}
	/**
	 * 登记文件访问情况
	 * */
	private void resurgence(List<String> fileIds,boolean dowloads) {
		Update update=dao().update(this.table())
				.set("last_visit_time",new Date()).where().andIn("id",fileIds).top();
		if(dowloads) {
			update.setExpr("download_count","download_count+1");
		}

		update.execute();
	}


	public byte[] getBytes(NetdiskOriginFile fileInfo) {
		byte[] bytes=null;
		try {
			bytes=this.getStorageSupport(fileInfo).read(fileInfo);
		} catch (Exception e) {
			Logger.error("文件读取失败,fileId="+fileInfo.getId());
		}
		return bytes;
	}
	@Override
	public void downloadFile(String id, Boolean inline, HttpServletResponse response) {

		NetdiskOriginFile fileInfo=this.getById(id);
		Result result=null;
		if(fileInfo==null) {
			Logger.error("文件不存在");
			result= ErrorDesc.failure(CommonError.DATA_NOT_EXISTS).message("file is not exists");
		}
		byte[] bytes=null;
		try {
			if(fileInfo!=null) {
				resurgence(fileInfo.getId(),true);
				// 如果有下载地址，做一个重定向
				if(!StringUtil.isBlank(fileInfo.getDownloadUrl())) {
					response.sendRedirect(fileInfo.getDownloadUrl());
				} else {
					bytes = this.getBytes(fileInfo);
					if (bytes == null) {
						result = ErrorDesc.failure(CommonError.FILE_INVALID).message("file read error");
					} else {
						DownloadUtil.writeToOutput(response, bytes, fileInfo.getFileName(), null, inline ? DownloadUtil.DownloadMode.INLINE : DownloadUtil.DownloadMode.ATTACHMENT);
					}
				}
			}
		} catch (Exception e) {
			Logger.error("文件下载失败 , fileId="+fileInfo.getId());
			result= ErrorDesc.failure(CommonError.FILE_INVALID).message(e.getMessage());
		}

		if(result!=null) {
			try {
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(JSON.toJSONString(result));
			} catch (IOException e) {
				Logger.error("下载失败，输出异常 , fileId="+fileInfo.getId());
			}
		}


	}

	public INetdiskStoreDataService getStorageSupport(NetdiskOriginFile fileinfo){
		String storageType=fileinfo.getStorageType();
		if(StringUtil.isBlank(storageType)){
			fileinfo.setStorageType(NetDiskStoragTypeEnum.DISK.code());
			return netdiskStoreDiskServiceImpl;
		}else{
			if(NetDiskStoragTypeEnum.DISK.code().equals(storageType)){
				return netdiskStoreDiskServiceImpl;
			}else if(NetDiskStoragTypeEnum.MINIO.code().equals(storageType)){
				return netdiskStoreDataMinioServiceImpl;
			}else{
				return netdiskStoreDiskServiceImpl;
			}
		}
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param netdiskOriginFile 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(NetdiskOriginFile netdiskOriginFile) {
		return this.insert(netdiskOriginFile,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param netdiskOriginFileList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<NetdiskOriginFile> netdiskOriginFileList) {
		return super.insertList(netdiskOriginFileList);
	}


	/**
	 * 按主键删除源文件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		NetdiskOriginFile netdiskOriginFile = new NetdiskOriginFile();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskOriginFile.setId(id);
		try {
			boolean suc = dao.deleteEntity(netdiskOriginFile);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除源文件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		NetdiskOriginFile netdiskOriginFile = new NetdiskOriginFile();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskOriginFile.setId(id);
		netdiskOriginFile.setDeleted(true);
		netdiskOriginFile.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		netdiskOriginFile.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(netdiskOriginFile,SaveMode.NOT_NULL_FIELDS);
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
	 * @param netdiskOriginFile 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskOriginFile netdiskOriginFile , SaveMode mode) {
		return this.update(netdiskOriginFile,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param netdiskOriginFile 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskOriginFile netdiskOriginFile , SaveMode mode,boolean throwsException) {
		Result r=super.update(netdiskOriginFile , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param netdiskOriginFileList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<NetdiskOriginFile> netdiskOriginFileList , SaveMode mode) {
		return super.updateList(netdiskOriginFileList , mode);
	}


	/**
	 * 按主键更新源文件
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
	 * 按主键获取源文件
	 *
	 * @param id 主键
	 * @return NetdiskOriginFile 数据对象
	 */
	public NetdiskOriginFile getById(String id) {
		NetdiskOriginFile sample = new NetdiskOriginFile();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<NetdiskOriginFile> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<NetdiskOriginFile> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, NetdiskOriginFile> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, NetdiskOriginFile::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<NetdiskOriginFile> queryList(NetdiskOriginFileVO sample) {
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
	public PagedList<NetdiskOriginFile> queryPagedList(NetdiskOriginFileVO sample, int pageSize, int pageIndex) {
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
	public PagedList<NetdiskOriginFile> queryPagedList(NetdiskOriginFile sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param netdiskOriginFile 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(NetdiskOriginFile netdiskOriginFile) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(netdiskOriginFile, SYS_ROLE.NAME);
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