package com.dt.platform.common.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.network.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.util.*;


import com.dt.platform.domain.common.ScreenDsApi;
import com.dt.platform.domain.common.ScreenDsApiVO;
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
import com.dt.platform.common.service.IScreenDsApiService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * API服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 07:47:30
*/


@Service("SysScreenDsApiService")

public class ScreenDsApiServiceImpl extends SuperService<ScreenDsApi> implements IScreenDsApiService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

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
	 * @param screenDsApi  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(ScreenDsApi screenDsApi,boolean throwsException) {
		Result r=super.insert(screenDsApi,throwsException);
		return r;
	}

	@Override
	public Result<JSONObject> queryDataById(String id) {
		Result<JSONObject> res=new Result<>();
		res.success(true);
		JSONObject resObj=new JSONObject();
		ScreenDsApi api=this.getById(id);
		HashMap<String,String> headerMap=null;
		HashMap<String,String> paramMap=null;
		String postMethod="param";
		//获取header{key:value,key2:value2}
		String header=api.getHeader();
		if(!StringUtil.isBlank(header)){
			JSONObject headerObj=JSONObject.parseObject(header);
			if(headerObj!=null){
				Iterator<String> keys= headerObj.keySet().iterator();
				while(keys.hasNext()){
					String key=keys.next();
					String value=headerObj.getString(key);
					if(headerMap==null){
						headerMap=new HashMap<>();
					}
					headerMap.put(key,value);
					if("Content-Type".equals(key)&&"application/json".equals(value)){
						postMethod="json";
					}
				}
			}
		}
		String param=api.getParam();
		if(!StringUtil.isBlank(param)){
			JSONObject paramObj=JSONObject.parseObject(param);
			if(paramObj!=null){
				Iterator<String> keys= paramObj.keySet().iterator();
				while(keys.hasNext()){
					String key=keys.next();
					String value=paramObj.getString(key);
					if(paramMap==null){
						paramMap=new HashMap<>();
					}
					paramMap.put(key,value);
				}
			}
		}
		String body=api.getBody();
		String reqType=api.getReqType();
		String url=api.getUrl();
		ScreenApiHttpClient client=new ScreenApiHttpClient();
		Logger.info("url:"+url);
		Logger.info("param:"+paramMap);
		Logger.info("header:"+headerMap);
		String reqRes="none";
		if("get".equals(reqType)){
			try {
				reqRes=client.get(url,paramMap,headerMap,HttpClient.UTF_8);
				resObj.put("result",reqRes);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("post".equals(reqType)){
			try {
				if("param".equals(postMethod)){
					Logger.info("post method:post");
					reqRes=client.post(url,paramMap,headerMap,HttpClient.UTF_8);
				}else if("json".equals(postMethod)){
					if(StringUtil.isBlank(body)){
						Logger.info("post method:post");
						reqRes=client.post(url,paramMap,headerMap,HttpClient.UTF_8);
					}else{
						Logger.info("post method:postMap");
						reqRes=client.postMap(url,body,headerMap);
					}
				}
				resObj.put("result",reqRes);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Logger.info("reqRes:"+reqRes);
		resObj.put("result",reqRes);
		res.data(resObj);
		return res;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param screenDsApi 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ScreenDsApi screenDsApi) {
		return this.insert(screenDsApi,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param screenDsApiList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ScreenDsApi> screenDsApiList) {
		return super.insertList(screenDsApiList);
	}

	
	/**
	 * 按主键删除API
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ScreenDsApi screenDsApi = new ScreenDsApi();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		screenDsApi.setId(id);
		try {
			boolean suc = dao.deleteEntity(screenDsApi);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除API
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ScreenDsApi screenDsApi = new ScreenDsApi();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		screenDsApi.setId(id);
		screenDsApi.setDeleted(true);
		screenDsApi.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		screenDsApi.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(screenDsApi,SaveMode.NOT_NULL_FIELDS);
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
	 * @param screenDsApi 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ScreenDsApi screenDsApi , SaveMode mode) {
		return this.update(screenDsApi,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param screenDsApi 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ScreenDsApi screenDsApi , SaveMode mode,boolean throwsException) {
		Result r=super.update(screenDsApi , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param screenDsApiList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ScreenDsApi> screenDsApiList , SaveMode mode) {
		return super.updateList(screenDsApiList , mode);
	}

	
	/**
	 * 按主键更新API
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
	 * 按主键获取API
	 *
	 * @param id 主键
	 * @return ScreenDsApi 数据对象
	 */
	public ScreenDsApi getById(String id) {
		ScreenDsApi sample = new ScreenDsApi();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<ScreenDsApi> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<ScreenDsApi> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, ScreenDsApi> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, ScreenDsApi::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ScreenDsApi> queryList(ScreenDsApiVO sample) {
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
	public PagedList<ScreenDsApi> queryPagedList(ScreenDsApiVO sample, int pageSize, int pageIndex) {
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
	public PagedList<ScreenDsApi> queryPagedList(ScreenDsApi sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param screenDsApi 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(ScreenDsApi screenDsApi) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(screenDsApi, SYS_ROLE.NAME);
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