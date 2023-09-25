package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;
import javax.websocket.Session;

import com.dt.platform.constants.enums.oa.NetDiskShareExpirationMethodEnum;
import com.dt.platform.constants.enums.oa.NetDiskShareStatusEnum;
import com.dt.platform.constants.enums.oa.NetDiskShareTypeEnum;
import com.dt.platform.constants.enums.oa.NetdiskVirtualFdTypeEnum;
import com.dt.platform.domain.oa.*;
import com.dt.platform.oa.service.*;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.text.DecimalFormat;
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
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;
import com.alibaba.fastjson.JSONArray;

/**
 * <p>
 * 文件服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:19:47
*/


@Service("OaNetdiskFileService")

public class NetdiskFileServiceImpl extends SuperService<NetdiskFile> implements INetdiskFileService {


	@Autowired
	private INetdiskRecycleService netdiskRecycleService;

	@Autowired
	private INetdiskOriginFileService netdiskOriginFileService;

	@Autowired
	private INetdiskShareMeService  netdiskShareMeService;

	@Autowired
	private INetdiskMyShareService netdiskMyShareService;

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
	 * @param netdiskFile  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(NetdiskFile netdiskFile,boolean throwsException) {
		Result r=super.insert(netdiskFile,throwsException);
		return r;
	}

