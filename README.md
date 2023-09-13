# 20230913 更新v1.1 修复钉钉标签页日志显示问题。
# API-T00L v1.0
有BUG也解决不了，答辩源码在这自己动手👀
期望是针对互联网各大API泄露的利用工具，包含钉钉、企业微信、飞书等。目前只做出了钉钉和企业微信，别问，就是懒。特别鸣谢chatgpt，代码好帮手。
目前界面长这样，布局拉胯，能用就行。

<img width="586" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/1b77da79-bcef-424e-a3f2-8d544696b2e3">



# 食用方法

# 钉钉

## 1、肯定你得有ak、as。填进去获取token
<img width="585" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/6a27185b-2094-4779-9a0c-b2226c44335b">


## 2、建用户
最简单的做法，直接填入有效手机号，加入组织中可以直接用手机号登录该企业。
userid不要重了，写大点。
删除按钮是根据userid来删除的
![image](https://github.com/pykiller/API-T00L/assets/38202442/ca48b14b-f5a8-4874-90bc-375187d34c46)




## 3、发公告钓鱼
获取管理员信息，得到管理员userid。

![image](https://github.com/pykiller/API-T00L/assets/38202442/1d17c5aa-b76d-491b-a38d-953895a69140)



查userid可以得到部门id dept_id，这里只做了对部门发公告，实际操作中针对个人发公告效果不如直接加用户钓鱼好使。

![image](https://github.com/pykiller/API-T00L/assets/38202442/e15f4314-aebb-4548-8931-3dc244cacfaf)


进一步可以发公告钓鱼

![image](https://github.com/pykiller/API-T00L/assets/38202442/aa04d127-3e5e-4ce1-b8ef-49c63aee6d3f)


## 4、获取应用列表，这个会泄露一些没备案的难搜的资产。


# 企业微信

企业微信相对于钉钉，限制较多，22年后获取的应用Corpsecret需要设置白名单，且无法绕过。并且对于通讯录的Corpsecret需要单独获取。
## 1、用Corpid和Corpsecret获取token

## 2、新建用户，填入有效手机号，加入组织中可以直接用手机号登录该企业。

<img width="585" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/a7531ef6-d7a3-4ad3-9441-c8f341d4f091">


而且加进去就分配邮箱，可通过邮箱和企业微信钓鱼。

<img width="300" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/a6696792-4a83-4c1d-8997-260f99900a70">



## 3、还可以通过获取邀请二维码加入到企业。

<img width="585" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/cc60e6b7-177b-4c29-b0e9-4c26b8bee14d">

<img width="600" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/a9203c39-14b2-4ee0-a2e4-6c4b59626893">

