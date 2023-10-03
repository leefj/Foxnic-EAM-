package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.oa.NetdiskVirtualFdTypeEnum;
import com.dt.platform.domain.oa.NetdiskRecycle;
import com.dt.platform.oa.service.INetdiskFileService;
import com.dt.platform.oa.service.INetdiskFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.oa.NetdiskVirtualFd;
import com.dt.platform.domain.oa.NetdiskVirtualFdVO;
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
import com.dt.platform.oa.service.INetdiskVirtualFdService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 虚拟文件服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 21:00:45
*/


@Service("OaNetdiskVirtualFdService")
public class NetdiskVirtualFdServiceImpl extends SuperService<NetdiskVirtualFd> implements INetdiskVirtualFdService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private final DAO dao=null;

	@Autowired
	private INetdiskFolderService netdiskFolderService;


	@Autowired
	private INetdiskFileService netdiskFileService;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	@Override
	public Result downloadById(String id) {

		return ErrorDesc.success();
	}

	@Override
	public Result uploadFile(String id) {
		return null;
	}

	@Override
	public Result uploadFolder(String id) {
		return null;
	}


	@Override
	public Result batchDelete(String data) {

		List<String> folderIds=new ArrayList<>();
		List<String> fileIds=new ArrayList<>();
		JSONArray dataArr=JSONArray.parseArray(data);
		for(int i=0;i<dataArr.size();i++){
			JSONObject obj=dataArr.getJSONObject(i);
			if(NetdiskVirtualFdTypeEnum.FOLDER.code().equals(obj.getString("fdType"))){
				folderIds.add(obj.getString("fdId"));
			}else if(NetdiskVirtualFdTypeEnum.FILE.code().equals(obj.getString("fdType"))){
				fileIds.add(obj.getString("fdId"));
			}
		}
		if(fileIds.size()>0){
			netdiskFileService.batchDelete(fileIds);
		}
		if(folderIds.size()>0){
			netdiskFolderService.batchDelete(folderIds);
		}

		return ErrorDesc.success();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param netdiskVirtualFd  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(NetdiskVirtualFd netdiskVirtualFd,boolean throwsException) {
		Result r=super.insert(netdiskVirtualFd,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param netdiskVirtualFd 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(NetdiskVirtualFd netdiskVirtualFd) {
		return this.insert(netdiskVirtualFd,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param netdiskVirtualFdList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<NetdiskVirtualFd> netdiskVirtualFdList) {
		return super.insertList(netdiskVirtualFdList);
	}

	
	/**
	 * 按主键删除虚拟文件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		NetdiskVirtualFd netdiskVirtualFd = new NetdiskVirtualFd();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskVirtualFd.setId(id);
		try {
			boolean suc = dao.deleteEntity(netdiskVirtualFd);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除虚拟文件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		NetdiskVirtualFd netdiskVirtualFd = new NetdiskVirtualFd();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskVirtualFd.setId(id);
		netdiskVirtualFd.setDeleted(true);
		netdiskVirtualFd.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		netdiskVirtualFd.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(netdiskVirtualFd,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	@Override
	public Result rename(String id, String name,String type) {
		if(NetdiskVirtualFdTypeEnum.FOLDER.code().equals(type)){
			return netdiskFolderService.rename(id,name);
		}else if(NetdiskVirtualFdTypeEnum.FILE.code().equals(type)){
			return netdiskFileService.rename(id,name);
		}else{
			return ErrorDesc.failureMessage("当前类型未识别,类型:"+type);
		}
	}

	@Override
	public Result favourite(String id, String type) {
		if(NetdiskVirtualFdTypeEnum.FOLDER.code().equals(type)){
		 	dao.execute("update oa_netdisk_folder set is_favourite='N' where id=?",id);
		}else if(NetdiskVirtualFdTypeEnum.FILE.code().equals(type)){
			dao.execute("update oa_netdisk_file set is_favourite='N' where id=?",id);
		}else{
			return ErrorDesc.failureMessage("当前类型未识别,类型:"+type);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result favouriteCancel(String id, String type) {
		if(NetdiskVirtualFdTypeEnum.FOLDER.code().equals(type)){
			dao.execute("update oa_netdisk_folder set is_favourite='Y' where id=?",id);
		}else if(NetdiskVirtualFdTypeEnum.FILE.code().equals(type)){
			dao.execute("update oa_netdisk_file set is_favourite='Y' where id=?",id);
		}else{
			return ErrorDesc.failureMessage("当前类型未识别,类型:"+type);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result restoreFromRecycle(String id, String type) {
		return null;
	}

	@Override
	public Result move(String data, String folderId) {
		JSONArray dataArr=JSONArray.parseArray(data);
		List<String> idsList=new ArrayList<>();
		for(int i=0;i<dataArr.size();i++){
			JSONObject obj=dataArr.getJSONObject(i);
			String id=obj.getString("fdId");
			String type=obj.getString("fdType");
			if(NetdiskVirtualFdTypeEnum.FILE.code().equals(type)){
				idsList.add(id);
			}
			if(NetdiskVirtualFdTypeEnum.FOLDER.code().equals(type)){
				return ErrorDesc.failureMessage("请误选择文件夹，当前不支持文件夹的移动");
			}
		}
		if(idsList.size()>0){
			return netdiskFileService.move(idsList,folderId);
		}
	 	return ErrorDesc.success();
	}


	@Override
	public Result share(String data, List<String> userIds,String shareId) {
		if(userIds==null||userIds.size()==0){
			return ErrorDesc.failureMessage("请选择需要分享的用户");
		}
		JSONArray dataArr=JSONArray.parseArray(data);
		List<String> files=new ArrayList<>();
		List<String> folders=new ArrayList<>();
		for(int i=0;i<dataArr.size();i++){
			JSONObject obj=dataArr.getJSONObject(i);
			String fdId=obj.getString("fdId");
			String fdType=obj.getString("fdType");
			if(NetdiskVirtualFdTypeEnum.FILE.code().equals(fdType)){
				files.add(fdId);
			}
		}
		if(files.size()>0){
			netdiskFileService.share(files,userIds,shareId);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result delete(String id, String type) {
		if(NetdiskVirtualFdTypeEnum.FOLDER.code().equals(type)){
			return netdiskFolderService.delete(id);
		}else if(NetdiskVirtualFdTypeEnum.FILE.code().equals(type)){
			return netdiskFileService.delete(id);
		}else{
			return ErrorDesc.failureMessage("当前类型未识别,类型:"+type);
		}
	}
	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param netdiskVirtualFd 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskVirtualFd netdiskVirtualFd , SaveMode mode) {
		return this.update(netdiskVirtualFd,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param netdiskVirtualFd 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskVirtualFd netdiskVirtualFd , SaveMode mode,boolean throwsException) {
		Result r=super.update(netdiskVirtualFd , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param netdiskVirtualFdList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<NetdiskVirtualFd> netdiskVirtualFdList , SaveMode mode) {
		return super.updateList(netdiskVirtualFdList , mode);
	}

	
	/**
	 * 按主键更新虚拟文件
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
	 * 按主键获取虚拟文件
	 *
	 * @param id 主键
	 * @return NetdiskVirtualFd 数据对象
	 */
	public NetdiskVirtualFd getById(String id) {
		NetdiskVirtualFd sample = new NetdiskVirtualFd();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<NetdiskVirtualFd> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<NetdiskVirtualFd> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, NetdiskVirtualFd> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, NetdiskVirtualFd::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<NetdiskVirtualFd> queryList(NetdiskVirtualFdVO sample) {
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
	public PagedList<NetdiskVirtualFd> queryPagedList(NetdiskVirtualFdVO sample, int pageSize, int pageIndex) {
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
	public PagedList<NetdiskVirtualFd> queryPagedList(NetdiskVirtualFd sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param netdiskVirtualFd 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(NetdiskVirtualFd netdiskVirtualFd) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(netdiskVirtualFd, SYS_ROLE.NAME);
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