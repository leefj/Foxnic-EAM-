# EAM管理系统介绍
- 实现企业对资产的基本管理,包含对资产的登记、维修、调拨、转移等基本功能的支持，并提供对资产的耗材、库存进行管理，有完善的组织架构，非常适合中小企业的需求
- EAM系统整体覆盖了基本的资产管理、合同管理、运维服务、运维服务、数据中心设备管理等多个模块。

### 官方网站
- http://web.foxnicweb.com/

### 系统DEMO
- [Demo] 每天定时由阿里云效自动编译发布部署
- [Demo] http://eam-demo.rainbooow.com:26788/index.html
- [Demo] 超级管理员账户:admin 密码:123456  其它账户密码 为 fx9090
- [Demo] 固定资产管理员(账户):eamadmin 密码:fx9090
- [Demo] 固定资产普通员工(账户):eamuser 密码:fx9090
- [Demo] 流程测试账号,统一密码 fx9090

 | 类型 | 账户  | 姓名  |
|---|---|---|
|  流程管理员 |  k3 | 金三胖  |
| 流程测试员  | qiaof  | 乔峰  |
| 流程测试员  |wangjt|	汪剑通|
| 流程测试员  |mady|	马大元|
| 流程测试员  |xuanc|	玄慈|	
| 流程测试员  |xuz|	虚竹|			
| 流程测试员  |duanzc|	段正淳|		
| 流程测试员  |duany|	段誉|	
| 流程测试员  |duanyq|	段延庆|		
| 流程测试员  |nanhes|	南海鳄神|	


### 系统及相关文档下载地址
- 链接: https://pan.baidu.com/s/1d6Yvszugq2fdGNEsW8ijmQ 提取码: lm6i
  <img width="200"  src="https://images.gitee.com/uploads/images/2022/0621/084431_f977a14d_448530.png" />


### 版本兼容性
| 应用版本     |   移动端版本     |
 | ---------- | -----------  |
| 1.0.12      | 1.0.10       |

#### 最新EAM编译后的包下载(为开发同步版本，并非发布版本)
- 1、存储过程:[下载SQL](http://foxnicweb.com/docs/chapters/base/1.1/NextVal.zip)
- 2、SQL文件:(每日更新):http://eam-demo.rainbooow.com/upload/sql.tar.gz

### 联系方式
- 1、QQ群:634770774 
- 2、微信号:myxyjm
- 3、微信群：      
![微信群](eam/view/view-console/src/main/resources/static/assets/images/wx.png)

### 主要技术栈
#### 后端技术栈
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

#### 前端技术栈
- 前端组件:LayUI 2.6.8

#### 开发环境
- IDE:IntelliJ IDEA 2020.2以上
- JDK:JDK 1.8.100 (小版本100以上,但仅支持1.8)
- 数据库:Mysql 5.7.X、8.0
- Redis:5.1(可选)

#### 系统架构图
![输入图片说明](https://images.gitee.com/uploads/images/2022/0407/143343_0a8f4947_448530.png "EAM.png")

## EAM系统开源协议补充申明
- 1、EAM系统产品开源免费(协议:GPLv3)，并且将持续提供免费的社区技术支持，个人或企业内部可自由的接入和使用，但禁止任何单位或个人修改软件后再次发行或出售的行为
- 2、EAM系统源代码已开源，软件介质以社区版形式供免费使用,在未授权情况下，禁止修改涉及版权信息的相关代码和名称


## 二次开发说明
### 二次开发相关文档
- 1、本系统二次开发建议至少有1到2年JAVA开发经验
     开发前请确保了解系统二次开发说明、系统使用常见问题清单、系统使用手册等相关文档
- 2、问题清单或说明中已收录的问题，例如无法下载lib、启动报错CP、java版本不对在说明中已明确要求的不在做解答。

### 二次开发EAM系统部署的入门视频介绍(二次开发的环境部署)
- 1、配置EAM项目源码 https://www.bilibili.com/video/BV1844y1377V?spm_id_from=333.999.0.0
- 2、配置数据库 https://www.bilibili.com/video/BV1kR4y1P7Py?spm_id_from=333.999.0.0
- 3、配置与启动应用 https://www.bilibili.com/video/BV1wu411r7xC?spm_id_from=333.999.0.0
- 4、EAM部署 https://www.bilibili.com/video/BV1Q34y1a7LR?spm_id_from=333.999.0.0
- 5、EAM MAVEN设置 https://www.bilibili.com/video/BV1x34y1j7Ff?share_source=copy_web

 