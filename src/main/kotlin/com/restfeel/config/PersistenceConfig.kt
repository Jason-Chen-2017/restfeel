package com.restfeel.config

import com.mongodb.Mongo
import com.mongodb.MongoClient
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by jack on 2017/3/29.
 */


@Configuration
@EnableMongoRepositories(*arrayOf("com.restfeel.dao", "com.restfeel.service"))
class PersistenceConfig : AbstractMongoConfiguration() {

    @Autowired
    private val env: Environment? = null

    override fun getDatabaseName(): String {
        return env!!.getProperty("mongodb.name")
    }


    @Bean
    @Throws(Exception::class)
    override fun mongo(): Mongo {
        return MongoClient(listOf(ServerAddress(env!!.getProperty("mongodb.host"), env!!.getProperty("mongodb.port", Int::class.java))),
                listOf(MongoCredential
                        .createCredential(env!!.getProperty("mongodb.username"), env!!.getProperty("mongodb.name"),
                                env!!.getProperty("mongodb.password").toCharArray())))
    }

//    override fun getMappingBasePackage(): String {
//        return "com.restfiddle.dao"
//    }

    /**
     * 这地方是配置扫描继承Repository类的所有接口类的路径的，路径配置错误，bean就不会创建了。
     * 东海陈光剑 Jason Chen @蒋村花园如意苑 2017.3.30 01:41:35
     */
    override fun getMappingBasePackages(): Collection<String> {
        return setOf("com.restfeel.dao", "com.restfeel.service")
    }
}
