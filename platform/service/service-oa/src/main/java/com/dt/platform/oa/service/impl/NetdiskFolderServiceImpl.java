package com.dt.platform.oa.service.impl;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;

import com.dt.platform.constants.enums.oa.NetDiskRootEnum;
import com.dt.platform.constants.enums.oa.NetdiskVirtualFdTypeEnum;
import com.dt.platform.domain.oa.NetdiskRecycle;
import com.dt.platform.oa.service.INetdiskRecycleService;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;


import com.dt.platform.domain.oa.NetdiskFolder;
import com.dt.platform.domain.oa.NetdiskFolderVO;

import java.util.ArrayList;
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
import com.dt.platform.oa.service.INetdiskFolderService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 文件夹服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 10:20:03
*/


@Service("OaNetdiskFolderService")

public class NetdiskFolderServiceImpl extends SuperService<NetdiskFolder> implements INetdiskFolderService {



	@Autowired
	private INetdiskRecycleService netdiskRecycleService;

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
	 * @param netdiskFolder  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(NetdiskFolder netdiskFolder,boolean throwsException) {
		Result r=super.insert(netdiskFolder,throwsException);
		return r;
	}

	@Override
	public Result createFolder(String parentId, String name) {
		String id=IDGenerator.getSnowflakeIdString();
		String hierarchy="";
		String hierarchyName="";
		if(StringUtil.isBlank(name)){
			return ErrorDesc.failureMessage("文件夹不能为空");
		}
		if(StringUtil.isBlank(parentId)||parentId.equals(NetDiskRootEnum.SPACE.code())){
			hierarchy=id;
			hierarchyName=name;
			parentId= NetDiskRootEnum.SPACE.code();
		}else{
			Rcd rs= dao.queryRecord("select * from oa_netdisk_folder where id=? and user_id=?",parentId,SessionUser.getCurrent().getActivatedEmployeeId());
			if(rs==null){
				return ErrorDesc.failureMessage("父文件夹不存在,父文件夹编号:"+parentId);
			}
			hierarchy=rs.getString("hierarchy")+"-"+id;
			hierarchyName=rs.getString("hierarchy_name")+"/"+name;
		}
		NetdiskFolder folder=new NetdiskFolder();
		folder.setId(id);
		folder.setName(name);
		folder.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		folder.setParentId(parentId);
		folder.setHierarchy(hierarchy);
		folder.setHierarchyName(hierarchyName);
		this.insert(folder,false);
		return ErrorDesc.success();
	}

	@Override
	public Result rename(String id, String name) {
		if(StringUtil.isBlank(name)){
			return ErrorDesc.failureMessage("名称不能为空");
		}
		if(StringUtil.isBlank(id)){
			return ErrorDesc.failureMessage("ID不能为空");
		}
		dao.execute("update oa_netdisk_folder set name=? where id=?",name,id);
		updateHierarchy(id);
		return ErrorDesc.success();
	}


