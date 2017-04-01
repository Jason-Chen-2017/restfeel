//package com.restfeel.config
//
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Profile
//import java.nio.charset.Charset
//
//
///**
// * Created by jack on 2017/4/2.
// */
//@Configuration
//class TomcatConfiguare {
//
//    /**
//
//     * 特定配置，仅配置tomcat
//     * 优先级由高到低如下：
//     * application.properties中自定义配置----->TomcatEmbeddedServletContainerFactory中的对应容易配置。
//     */
//    @Bean
//    @Profile(*arrayOf("devlopment", "default"))
//    fun tomcatEmbeddedServletContainerFactory(): TomcatEmbeddedServletContainerFactory {
//        val tomcat = TomcatEmbeddedServletContainerFactory()
//        tomcat.uriEncoding = Charset.forName("UTF-8")
//        //server.max-http-header-size = 1024*1024
//        //Maximum size in bytes of the HTTP message header.
//
//        return tomcat
//    }
//
//}
