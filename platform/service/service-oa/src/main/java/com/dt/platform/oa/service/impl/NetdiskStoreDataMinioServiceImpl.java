package com.dt.platform.oa.service.impl;

import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.oa.service.INetdiskStoreDataService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service("NetdiskStoreDataMinioServiceImpl")
public class NetdiskStoreDataMinioServiceImpl implements INetdiskStoreDataService {

    @Override
    public NetdiskOriginFile write(NetdiskOriginFile fileInfo, MultipartFile file, String userDir) {
        return null;
    }

    @Override
    public byte[] read(NetdiskOriginFile fileInfo) {
        return null;
    }

    @Override
    public Boolean isFileExists(NetdiskOriginFile fileInfo) {
        return null;
    }
}
