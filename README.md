

### 二次开发相关的视频与文档集合
- 1、官网文档集合 http://foxnicweb.com/docs/doc.html
- 2、B站资料集合 https://space.bilibili.com/1796475412
- 3、知乎视频资料集合 https://www.zhihu.com/people/leefj/zvideos
- 4、知乎文档集合 https://www.zhihu.com/people/leefj/posts


## EAM系统安装部署
### 实施方案
- 1、传统方式:传统单体架构方式打包部署
- 2、微服务:拆分成独立微服务方式部署
- 3、集群模式:拆分成独立服务各自独立启动部署

### 软件介质
- 1、Docker部署:直接从docker拉镜像
- 2、应用直接运行部署:应用JAR和SQL包来源:https://gitee.com/lank/eam/releases


### EAM系统部署的视频介绍
- 1、待录制


### 方案一 一键安装Foxnic-EAM
- 自动安装Mysql,Java,EAM应用，Mysql从官方下载，因此整体安装速度会慢些
- 安装环境前先确认： 
- 操作系统支持:RedHat 7.9 、RedHat 8.0、RedHat 8.2 较为干净的系统。yum源配置需正确(unzip,wget,zip等包需要安装)，公有云的默认yum配置一般没问题
- 安装:Mysql5.7 端口3306，密码root_pwd
- 安装:EAM web端口8089，访问地址为:http://ip:8089
- 安装目录:/app目录
```
#安装命令
curl -L 'http://resource.rainbooow.com/appInstallFull.sh'|bash
```

### 方案二 Docker方式-建议作为体验使用
- 注意点:docker 版本可用作体验版本，正式使用不推荐docker部署方式。
- 注意点:建议第一次docker部署完后，在重启一次，可能第一次启动数据库初始化还没完成，会导致报错
- 应用和移动端兼容列表

 | 应用镜像     |   
 | ---------- | 
 | 1.0.9      | 
