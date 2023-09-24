package com.dt.platform.oa.service.impl;

import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.oa.service.INetdiskStoreDataService;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import org.apache.commons.io.IOUtils;
import org.github.foxnic.web.domain.storage.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


@Service("NetdiskStoreDataDiskServiceImpl")
public class NetdiskStoreDataDiskServiceImpl implements INetdiskStoreDataService {

    @Value("${foxnic.storage.netdisk.location.windows}")
    public final String windowsDir="";

    @Value("${foxnic.storage.netdisk.location.mac}")
    public final String macDir="";

    @Value("${foxnic.storage.netdisk.location.linux}")
    public final String linuxDir="";

    public String getStorageDir() {
//        windows: c:/netdisk
//        mac: /Users/Shared/netdisk
//        linux: /app/app/app/netdisk
        if(OSType.isWindows()) return "c:/netdisk";
        else if(OSType.isLinux()) return "/app/app/app/netdisk";
        else if(OSType.isMac()) return "/Users/Shared/netdisk";
        else {
            throw new RuntimeException("不支持的操作系统");
        }

    }

    @Override
    public NetdiskOriginFile write(NetdiskOriginFile fileInfo, MultipartFile file, String userDir) {
        String dir=this.getStorageDir();

        byte[] bytes=new byte[0];
        try {
            bytes = file.getBytes();
        } catch (Exception e) {
            Logger.error("文件字节错误",e);
        }
        String url=null;
        try {
            java.io.File f= FileUtil.resolveByPath(dir, DateUtil.format(new Date(), "yyyyMMdd"), IDGenerator.getSnowflakeId()+".block");
            url=f.getAbsolutePath().substring(dir.length());
            fileInfo.setLocation(url);
            if(!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            FileOutputStream out=new FileOutputStream(f);
            fileInfo.setFileSize(new Long(bytes.length));
            IOUtils.write(bytes, out);
            out.close();

        } catch (Exception e) {
            Logger.error("文件写入错误",e);
        }
        return fileInfo;
    }
    @Override
    public byte[] read(NetdiskOriginFile fileInfo) {
        byte[] bytes=null;
        String dir=this.getStorageDir();
        Logger.info("dir:"+dir);
        try {
            if(!isFileExists(fileInfo)) {
//                throw  new RuntimeException("FileId = "+fileInfo.getId()+" , file is not exists");
                return null;
            }
            FileInputStream in=new FileInputStream(getFile(fileInfo));
            bytes =IOUtils.readFully(in, in.available());
            return bytes;
        } catch (IOException e) {
//            throw  new RuntimeException("FileId = "+fileInfo.getId()+" , file download error",e);
            return null;
        }
    }

    private java.io.File getFile(NetdiskOriginFile fileInfo) {
        if(fileInfo==null) return null;
        String dir=this.getStorageDir();
        Logger.info("dir:"+dir);
        if(!OSType.isWindows()){
            fileInfo.setLocation(fileInfo.getLocation().replace('\\','/'));
        }
        java.io.File f= FileUtil.resolveByPath(dir, fileInfo.getLocation());
        return f;
    }


    @Override
    public Boolean isFileExists(NetdiskOriginFile fileInfo) {
        java.io.File f= getFile(fileInfo);
        if(f==null) return false;
        Logger.info(f.getAbsolutePath());
        System.out.println("f######"+f.exists());
        return f.exists();
    }

}
