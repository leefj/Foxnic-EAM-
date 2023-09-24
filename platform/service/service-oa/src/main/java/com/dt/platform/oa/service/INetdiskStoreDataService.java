package com.dt.platform.oa.service;

import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.domain.oa.NetdiskStorage;
import com.dt.platform.domain.oa.NetdiskStorageVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.storage.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 存储方式服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:21:10
*/

public interface INetdiskStoreDataService {

    NetdiskOriginFile write(NetdiskOriginFile fileInfo, MultipartFile mf, String dir);

    byte[] read(NetdiskOriginFile fileInfo);

    Boolean isFileExists(NetdiskOriginFile fileInfo);
}