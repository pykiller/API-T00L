# API-T00L v1.0
期望是针对互联网各大API泄露的利用工具，包含钉钉、企业微信、飞书等。目前只做出了钉钉的，别问，就是懒。特别鸣谢chatgpt，代码好帮手。
目前界面长这样，布局拉胯，能用就行。
![1](https://github.com/pykiller/API-T00L/assets/38202442/597e89ae-a7fb-4548-bb6d-09e52b6f924e)


# 食用方法

## 1、肯定你得有ak、as。填进去获取token
![image](https://github.com/pykiller/API-T00L/assets/38202442/6a27185b-2094-4779-9a0c-b2226c44335b)


## 2、建用户
最简单的做法，直接填入有效手机号，加入组织中可以直接用手机号登录该企业。
userid不要重了，写大点。
删除按钮是根据userid来删除的
![image](https://github.com/pykiller/API-T00L/assets/38202442/ca48b14b-f5a8-4874-90bc-375187d34c46)




## 3、发公告钓鱼
获取管理员信息，得到管理员userid。

![image](https://github.com/pykiller/API-T00L/assets/38202442/1d17c5aa-b76d-491b-a38d-953895a69140)



查userid可以得到部门id dept_id

![image](https://github.com/pykiller/API-T00L/assets/38202442/e15f4314-aebb-4548-8931-3dc244cacfaf)


进一步可以发公告钓鱼

![image](https://github.com/pykiller/API-T00L/assets/38202442/aa04d127-3e5e-4ce1-b8ef-49c63aee6d3f)


## 4、获取应用列表，这个会泄露一些没备案的难搜的资产。
