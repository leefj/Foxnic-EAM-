

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

- 部署步骤
```
  其中镜像中1.0.9为版本号,替换相对于版本即可。
  确保本地操作系统下/data/mysql目录的正确性,检查未冲突。
  $docker run --name eamapp -it \
    -e MYSQL_ROOT_PASSWORD="root_pwd" \
    -v /data/mysql:/var/lib/mysql  \
    -p 3306:3306 \
    -p 8089:8089 \
    -d docker.io/algernonking/eamapp:1.0.9 \
    --character-set-server=utf8
```

### 方案三 应用直接部署
- 详细部署方式查询git目录下的文档说明
- https://gitee.com/lank/eam/tree/master/%E7%9B%B8%E5%85%B3%E6%96%87%E6%A1%A3


 
## 系统演示预览
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/212929_46438369_448530.jpeg "1.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0513/115529_b00ce19a_448530.png "WechatIMG3.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213230_1ba469f5_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213258_8d970535_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213315_83659719_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0617/062632_fb854882_448530.png "WechatIMG1.png")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0712/125124_788dfc2f_448530.jpeg "e1.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0712/125138_061ee2e5_448530.jpeg "e2.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0712/125147_e4425787_448530.jpeg "e3.jpg")
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0619/223205_d0e22d76_448530.jpeg " />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122751_e20f543f_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122759_2c4b10f6_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122807_a1c6116b_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122814_24bcd70e_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122824_f21ca8de_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0326/212016_f9fa171e_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0326/212025_135c19b0_448530.jpeg" />
 
## 捐赠
- 开源不易，坚持更难，如果您觉得本项目不错，可以捐赠请作者喝杯咖啡~，在此表示感谢^_^
- 同时欢迎EAM系统的商业化定制,也欢迎其他业务的开发合作。
- 捐赠(支付宝)
<img width="200" height="200" src="https://images.gitee.com/uploads/images/2020/1105/135552_037eeb5c_448530.png" />

 
 