package com.dt.platform.eam.service;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetExtAttribution;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.domain.eam.Goods;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物品档案 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:04:55
*/

public interface IAssetDataService extends ISuperService<Asset> {

	/**
	 * 插入实体
	 * @param ids 资产数据
	 * @param asset 资产实体
	 * @return 结果
	 * */
	List<Asset> queryAssetList(List<String> ids,AssetVO asset);



	/**
	 * 插入实体
	 * @param ids 资产数据
	 * @param asset 资产实体
	 * @return 结果
	 * */
	Map<String, Object> queryAssetMap(List<String> ids,AssetVO asset);

	/**
	 * 插入实体
	 * @param is 输入文件流
	 * @param fileName 输出文件名
	 * @return 结果
	 * */
	File saveTempFile(InputStream is, String fileName);

}