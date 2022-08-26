# server

## i互助后端仓库

### 克隆仓库

```sh
git clone ssh://git@144.202.125.241:22222/ihuzhu/server.git

或

git clone https://git.doctorlwho.com/ihuzhu/server.git
```

### 分支说明

- master：主分支
- test：测试分支，master的子分支
- dev：开发分支，test的子分支
- name：个人开发分支，dev的子分支，name为姓名拼音缩写，例如：qinzx

### 项目结构

```sh
├─cloud 云服务
│  ├─src
│     └─main
│         ├─java
│         │  └─com
│         │      └─services
│         │          └─cloud
│         │              ├─aliyun 阿里云
│         │              │  └─oss 阿里云oss
│         │              ├─config 配置类
│         │              ├─enums 枚举类
│         │              ├─exception 异常类
│         │              ├─tencent 腾讯
│         │              │  ├─cloud 腾讯云
│         │              │  └─lbs 腾讯位置服务
│         │              └─wx 微信
│         │                  └─miniapp 微信小程序
│         └─resources
│             └─config 配置
├─cloud-api 云服务接口
├─core 核心公共模块
│  ├─src
│     └─main
│         └─java
│             └─com
│                 └─services
│                     └─core
│                         ├─bo 业务类
│                         ├─config 配置类
│                         ├─exception 异常类
│                         ├─util 工具类
│                         └─vo 展示类
├─doc 文档
├─eureka 注册中心
├─products 产品
│  └─ihelp 养老互助项目
│      ├─ihelp-cms 管理后台
│      │  ├─src
│      │  │  ├─main
│      │  │  │  ├─java
│      │  │  │  │  └─com
│      │  │  │  │      └─services
│      │  │  │  │          └─products
│      │  │  │  │              └─ihelp
│      │  │  │  │                  └─cms
│      │  │  │  │                      ├─config 配置类
│      │  │  │  │                      └─controller 控制层
│      │  │  │  └─resources 配置
│      ├─ihelp-dao 数据访问层
│      │  ├─src
│      │  │  └─main
│      │  │      ├─java
│      │  │      │  └─com
│      │  │      │      └─services
│      │  │      │          └─products
│      │  │      │              └─ihelp
│      │  │      │                  └─dao
│      │  │      │                      ├─domain 数据库实体类
│      │  │      │                      └─mapper 通用mapper
│      │  │      │                          └─my 自定义mapper
│      │  │      └─resources
│      │  │          ├─generator mybatis逆向配置
│      │  │          └─mapper 通用mapper
│      │  │              └─my 自定义mapper
│      ├─ihelp-gateway 网关
│      │  ├─src
│      │  │  ├─main
│      │  │  │  ├─java
│      │  │  │  │  └─com
│      │  │  │  │      └─services
│      │  │  │  │          └─products
│      │  │  │  │              └─ihelp
│      │  │  │  │                  └─gateway
│      │  │  │  │                      └─filter 拦截配置
│      │  │  │  └─resources 配置
│      ├─ihelp-miniapp 微信小程序
│      │  ├─src
│      │  │  ├─main
│      │  │  │  ├─java
│      │  │  │  │  └─com
│      │  │  │  │      └─services
│      │  │  │  │          └─products
│      │  │  │  │              └─ihelp
│      │  │  │  │                  └─miniapp
│      │  │  │  │                      ├─config 配置类
│      │  │  │  │                      ├─controller 控制层
│      │  │  │  └─resources 配置
│      ├─ihelp-service 业务层
│      │  ├─src
│      │  │  ├─main
│      │  │  │  ├─java
│      │  │  │  │  └─com
│      │  │  │  │      └─services
│      │  │  │  │          └─products
│      │  │  │  │              └─ihelp
│      │  │  │  │                  └─service
│      │  │  │  │                      ├─config 配置类
│      │  │  │  │                      ├─dto 传输类
│      │  │  │  │                      ├─enums 枚举类
│      │  │  │  │                      ├─exception 异常类
│      │  │  │  │                      ├─service 业务逻辑类
│      │  │  │  │                      ├─util 工具类
│      │  │  │  │                      └─vo 展示类
│      │  │  │  └─resources
│      │  │  │      └─config 配置
└─proxy 内网穿透工具

```

### 项目初始化

- 环境：jdk11，maven

- 在下载好的仓库根目录打开git bash，执行以下命令：

  ```sh
  # 克隆每个远程分支
  git branch -r | grep -v '\->' | while read remote; do git branch --track "${remote#origin/}" "$remote"; done
  # 关联每个远程分支
  for b in `git branch -r | grep -v -- '->'`; do git branch --track ${b##origin/} $b; done
  # 切换到个人分支开发，name替换成自己的名字拼音缩写，例如：qinzx
  git switch name
  ```
  
  

- 用idea打开仓库目录并下载依赖


### 项目运行

- 启动类为xxxApplication

- 启动顺序：eureka->cloud->gateway->ihelp