	public Result updateHierarchy(String id) {
		Rcd category_rs = dao.queryRecord("select id,name name,hierarchy from oa_netdisk_folder where deleted=0 and id=?", id);
		String hierarchy=category_rs.getString("hierarchy");
		String split="-";
		String afterHierarchyName="";
		String[] ids = hierarchy.split(split);
		for (int i = 0; i < ids.length;i++) {
			afterHierarchyName = afterHierarchyName + split+ dao.queryRecord("select name name from oa_netdisk_folder where deleted=0 and id=?", ids[i]).getString("name");
		}
		afterHierarchyName = afterHierarchyName.replaceFirst(split, "");
		Update ups = new Update("oa_netdisk_folder");
		ups.set("hierarchy_name", afterHierarchyName);
		ups.where().and("id=?", id);
		dao.execute(ups);
		RcdSet rds = dao.query("select id,name name,hierarchy from oa_netdisk_folder where deleted=0 and parent_id=?", id);
		for (int j = 0; j < rds.size(); j++) {
			updateHierarchy(rds.getRcd(j).getString("id"));
		}
		Result r=new Result();
		r.success(true);
		r.message(CommonError.SUCCESS_TEXT);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param netdiskFolder 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(NetdiskFolder netdiskFolder) {
		return this.insert(netdiskFolder,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param netdiskFolderList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<NetdiskFolder> netdiskFolderList) {
		return super.insertList(netdiskFolderList);
	}

	
	/**
	 * 按主键删除文件夹
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {

		NetdiskFolder netdiskFolder = new NetdiskFolder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskFolder.setId(id);


		//判断是否还有文件夹
		if(dao.queryRecord("select count(1) cnt from oa_netdisk_folder where deleted=0 and parent_id=?",id).getInteger("cnt")>0){
			return ErrorDesc.failureMessage("存在子目录，不允许删除");
		}

		//判断是否还有文件
		if(dao.queryRecord("select count(1) cnt from oa_netdisk_file where deleted=0 and folder_id=?",id).getInteger("cnt")>0){
			return ErrorDesc.failureMessage("本目录还存在文件，不允许删除");
		}

		try {
			boolean suc = dao.deleteEntity(netdiskFolder);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	@Override
	public Result share(List<String> ids, List<String> userIds) {
		return null;
	}

	@Override
	public Result restoreFromRecycle(String id) {
		dao.execute("delete from oa_netdisk_recycle where fd_id=? and fd_type=?",id,NetdiskVirtualFdTypeEnum.FOLDER.code());
		dao.execute("update oa_netdisk_folder set in_recycle='N' where id=?",id);
		dao.execute("update oa_netdisk_folder set in_recycle='N' where hierarchy like '%"+id+"-%'");
		return ErrorDesc.success();
	}

	@Override
	public Result batchRestoreFromRecycle(List<String> ids) {
		for(int i=0;i<ids.size();i++){
			restoreFromRecycle(ids.get(i));
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

		NetdiskFolder netdiskFolder=this.getById(id);
		dao.execute("update oa_netdisk_folder set in_recycle='Y' where id=?",id);
		dao.execute("update oa_netdisk_folder set in_recycle='Y' where hierarchy like '%"+id+"-%'");

		NetdiskRecycle netdiskRecycle=new NetdiskRecycle();
		netdiskRecycle.setFdId(id);
		netdiskRecycle.setDelTime(new Date());
		netdiskRecycle.setFdType(NetdiskVirtualFdTypeEnum.FOLDER.code());
		netdiskRecycle.setUserId(netdiskFolder.getUserId());
		netdiskRecycleService.insert(netdiskRecycle,false);
		return ErrorDesc.success();
	}

	/**
	 * 按主键删除文件夹
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {

		NetdiskFolder netdiskFolder = new NetdiskFolder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		netdiskFolder.setId(id);
		netdiskFolder.setDeleted(true);
		netdiskFolder.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		netdiskFolder.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(netdiskFolder,SaveMode.NOT_NULL_FIELDS);
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
	 * @param netdiskFolder 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskFolder netdiskFolder , SaveMode mode) {
		return this.update(netdiskFolder,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param netdiskFolder 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NetdiskFolder netdiskFolder , SaveMode mode,boolean throwsException) {
		Result r=super.update(netdiskFolder , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param netdiskFolderList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<NetdiskFolder> netdiskFolderList , SaveMode mode) {
		return super.updateList(netdiskFolderList , mode);
	}

	
	/**
	 * 按主键更新文件夹
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
	 * 按主键获取文件夹
	 *
	 * @param id 主键
	 * @return NetdiskFolder 数据对象
	 */
	public NetdiskFolder getById(String id) {
		NetdiskFolder sample = new NetdiskFolder();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<NetdiskFolder> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<NetdiskFolder> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, NetdiskFolder> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, NetdiskFolder::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<NetdiskFolder> queryList(NetdiskFolderVO sample) {
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
	public PagedList<NetdiskFolder> queryPagedList(NetdiskFolderVO sample, int pageSize, int pageIndex) {
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
	public PagedList<NetdiskFolder> queryPagedList(NetdiskFolder sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	@Override
	public PagedList<NetdiskFolder> queryMyFolderPagedList(NetdiskFolder sample, int pageSize, int pageIndex) {


		NetdiskRecycle q=new NetdiskRecycle();
		q.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		q.setFdType(NetdiskVirtualFdTypeEnum.FOLDER.code());
		List<NetdiskRecycle> folders=netdiskRecycleService.queryList(q);
		ConditionExpr expr=new ConditionExpr();
		expr.and("1=1");
		if(folders!=null&&folders.size()>0){
			for(int i=0;i<folders.size();i++){
				expr.and("hierarchy not like '"+folders.get(i).getFdId()+"%'");
			}
		}
		OrderBy order=new OrderBy();
		order.desc("hierarchy_name");
		sample.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		return super.queryPagedList(sample, expr,order, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param netdiskFolder 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(NetdiskFolder netdiskFolder) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(netdiskFolder, SYS_ROLE.NAME);
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