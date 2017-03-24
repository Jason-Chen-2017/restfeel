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
mongodb.name=restfiddle

mongodb.host=localhost

mongodb.port=27017

mongodb.username=

mongodb.password=
```

##### Steps to re-build the database:

```
1. Stop RESTFiddle server, if running.
2. Start MongoDB, if not running.
	Here is the command I use : "C:\Program Files\MongoDB\bin\mongod.exe" --dbpath C:\Users\ANUJA\Documents\restfiddle\data
3. Connect to MongoDB.
	Here is one of the ways to connect to MongoDB : 
	Go to "C:\Program Files\MongoDB\bin" folder and run "mongo" command.
	Then run "use restfiddle" command and finally "db.dropDatabase()" command to delete the existing RESTFiddle database.
	Note : you will see following message on the command prompt : { "dropped" : "restfiddle", "ok" : 1 }
4. Start RESTFiddle application (mvn spring-boot:run) - This will create and initialize the database.
```

##### Steps to recover database:

```
Sometimes MongoDB doesn't start and shows message:
        old lock file: C:\Users\ANUJA\Documents\restfiddledata\data\mongod.lock. probably means unclean shutdown
Run repair operation to recover your database
	"C:\Program Files\MongoDB\bin\mongod.exe" --dbpath C:\Users\ANUJA\Documents\restfiddledata\data --repair
Most likely, your data will be repaired with the --repair option. In case it doesn't, delete the mongod.lock file and then run the above --repair command.
```


MongoDB配置数据库用户名密码
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

#### Step3.admin中直接给restfiddle权限

```
var r = 
    {
      "_id": "restfiddle.root",
      "user": "root",
      "db": "restfiddle",
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
          "db": "restfiddle"
        },
        {
          "role": "read",
          "db": "restfiddle"
        },
        {
          "role": "readWrite",
          "db": "restfiddle"
        }
      ]
    }


db.system.users.insert(r)


```


或者


```
use restfiddle
db.createUser({"user":"jason","pwd":"123456","roles":["dbOwner","read","readWrite"]})
```


可以看到admin中已经有了jason这个管理员：

```
> use admin;
> db.system.users.find();

{
  "_id": "restfiddle.jason",
  "user": "jason",
  "db": "restfiddle",
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
      "db": "restfiddle"
    },
    {
      "role": "read",
      "db": "restfiddle"
    },
    {
      "role": "readWrite",
      "db": "restfiddle"
    }
  ]
}

Fetched 4 record(s) in 9ms

```



參考文章：

[《MongoDB极简教程》第一章 安装&环境配置](http://www.jianshu.com/p/3d6a493f6418)


[《MongoDB极简教程》第二章 MongoDB 基本命令](http://www.jianshu.com/p/d7bb76febcad)





>源自开源项目：
[RESTFiddle](http://www.restfiddle.com/)


[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/AnujaK/restfiddle?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Build Status](https://travis-ci.org/AnujaK/restfiddle.svg?branch=master)](https://travis-ci.org/AnujaK/restfiddle)



An Enterprise-grade API Management Platform for Teams. RESTFiddle helps you design, develop, test and release APIs.

Some of the key features of this platform are:

* Request Builder - Make HTTP requests with ease.
* Request Tree - Organize requests in the form of a tree.
* Collaboration - Add as many collaborators as you want from your team and work together on a project.
* PDF Reports - Generate project status reports in PDF format.
* Integration - RESTFiddle platform exposes APIs for everything it has.
* History - Unlimited history/activity log.
* Scheduler - Run API projects on predefined time intervals.
* SendGrid - SendGrid integration to send notifications.
* Cloud Deployment - It can be deployed over any server and can also be used as a cloud based hosted web application.
* Private - Install it in your environment and own it completely. Work together with your team in your private network.
* Database - Store everything in your database.
* Swagger - Access RESTFiddle API documentation using Swagger UI.
* Tagging - Tags provide a useful way to group related requests together.
* Open Source - Fork it and build the features of your choice.
* More - Security, Access Control, Notifications and much more.

A lot of powerful features coming soon!

Who Uses RESTFiddle
==========

##### The following is a list of companies and projects using RESTFiddle:

* BootSimply Solutions (http://bootsimply.com/)

Want to be added to this section? Email me at contact at bootsimply dot com.



##### For Gradle Users:

*Build war*

Unix  : 
```
./gradlew clean war
```

Windows  : 
```
gradlew.bat clean war
```

*Run*


Unix  : 
```
./gradlew bootRun
```

Windows  : 
```
gradlew.bat bootRun
```
Debugging in Windows : Add the following to build.gradle file and then run the above command
```
applicationDefaultJvmArgs = [
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"
]
```

Using MongoDB 3.x
==========



##### Windows

Download the latest MongoDB version. After kappa release, RESTFiddle has enabled authentication and moved to version 3.0. To start using this, create a configuration file mongo.conf at a location.e.g. F:\restfiddledata\. Create mongo.log file for logging e.g. F:\restfiddledata\log\ This is how configuration file looks like:

```
bind_ip = 127.0.0.1
 
