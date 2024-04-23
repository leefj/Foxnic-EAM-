package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.WarehouseVO;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.eam.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.eam.WarehousePosition;
import com.dt.platform.domain.eam.WarehousePositionVO;
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
import com.dt.platform.eam.service.IWarehousePositionService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 仓库库位服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-18 07:22:00
*/


@Service("EamWarehousePositionService")

public class WarehousePositionServiceImpl extends SuperService<WarehousePosition> implements IWarehousePositionService {


	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;


	@Autowired
	private IWarehouseService warehouseService;

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
	 * @param warehousePosition  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(WarehousePosition warehousePosition,boolean throwsException) {


		Result r=super.insert(warehousePosition,throwsException);
		if(r.isSuccess()){
			dao.execute("update eam_warehouse_position a,eam_warehouse b set a.full_name=concat(b.warehouse_name,'/',a.name) where a.warehouse_id=b.id and a.id=?",warehousePosition.getId());
		}
		return r;
	}

	@Override
	public JSONArray queryTreeData(String id,String method) {
		JSONArray result=new JSONArray();
		List<Warehouse> list= warehouseService.queryList(new WarehouseVO());
		dao.fill(list).with(WarehouseMeta.WAREHOUSE_POSITION_LIST).execute();
		for(int i=0;i<list.size();i++) {
			Warehouse warehouse = list.get(i);
			JSONObject data = new JSONObject();
			data.put("name", warehouse.getWarehouseName());
			data.put("id", warehouse.getId());
			data.put("pid", "root");
			data.put("checked", "true");
			data.put("type", "warehouse");
			List<WarehousePosition> posList = warehouse.getWarehousePositionList();
			JSONArray children = new JSONArray();
			if (posList.size() > 0) {
				for (int j = 0; j < posList.size(); j++) {
					WarehousePosition pos = posList.get(j);
					JSONObject data2 = new JSONObject();
					data2.put("name", pos.getName());
					data2.put("id", pos.getId());
					data2.put("pid", warehouse.getId());
					data2.put("type", "position");
					data2.put("childCount", 0);
					children.add(data2);

				}
			}
			data.put("children", children);
			data.put("childCount", posList.size());
			result.add(data);

		}
		return result;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param warehousePosition 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(WarehousePosition warehousePosition) {
		return this.insert(warehousePosition,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param warehousePositionList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<WarehousePosition> warehousePositionList) {
		return super.insertList(warehousePositionList);
	}

	
	/**
	 * 按主键删除仓库库位
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		WarehousePosition warehousePosition = new WarehousePosition();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		warehousePosition.setId(id);
		try {
			boolean suc = dao.deleteEntity(warehousePosition);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除仓库库位
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		WarehousePosition warehousePosition = new WarehousePosition();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		warehousePosition.setId(id);
		warehousePosition.setDeleted(true);
		warehousePosition.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		warehousePosition.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(warehousePosition,SaveMode.NOT_NULL_FIELDS);
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
	 * @param warehousePosition 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(WarehousePosition warehousePosition , SaveMode mode) {
		return this.update(warehousePosition,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param warehousePosition 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(WarehousePosition warehousePosition , SaveMode mode,boolean throwsException) {
		Result r=super.update(warehousePosition , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("update eam_warehouse_position a,eam_warehouse b set a.full_name=concat(b.warehouse_name,'/',a.name) where a.warehouse_id=b.id and a.id=?",warehousePosition.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param warehousePositionList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<WarehousePosition> warehousePositionList , SaveMode mode) {
		return super.updateList(warehousePositionList , mode);
	}

	
	/**
	 * 按主键更新仓库库位
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
	 * 按主键获取仓库库位
	 *
	 * @param id 主键
	 * @return WarehousePosition 数据对象
	 */
	public WarehousePosition getById(String id) {
		WarehousePosition sample = new WarehousePosition();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<WarehousePosition> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<WarehousePosition> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, WarehousePosition> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, WarehousePosition::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<WarehousePosition> queryList(WarehousePositionVO sample) {
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
	public PagedList<WarehousePosition> queryPagedList(WarehousePositionVO sample, int pageSize, int pageIndex) {
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
	public PagedList<WarehousePosition> queryPagedList(WarehousePosition sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param warehousePosition 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(WarehousePosition warehousePosition) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(warehousePosition, SYS_ROLE.NAME);
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