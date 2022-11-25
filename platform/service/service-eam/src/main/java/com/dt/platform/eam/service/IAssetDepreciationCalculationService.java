package com.dt.platform.eam.service;


import com.dt.platform.constants.enums.eam.AssetDepreciationCodeEnum;
import com.dt.platform.domain.eam.Area;
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

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 折旧计算
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 16:47:24
*/

public interface IAssetDepreciationCalculationService {

	public AssetDepreciationCodeEnum getCode();


	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param billId 单据ID
	 * @return 是否否成功
	 * */
	Result calculation(String billId);

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param billId 单据ID
	 * @return 是否否成功
	 * */
	Result fillAssetData(String billId);
 
}