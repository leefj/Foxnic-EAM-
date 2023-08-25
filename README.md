![foxnic](platform/view/view-console/src/main/resources/static/assets/images/foxnic-250.jpg)

# 本系系统介绍
- 实现企业对资产的基本管理,包含对资产的登记、维修、调拨、转移等基本功能的支持，并提供对资产的耗材、库存进行管理，有完善的组织架构，非常适合中小企业的需求
- 系统整体覆盖了基本的资产管理、合同管理、运维服务、运维服务、数据中心设备管理等多个模块。

# 系统及相关文档下载地址
- 链接: https://pan.baidu.com/s/1d6Yvszugq2fdGNEsW8ijmQ 提取码: lm6i
- <img width="200"  src="https://images.gitee.com/uploads/images/2022/0621/084431_f977a14d_448530.png" />

# 官方网站
- http://web.foxnicweb.com/
- 1、QQ群:634770774
- 2、微信号:myxyjm
- 企业或个人相关技术开发合作，请进群联系我们！
- 微信群：      
  ![微信群](platform/view/view-console/src/main/resources/static/assets/images/wx.png)
  
# 二次开发 特别注意
#### 1、源代码已包含所有的涉及的源代码，数据库表结构也已发布，整个项目构建需要一定的开发经验
#### 2、二次开发原则上必须有3年Java开发经验或者自认为能力可以
#### 3、不推荐新手用IDEA打开本项目,本项目非标准项目，没有学习意义
#### 4、二开前先看文档、文档很重要、文档很重要

