package com.restfeel.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by jack on 2017/3/29.
 */
@Configuration
class WebMvcConfig : WebMvcConfigurerAdapter(){
    override fun configureViewResolvers(registry: ViewResolverRegistry?) {
        //等同于在配置文件中配置：
        //spring.view.prefix=/WEB-INF/jsp/
        //spring.view.suffix=.jsp
        registry!!.jsp("/WEB-INF/jsp/", ".jsp")
        //registry.freeMarker();
        //registry.velocity();
        //registry.groovy();
    }

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        //这一段等同于com.restfeel.controller.LoginController，静态资源的拦截处理在com.restfeel.config.security.SecurityConfig设置
        println("注册Controller： registry.addViewController(\"/login\").setViewName(\"login\")")
        registry!!.addViewController("/login").setViewName("login")
    }
}