# 20230914 v1.2 饼画完了，新增飞书api利用。

<img width="586" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/a7a198da-0662-4daf-961a-2f3c7f60c6bb">


# 20230913 v1.1 修复已知问题，单独把代理做成标签页。

<img width="586" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/8f4369fe-867f-4791-845e-38edf6104796">

# API-T00L v1.0

期望是针对互联网各大API泄露的利用工具，包含钉钉、企业微信、飞书等。目前只做出了钉钉和企业微信，别问，就是懒。特别鸣谢chatgpt，代码好帮手。
目前界面长这样，布局拉胯，能用就行。

<img width="586" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/1b77da79-bcef-424e-a3f2-8d544696b2e3">



# 食用方法

# 钉钉

## 1、肯定你得有ak、as。填进去获取token
<img width="585" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/0ac3ba1a-b780-4515-9d41-a4eff9694506">




## 2、建用户
最简单的做法，直接填入有效手机号，加入组织中可以直接用手机号登录该企业。
userid不要重了，写大点。
删除按钮是根据userid来删除的

![image](https://github.com/pykiller/API-T00L/assets/38202442/d86b4c2d-68c8-4753-aed3-c32fb47eb3df)





## 3、发公告钓鱼
获取管理员信息，得到管理员userid。


![image](https://github.com/pykiller/API-T00L/assets/38202442/548bfb5f-3106-4a64-b369-9032cc121ae9)





查userid可以得到部门id dept_id，这里只做了对部门发公告，实际操作中针对个人发公告效果不如直接加用户钓鱼好使。



![image](https://github.com/pykiller/API-T00L/assets/38202442/c9c20345-1ea1-4e2c-a5f6-cce58f05a02e)


进一步可以发公告钓鱼

![image](https://github.com/pykiller/API-T00L/assets/38202442/256fd36c-d7aa-405f-bea3-22098a9cc9ad)



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


# 飞书
实际利用的较少，一般都是劫持cookie做钓鱼用。

## 1、获取tenant_access_token

## 2、新建用户，填入有效手机号，加入组织中可以直接用手机号登录该企业。
需要注意，open_department_id为查询到的部门id，用户默认是放根部门，比较明显。可以放小部门里。

<img width="585" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/e6ca4650-d93c-4c5f-b087-7e2ea880f18c">

<img width="400" alt="image" src="https://github.com/pykiller/API-T00L/assets/38202442/90e2b5f4-535e-4ead-a526-6d18d4b4d5ee)">

## 3、公告问题，直接手机号登进去就可以发，没看到发公告的api接口。