#### 最新编译后的包下载(为开发同步版本，并非发布版本)
- 1、存储过程:[下载SQL](http://foxnicweb.com/docs/chapters/base/1.1/NextVal.zip)
- 2、SQL文件:(每日更新):http://eam-demo.rainbooow.com/upload/sql.tar.gz   ( **必须使用 source 命令导入！！！** )

#### 开发环境(特别注意，严格按照以下要求)
- 开发工具:IntelliJ IDEA 2022.2以上(不要使用eclipse)
- 数据库:Mysql 5.7.32(必须为Mysql5.7.X)
- maven:版本3.6.3(建议)
- Redis:5.0.12(可选)
- Java:JDK 1.8.200 (小版本200以上,但仅支持1.8)

#### 系统及相关文档下载地址
- 链接: https://pan.baidu.com/s/1d6Yvszugq2fdGNEsW8ijmQ 提取码: lm6i
- <img width="200"  src="https://images.gitee.com/uploads/images/2022/0621/084431_f977a14d_448530.png" />


### 二次开发系统部署的入门视频介绍(二次开发的环境部署)
- 1、配置项目源码 https://www.bilibili.com/video/BV1844y1377V?spm_id_from=333.999.0.0
- 2、配置数据库 https://www.bilibili.com/video/BV1kR4y1P7Py?spm_id_from=333.999.0.0
- 3、配置与启动应用 https://www.bilibili.com/video/BV1wu411r7xC?spm_id_from=333.999.0.0
- 4、部署 https://www.bilibili.com/video/BV1Q34y1a7LR?spm_id_from=333.999.0.0
- 5、Maven设置 https://www.bilibili.com/video/BV1x34y1j7Ff?share_source=copy_web
- 6、Maven依赖管理 https://www.bilibili.com/video/BV12T411K7pz/

### 二次开发相关的视频与文档集合
- 1、官网文档集合 http://foxnicweb.com/docs/doc.html
- 2、B站资料集合 https://space.bilibili.com/1796475412
- 3、知乎视频资料集合 https://www.zhihu.com/people/leefj/zvideos
- 4、知乎文档集合 https://www.zhihu.com/people/leefj/posts



#### 技术栈
- 安全框架:Spring Security 5.3.4
- 开发框架:SpringBoot 2.3.3
- 数据库链接池:Druid 1.2.8
- 模版引擎:Thymeleaf 3
- 应用层框架:[Foxnic-Web](https://gitee.com/LeeFJ/foxnic-web) [开发文档](http://foxnicweb.com/docs/doc.html)
- 持久层框架:[FoxnicSQL&FoxnicDAO](https://gitee.com/LeeFJ/foxnic)
- 日志管理:Logback 1.2.3
- 流程引擎:Camunda
- 任务调度:Quartz 2.3.3
- 项目管理框架: Maven 3.6、3.8
- 运行容器:Undertow
- 前端组件:LayUI 2.6.8

#### 系统架构图
![输入图片说明](https://images.gitee.com/uploads/images/2022/0407/143343_0a8f4947_448530.png "EAM.png")

#### 代码组织方式
![输入图片说明](https://foruda.gitee.com/images/1665182206427612624/9e7fcb5b_448530.png "WechatIMG68.png")

## 系统开源协议补充申明
- 1、本系统产品开源免费(协议:GPLv3)，并且将持续提供免费的社区技术支持，个人或企业内部可自由的接入和使用，但禁止任何单位或个人修改软件后再次发行或出售的行为
- 2、本系统源代码已开源，软件介质以社区版形式供免费使用,在未授权情况下，禁止修改涉及版权信息的相关代码和名称

### 方案一 一键安装系统
- 自动安装Mysql,Java,应用，Mysql从官方下载，因此整体安装速度会慢
- 安装环境前先确认
- 操作系统支持:RedHat 7.9-8.2 较为干净的系统，同时支持CentOS、麒麟、欧拉。yum源配置需正确(unzip,wget,zip等包需要安装)，公有云的默认yum配置一般没问题
- 应用访问地址为:http://ip-address:8089
- 数据库:端口3308，密码root_pwd
- 安装目录:/app
```
#安装命令
curl -s 'http://resource.rainbooow.com/deploy.sh'|bash
或者
curl -s 'https://gitee.com/lank/eam/raw/2.6.0/platform/deploy/bin/deployApp.sh'|bash
```
### 安装包
- https://cdn.mysql.com/archives/mysql-5.7/mysql-5.7.37-linux-glibc2.12-x86_64.tar.gz
- http://resource.rainbooow.com/upload/app_release_last.tar.gz

### 系统DEMO
- [Demo] 每天定时由阿里云效自动编译发布部署
- [Demo] PC端:http://eam-demo.rainbooow.com:8089/index.html
- [Demo] PC端:https://eam-demo.rainbooow.com:8090/index.html
- [Demo] 移动端H5版:https://eam-demo.rainbooow.com:8091
- [Demo] 移动端APP内置自行下载
- [Demo] 超级管理员账户:admin 密码:123456  其它账户密码 为 123456
- [Demo] 固定资产管理员(账户):eamadmin 密码:123456
- [Demo] 固定资产普通员工(账户):eamuser 密码:123456
- [Demo] 流程测试账号,统一密码 123456
- ----------------------------------------------------------------- 
- [Demo]-------------Foxnic-EAM 资产管理账户-------------
- [Demo]管理员:eamadmin 123456
- [Demo]员工1:eamuser1 123456
- [Demo]员工2:eamuser2 123456
- [Demo]查询:eamquery 123456

- [Demo]-------------Foxnic-KN 知识库账户-------------
- [Demo]管理员:knadmin 123456
- [Demo]查询:knquery 123456

- [Demo]-------------Foxnic-OPS 运维账户-------------
- [Demo]管理员:opsadmin 123456
- [Demo]查询:opsquery 123456

- [Demo]-------------Foxnic-OPS-MONITOR 监控-------------
- [Demo]管理员:opsmonitoradmin 123456
- [Demo]查询:opsmonitorquery 123456

- [Demo]-------------Foxnic-Inspect合同(开发中)-------------
- [Demo]管理员:inspctadmin 123456
- [Demo]查询:inspctquery 123456
  
- [Demo]-------------Foxnic-Contract合同(开发中)-------------
- [Demo]管理员:contractadmin 123456
- [Demo]查询:contractquery 123456



| 类型 | 账户  | 姓名  |
|---|---|---|
| 流程管理员  | k3 | 王军 |
| 流程测试员  | qiaof  | 乔峰  |
| 流程测试员  |wangjt|	汪剑通|
| 流程测试员  |mady|	马大元|
| 流程测试员  |xuanc|	玄慈|	
| 流程测试员  |xuz|	虚竹|			
| 流程测试员  |duanzc|	段正淳|		
| 流程测试员  |duany|	段誉|	
| 流程测试员  |duanyq|	段延庆|		
| 流程测试员  |nanhes|	南海鳄神|
 

## 系统演示预览
![输入图片说明](https://foruda.gitee.com/images/1684211929402666916/6e6746d0_448530.jpeg "9.jpg")
![输入图片说明](https://foruda.gitee.com/images/1684212033095305227/399a4c16_448530.png "10.png")
![输入图片说明](https://foruda.gitee.com/images/1684211684098779220/734b0293_448530.png "2.png")
![输入图片说明](https://foruda.gitee.com/images/1684211694134002414/d6cade6e_448530.png "3.png")
![输入图片说明](https://foruda.gitee.com/images/1684211701838927268/14ab8641_448530.png "4.png")
![输入图片说明](https://foruda.gitee.com/images/1684211711830364540/7b0f4eac_448530.png "5.png")
![输入图片说明](https://foruda.gitee.com/images/1684211719375745990/3358f888_448530.png "6.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213315_83659719_448530.png "屏幕截图.png")
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
- 同时欢迎商业化定制,也欢迎其他业务的开发合作。
- 捐赠(支付宝)
  <img width="200" height="200" src="https://images.gitee.com/uploads/images/2020/1105/135552_037eeb5c_448530.png" />

 
 