	@Override
	public Result uploadFilesInfo(String fileIds,String fdId) {
		JSONArray fileIdsArr=JSONArray.parseArray(fileIds);
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		for(int i=0;i<fileIdsArr.size();i++){
			NetdiskOriginFile originFile=netdiskOriginFileService.getById(fileIdsArr.getString(i));
			NetdiskFile netdiskFile=new NetdiskFile();
			netdiskFile.setOriginFileId(fileIdsArr.getString(i));
			netdiskFile.setFileName(originFile.getFileName());
			Long fileSize=originFile.getFileSize();
			String fileSizeValue="";
			if(fileSize<1024L){
				fileSizeValue=originFile.getFileSize()+"B";
			}else if(fileSize>=1024L&&fileSize<1024L*1024L){
				Double d=(originFile.getFileSize()/(double)1024);
				fileSizeValue=decimalFormat.format(d)+"KB";
			}else if(fileSize>=1024L*1024L&&fileSize<1024L*1024L*1024L){
				Double d=originFile.getFileSize()/((double)(1024*1024));
				fileSizeValue=decimalFormat.format(d)+"M";
			}else if(fileSize>=1024L*1024L*1024L&&fileSize<1024L*1024L*1024L*1024L){
				Double d=originFile.getFileSize()/((double)(1024/1024/1024));
				fileSizeValue=decimalFormat.format(d)+"G";
			}else{
				Double d=originFile.getFileSize()/((double)(1024*1024*1024));
				fileSizeValue=decimalFormat.format(d)+"G";
			}
			netdiskFile.setFileSize(fileSizeValue);
			netdiskFile.setFileType(originFile.getFileType());
			netdiskFile.setFolderId(fdId);
			netdiskFile.setInRecycle("N");
			netdiskFile.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
			this.insert(netdiskFile);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result batchDelete(List<String> ids) {
		for(int i=0;i<ids.size();i++){
			delete(ids.get(i));
		}
		return ErrorDesc.success();
	}

	@Override
	public Result delete(String id) {
		dao.execute("update oa_netdisk_file set in_recycle='Y' where id=?",id);
		NetdiskFile file=this.getById(id);
		NetdiskRecycle netdiskRecycle=new NetdiskRecycle();
		netdiskRecycle.setFdId(id);
		netdiskRecycle.setDelTime(new Date());
		netdiskRecycle.setUserId(file.getUserId());
		netdiskRecycle.setFdType(NetdiskVirtualFdTypeEnum.FILE.code());
		netdiskRecycleService.insert(netdiskRecycle,false);
		return ErrorDesc.success();
	}

	@Override
	public Result rename(String id, String name) {
		if(StringUtil.isBlank(name)){
			return ErrorDesc.failureMessage("名称不能为空");
		}
		NetdiskFile file=this.getById(id);
		dao.execute("update oa_netdisk_file set file_name=? where id=?",name,id);
		dao.execute("update oa_netdisk_origin_file set file_name=? where id=?",name,file.getOriginFileId());
		return ErrorDesc.success();
	}

	@Override
	public Result share(List<String> ids, List<String> userIds,String shareId) {
		if(userIds==null||userIds.size()==0){
			return ErrorDesc.failureMessage("请选择需要分享的用户");
		}
		if(ids==null||ids.size()==0){
			return ErrorDesc.failureMessage("请选择需要的文件");
		}
		for(int i=0;i<ids.size();i++){
			shareFile(ids.get(i),userIds,shareId);
		}
		return ErrorDesc.success();
	}

	public Result shareFile(String id, List<String> userIds,String shareId) {

		if(userIds==null||userIds.size()==0){
			return ErrorDesc.failureMessage("请选择需要分享的用户");
		}
		if(StringUtil.isBlank(id)){
			return ErrorDesc.failureMessage("请选择需要的文件");
		}
		//判断,当前只实现内部分享方式，不支持外链，只需要判断内部
		boolean isNew=false;
		if(StringUtil.isBlank(shareId)){
			NetdiskMyShare share=new NetdiskMyShare();
			share.setFileId(id);
			share.setExpirationMethod(NetDiskShareExpirationMethodEnum.NO_EXPIRATION.code());
			share.setStatus(NetDiskShareStatusEnum.VALID.code());
			share.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
			share.setType(NetDiskShareTypeEnum.IN.code());
			netdiskMyShareService.insert(share,false);
			shareId=share.getId();
			isNew=true;
		}
		for(int i=0;i<userIds.size();i++){
			//目前分享模式为简单模式
			if(!isNew){
				Rcd rs=dao.queryRecord("select 1 from oa_netdisk_share_me where deleted=0 and share_id=? and user_id=? and file_id=?",shareId,userIds.get(i),id);
				if(rs!=null){
					continue;
				}
			}
			NetdiskShareMe shareMe=new NetdiskShareMe();
			shareMe.setFileId(id);
			shareMe.setUserId(userIds.get(i));
			shareMe.setOwnerUserId(SessionUser.getCurrent().getActivatedEmployeeId());
			shareMe.setShareId(shareId);
			netdiskShareMeService.insert(shareMe,false);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result restoreFromRecycle(String id) {
		dao.execute("update oa_netdisk_file set in_recycle='N' where id=?",id);
		dao.execute("delete from oa_netdisk_recycle where fd_id=? and fd_type=?",id,NetdiskVirtualFdTypeEnum.FILE.code());
		return ErrorDesc.success();
	}

	@Override
	public Result batchRestoreFromRecycle(List<String> ids) {
		for(int i=0;i<ids.size();i++){
			restoreFromRecycle(ids.get(i));
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param netdiskFile 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(NetdiskFile netdiskFile) {
		return this.insert(netdiskFile,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param netdiskFileList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<NetdiskFile> netdiskFileList) {
		return super.insertList(netdiskFileList);
	}

	
	/**
	 * 按主键删除文件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		NetdiskFile netdiskFile = new NetdiskFile();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskFile.setId(id);
		try {
			boolean suc = dao.deleteEntity(netdiskFile);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除文件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		NetdiskFile netdiskFile = new NetdiskFile();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskFile.setId(id);
		netdiskFile.setDeleted(true);
		netdiskFile.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		netdiskFile.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(netdiskFile,SaveMode.NOT_NULL_FIELDS);
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
	 * @param netdiskFile 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskFile netdiskFile , SaveMode mode) {
		return this.update(netdiskFile,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param netdiskFile 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskFile netdiskFile , SaveMode mode,boolean throwsException) {
		Result r=super.update(netdiskFile , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param netdiskFileList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<NetdiskFile> netdiskFileList , SaveMode mode) {
		return super.updateList(netdiskFileList , mode);
	}

	
	/**
	 * 按主键更新文件
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
	 * 按主键获取文件
	 *
	 * @param id 主键
	 * @return NetdiskFile 数据对象
	 */
	public NetdiskFile getById(String id) {
		NetdiskFile sample = new NetdiskFile();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<NetdiskFile> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<NetdiskFile> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, NetdiskFile> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, NetdiskFile::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<NetdiskFile> queryList(NetdiskFileVO sample) {
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
	public PagedList<NetdiskFile> queryPagedList(NetdiskFileVO sample, int pageSize, int pageIndex) {
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
	public PagedList<NetdiskFile> queryPagedList(NetdiskFile sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param netdiskFile 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(NetdiskFile netdiskFile) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(netdiskFile, SYS_ROLE.NAME);
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