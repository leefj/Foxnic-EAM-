package com.dt.platform.common.service;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.common.UserImport;
import com.dt.platform.domain.common.UserImportVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.dao.excel.ExcelStructure;
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
 * 员工导入服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 14:16:24
*/

public interface ICommonService extends  ISimpleIdService<UserImport,String> {

	 Result alertNotice(String ct,String url);

	 Result<JSONObject> queryCurrentUserInfo();

	 Object callMagicAPIService(String execType,String reqType,String path,Map<String, Object> params);

}