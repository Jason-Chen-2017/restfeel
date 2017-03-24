/*
 * Copyright 2014 Ranjan Kumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.restfiddle;

import org.springframework.boot.SpringApplication;

/**
 * 应用入口类 main函数
 *
 * @author Jason
 *         2017.3.23 李思琪
 */

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.restfiddle"})
//@SpringBootApplication
@RestBoot
public class RestFiddleApplication {
    public RestFiddleApplication() {
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestFiddleApplication.class, args);
    }

    //static {
    //
    //    System.out.println("启动MongoDB ...... ");
    //    MongodExecutable mongodExecutable = null;
    //
    //    try {
    //        MongodStarter starter = MongodStarter.getDefaultInstance();
    //
    //        String bindIp = "localhost";
    //        int port = 12345;
    //        IMongodConfig mongodConfig = new MongodConfigBuilder()
    //            .version(Version.Main.PRODUCTION)
    //            .net(new Net(bindIp, port, Network.localhostIsIPv6()))
    //            .build();
    //
    //        mongodExecutable = starter.prepare(mongodConfig);
    //        MongodProcess mongod = mongodExecutable.start();
    //
    //        MongoClient mongo = new MongoClient(bindIp, port);
    //        DB db = mongo.getDB("test");
    //        DBCollection col = db.createCollection("testCol", new BasicDBObject());
    //        col.save(new BasicDBObject("testDoc", new Date()));
    //    } catch (Exception e) {
    //        System.out.println("启动MongoDB异常：" + e.getMessage());
    //        e.printStackTrace();
    //
    //    } finally {
    //        if (mongodExecutable != null) { mongodExecutable.stop(); }
    //    }
    //
    //}

}
