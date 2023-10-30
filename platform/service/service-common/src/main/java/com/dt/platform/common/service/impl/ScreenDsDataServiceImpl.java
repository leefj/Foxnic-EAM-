package com.dt.platform.common.service.impl;

import javax.annotation.Resource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.IScreenDsApiSService;
import com.dt.platform.common.service.IScreenDsApiService;
import com.dt.platform.constants.enums.common.ScreenDbTypeEnum;
import com.dt.platform.constants.enums.common.ScreenSourceEnum;
import com.dt.platform.domain.common.*;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.common.meta.ScreenDsDataMeta;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.sql.meta.DBType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
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
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import com.dt.platform.common.service.IScreenDsDataService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 数据源服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-27 13:03:14
*/


@Service("SysScreenDsDataService")

public class ScreenDsDataServiceImpl extends SuperService<ScreenDsData> implements IScreenDsDataService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	@Autowired
	private IScreenDsApiService screenDsApiService;

	@Autowired
	private IScreenDsApiSService screenDsApiSService;

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
	 * @param screenDsData  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(ScreenDsData screenDsData,boolean throwsException) {
		Result r=super.insert(screenDsData,throwsException);
		if(r.isSuccess()){
			List<String> idsList=screenDsData.getScreenDsApiIds();
			if(idsList!=null){
				for(int i=0;i<idsList.size();i++){
					ScreenDsApiS ScreenDsApiS=new ScreenDsApiS();
					ScreenDsApiS.setDsDataId(screenDsData.getId());
					ScreenDsApiS.setApiId(idsList.get(i));
					screenDsApiSService.insert(ScreenDsApiS);
				}
			}
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param screenDsData 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ScreenDsData screenDsData) {
		return this.insert(screenDsData,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param screenDsDataList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ScreenDsData> screenDsDataList) {
		return super.insertList(screenDsDataList);
	}

	
	/**
	 * 按主键删除数据源
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ScreenDsData screenDsData = new ScreenDsData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		screenDsData.setId(id);
		try {
			boolean suc = dao.deleteEntity(screenDsData);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除数据源
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ScreenDsData screenDsData = new ScreenDsData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		screenDsData.setId(id);
		screenDsData.setDeleted(true);
		screenDsData.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		screenDsData.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(screenDsData,SaveMode.NOT_NULL_FIELDS);
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
	 * @param screenDsData 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ScreenDsData screenDsData , SaveMode mode) {
		return this.update(screenDsData,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param screenDsData 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ScreenDsData screenDsData , SaveMode mode,boolean throwsException) {
		Result r=super.update(screenDsData , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from sys_screen_ds_api_s where ds_data_id=?",screenDsData.getId());
			List<String> idsList=screenDsData.getScreenDsApiIds();
			if(idsList!=null){
				for(int i=0;i<idsList.size();i++){
					ScreenDsApiS ScreenDsApiS=new ScreenDsApiS();
					ScreenDsApiS.setDsDataId(screenDsData.getId());
					ScreenDsApiS.setApiId(idsList.get(i));
					screenDsApiSService.insert(ScreenDsApiS);
				}
			}
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param screenDsDataList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ScreenDsData> screenDsDataList , SaveMode mode) {
		return super.updateList(screenDsDataList , mode);
	}

	
	/**
	 * 按主键更新数据源
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
	 * 按主键获取数据源
	 *
	 * @param id 主键
	 * @return ScreenDsData 数据对象
	 */
	public ScreenDsData getById(String id) {
		ScreenDsData sample = new ScreenDsData();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<ScreenDsData> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<ScreenDsData> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, ScreenDsData> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, ScreenDsData::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ScreenDsData> queryList(ScreenDsDataVO sample) {
		return super.queryList(sample);
	}

	@Override
	public Result<JSONObject> queryDataByCode(String code) {
		Result<JSONObject> res=new Result<>();
		ScreenDsDataVO vo=new ScreenDsDataVO();
		vo.setCode(code);
		ScreenDsData obj=this.queryEntity(vo);
		if(obj==null){
			return ErrorDesc.failureMessage("当前code不存在");
		}
		dao.fill(obj).with(ScreenDsDataMeta.SCREEN_DS_DB).with(ScreenDsDataMeta.SCREEN_DS_API).execute();
		if(ScreenSourceEnum.DB.code().equals(obj.getSourceCode())){
			ScreenDsDb db=obj.getScreenDsDb();
			if (db==null){
				return ErrorDesc.failureMessage("未正确选择数据库源");
			}
			DAO dataDao=null;
			if("user".equals(db.getType())){
				String type="";
				String driverName="";
				if(ScreenDbTypeEnum.MYSQL.code().equals(db.getDsType())){
					type="mysql"; //mysql 5.7
					driverName="com.mysql.jdbc.Driver";
				}
				dataDao=createDAO(type,driverName, db.getUri(), db.getUser(), db.getPwd());
			}else if("system".equals(db.getType())){
				dataDao=dao;
			}
			JSONObject rObj=new JSONObject();
			rObj.put("data",dataDao.query(obj.getCtText()).toJSONArrayWithJSONObject());
			res.data(rObj);

		}else if(ScreenSourceEnum.API.code().equals(obj.getSourceCode())){
			List<ScreenDsApi> apiList=obj.getScreenDsApi();
			if(apiList==null||apiList.size()==0){
				return ErrorDesc.failureMessage("未正确配置API源");
			}
			JSONObject rObj=new JSONObject();
			for(int i=0;i<apiList.size();i++){
				ScreenDsApi api=apiList.get(i);
				rObj.put(api.getCode(),screenDsApiService.queryDataById(api.getId()));
			}
			res.data(rObj);
		}
		res.success(true);
		return res;
	}
	private DAO createDAO(String type,String driverName, String url, String userName, String passwd) {
		Logger.info("create dao driver:"+driverName+",jdbc:"+url+",userName:"+userName);
		DAO newDao=null;
		DBType dbType=DBType.parseFromURL(url);
		if("oracle".equals(type)){
			dbType=DBType.ORACLE;
		}else if("db2".equals(type)){
			dbType=DBType.DB2;
		}else if("mysql".equals(type)){
			dbType=DBType.MYSQL;
		}else if("sqlserver".equals(type)){
			dbType=DBType.SQLSVR;
		}else if("pg".equals(type)){
			dbType=DBType.PG;
		}
		if(dbType==null){
			dbType=DBType.parseFromURL(url);
		}
		if(dbType==null){
			dbType=DBType.parseFromDriver(url);
		}
		if(dbType==null){
			Logger.info("dbType is null");
			return null;
		}
		Logger.info("dbType:"+dbType.getDAOType());
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(passwd);
		dataSource.setMaxActive(2);
		dataSource.setPhyMaxUseCount(2L);
		dataSource.setPhyMaxUseCount(2L);
		dataSource.setMaxWait(3000L);
		dataSource.setConnectionErrorRetryAttempts(2);
		dataSource.setBreakAfterAcquireFailure(true);
		if(dbType==DBType.ORACLE) {
			// mysql 关闭，Oracle 建议开启
			dataSource.setPoolPreparedStatements(true);
		}
		DAOBuilder builder=new DAOBuilder();
		try {
			newDao=builder.datasource(dataSource).build();
			newDao.setPrintSQL(true);
			newDao.setPrintSQLSimple(true);
			newDao.setPrintSQLCallstack(false);
			return newDao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
	public PagedList<ScreenDsData> queryPagedList(ScreenDsDataVO sample, int pageSize, int pageIndex) {
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
	public PagedList<ScreenDsData> queryPagedList(ScreenDsData sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param screenDsData 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(ScreenDsData screenDsData) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(screenDsData, SYS_ROLE.NAME);
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