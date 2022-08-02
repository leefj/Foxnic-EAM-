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
  