port = 27017
 
quiet = true
 
dbpath=F:\restfiddledata\data0
  
logpath=F:\restfiddledata\log\mongo.log
 
logappend = true
```

Start MongoDB without authentication.
```
"C:\Program Files\MongoDB\Server\3.0\bin\mongod.exe" --config F:\restfiddledata\mongo.conf  
```

On another command prompt go to C:\Program Files\MongoDB\Server\3.0\bin and type command mongo. This opens Mongo Shell. 
Create user here.

```
use restfiddle
db.createUser({"user":"rf","pwd":"rf","roles":["dbOwner","read","readWrite"]})
```

Now stop the database and restart it so that it checks for authentication
```
"C:\Program Files\MongoDB\Server\3.0\bin\mongod.exe" --auth --config F:\restfiddledata\mongo.conf
```

Start the RESTFiddle application using the same command as earlier
```
mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"
```



##### Mac





Deployment
==========

You can deploy the war file to Tomcat 7.0.52, Jetty, or any other container, as long as it supports servlet 3.0.


Technology Stack
==========

* Spring (http://spring.io/)

* Hibernate (http://hibernate.org/)

* HttpComponents (http://hc.apache.org/)

* Logback (http://logback.qos.ch/)

* MongoDB (http://www.mongodb.org/)

* Tomcat (http://tomcat.apache.org/)

* jQuery (http://jquery.com/)

* Bootstrap (http://getbootstrap.com/)

* Backbone (http://backbonejs.org/)

* Underscore (http://underscorejs.org/)

* RequireJS (http://requirejs.org/)

* https://github.com/mar10/fancytree/

* https://code.google.com/p/google-code-prettify/

* https://github.com/isagalaev/highlight.js/

* https://github.com/brianreavis/selectize.js/

* https://github.com/vitalets/x-editable/

* http://fortawesome.github.io/Font-Awesome/

* http://glyphicons.com/

Contribute
==========

You're interested in contributing to RESTFiddle? AWESOME. Here are the basic steps:

- Make sure you have a [GitHub Account](https://github.com/signup/free)
- Fork RESTFiddle from here : https://github.com/AnujaK/restfiddle
- Clone your fork  
- Make your changes
- Make sure everything is working fine
- Format your code (see below)
- Submit a pull request

##### Code formatting :

- If you're an Eclipse user, use the following code formatter : https://github.com/AnujaK/restfiddle/blob/master/tools/restfiddle_code_formatter.xml
- You should also activate automatic formatting and organizing imports on save.

##### GitHub help : 

- Forking a repo - https://help.github.com/articles/fork-a-repo
- Creating a pull request - https://help.github.com/articles/creating-a-pull-request
- Syncing a fork - https://help.github.com/articles/syncing-a-fork

##### Google Group : 

https://groups.google.com/forum/#!forum/restfiddle

##### Meetup Group : 

http://www.meetup.com/RESTFiddle

##### Gitter :

https://gitter.im/AnujaK/restfiddle

##### Code Quality :

https://nemo.sonarqube.org/overview?id=com.restfiddle%3Arestfiddle

Releases
==========

https://github.com/AnujaK/restfiddle/releases

Support
==========

If you need help in setting up RESTFiddle for your Team/Organization, feel free to contact me at this [email address](mailto:contact@bootsimply.com).

Copyright and License
==========

Copyright 2015 BootSimply Solutions

Licensed under Apache License, Version 2.0
