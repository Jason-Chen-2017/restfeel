package com.restfeel

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.core.env.Environment

/**
 * Created by jack on 2017/3/29.
 * @author jack
 * @date 2017/03/29
 */
@RestFeelBoot
class RestFeelApplicationKotlin : CommandLineRunner {
    @Autowired
    private val env: Environment? = null

    override fun run(vararg args: String?) {
        println("RESTFEEL 启动完毕")
        println("应用地址：" + env?.getProperty("application.host-uri"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(RestFeelApplicationKotlin::class.java, *args)
}
