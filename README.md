RESTFeel
========




> RESTFeel: 一个企业级的API管理&测试平台。RESTFeel帮助你设计、开发、测试您的API。

功能简介：
========
* 请求生成器-使HTTP请求轻松。
* 请求树以树的形式组织请求。
* 合作-添加团队成员，管理多个项目。
* PDF报告-生成项目状态报告PDF格式。
* 历史-查看历史/活动日志。
* 自定义的时间间隔运行API项目。
* SendGrid - SendGrid集成发送通知。
* 云部署-它可以部署在任何服务器上，也可以用来作为一个基于云的托管Web应用程序。
* 私人-安装在您的环境和完全拥有它。与你的团队一起在你的私人网络中工作。
* 数据库-存储在您的数据库中的一切。
* swagger API文档生成。
* 标签-标签提供了一个有用的方式来组合相关的要求。
* 安全，访问控制，通知机制等。




![RESTFeel接口测试平台](https://github.com/Jason-Chen-2017/restfeel/blob/master/restfeel1.png)

![RESTFeel接口测试平台](https://github.com/Jason-Chen-2017/restfeel/blob/master/restfeel2.png)





MongoDB configuration:
==========

Building From Source
==========

##### Prerequisites

* JDK 7 or later

* Maven 3.0+

* Gradle 2.4 (Optional)

* MongoDB 3.x

##### Build

```
mvn clean install
```

##### Run

```
mvn spring-boot:run
```

##### Access

The build file is configured to download and use an embedded Tomcat server. So the application should be up and running by using just two commands mentioned above. Once the server is started, the application can be accessed using http://localhost:8080. 

```
Default login email / password : rf@example.com / rf
```

##### Debug

```
mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000"
```

Note : To avoid java.lang.OutOfMemoryError: PermGen space, use the following command:

```
MAVEN_OPTS="-XX:PermSize=256m -XX:MaxPermSize=512m" mvn spring-boot:run 
```



Go to *src/main/resources/env-development.properties* and update mongodb properties. Here is how the sample configuration looks like:

```
mongodb.name=restfeel

mongodb.host=localhost

mongodb.port=27017

mongodb.username=

mongodb.password=
```

##### Steps to re-build the database:

```
1. Stop restfeel server, if running.
2. Start MongoDB, if not running.
	Here is the command I use : "C:\Program Files\MongoDB\bin\mongod.exe" --dbpath C:\Users\ANUJA\Documents\restfeel\data
3. Connect to MongoDB.
	Here is one of the ways to connect to MongoDB : 
	Go to "C:\Program Files\MongoDB\bin" folder and run "mongo" command.
	Then run "use restfeel" command and finally "db.dropDatabase()" command to delete the existing restfeel database.
	Note : you will see following message on the command prompt : { "dropped" : "restfeel", "ok" : 1 }
4. Start restfeel application (mvn spring-boot:run) - This will create and initialize the database.
```

##### Steps to recover database:

```
Sometimes MongoDB doesn't start and shows message:
        old lock file: C:\Users\ANUJA\Documents\restfeeldata\data\mongod.lock. probably means unclean shutdown
Run repair operation to recover your database
	"C:\Program Files\MongoDB\bin\mongod.exe" --dbpath C:\Users\ANUJA\Documents\restfeeldata\data --repair
Most likely, your data will be repaired with the --repair option. In case it doesn't, delete the mongod.lock file and then run the above --repair command.
```


MongoDB配置restfeel数据库用户名密码
======

#### Step1.首先，切换到admin db (schema):

```
> use admin;
switched to db admin

```


#### Step2.在該 schema 下面設置用戶名，密碼：

```

> db.createUser({ user: "root",pwd: "root",customData:{name:"root"},roles:[{ role: "userAdminAnyDatabase",db: "admin" }]})
Successfully added user: {
	"user" : "root",
	"customData" : {
		"name" : "root"
	},
	"roles" : [
		{
			"role" : "userAdminAnyDatabase",
			"db" : "admin"
		}
	]
}
> db.auth('root','root')
1
```

#### Step3.admin中直接给restfeel权限

```
var r = 
    {
      "_id": "restfeel.root",
      "user": "root",
      "db": "restfeel",
      "credentials": {
        "SCRAM-SHA-1": {
          "iterationCount": 10000,
          "salt": "riZjwBYHvkcV99typ8BRMA==",
          "storedKey": "E2QOruLrBNXD1mlQTX0TQogL/ws=",
          "serverKey": "JEQhfa/5x7+aNzKrFvKRkctXXfQ="
        }
      },
      "roles": [
        {
          "role": "dbOwner",
          "db": "restfeel"
        },
        {
          "role": "read",
          "db": "restfeel"
        },
        {
          "role": "readWrite",
          "db": "restfeel"
        }
      ]
    }


db.system.users.insert(r)


```


或者db.createUser
===


```
use restfeel
db.createUser({"user":"jason","pwd":"123456","roles":["dbOwner","read","readWrite"]})
```


可以看到admin中已经有了jason这个管理员：

```
> use admin;
> db.system.users.find();

{
  "_id": "restfeel.jason",
  "user": "jason",
  "db": "restfeel",
  "credentials": {
    "SCRAM-SHA-1": {
      "iterationCount": 10000,
      "salt": "HZsutqbxGjKVkPcY4305FQ==",
      "storedKey": "bynL9UW9cIf0iPOLo9pGwCFz638=",
      "serverKey": "PRPKH+7dVaKDJ/JE+7ZjQUe3whA="
    }
  },
  "roles": [
    {
      "role": "dbOwner",
      "db": "restfeel"
    },
    {
      "role": "read",
      "db": "restfeel"
    },
    {
      "role": "readWrite",
      "db": "restfeel"
    }
  ]
}

Fetched 4 record(s) in 9ms

```



參考文章
===

[《MongoDB极简教程》第一章 安装&环境配置](http://www.jianshu.com/p/3d6a493f6418)


[《MongoDB极简教程》第二章 MongoDB 基本命令](http://www.jianshu.com/p/d7bb76febcad)



>基于开源项目开发：
[Restfiddle](http://www.restfiddle.com/)

