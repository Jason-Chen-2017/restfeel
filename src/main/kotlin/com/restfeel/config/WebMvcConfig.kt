package com.restfeel.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by jack on 2017/3/29.
 */
@Configuration
class WebMvcConfig : WebMvcConfigurerAdapter() {
    /**
     * 统一注册纯RequestMapping跳转View的Controller
     */
    override fun addViewControllers(registry: ViewControllerRegistry?) {
        //这一段等同于com.restfeel.controller.LoginController，静态资源的拦截处理在com.restfeel.config.security.SecurityConfig设置
        // println("注册Controller： registry.addViewController(\"/login\").setViewName(\"login\")")
        registry!!.addViewController("/login").setViewName("jsp/login")
        //写文章RequestMapping
        registry.addViewController("/addBlog").setViewName("jsp/blog/add")
    }

    override fun configureViewResolvers(registry: ViewResolverRegistry?) {
        //等同于在配置文件中配置：
        //spring.view.prefix=/WEB-INF/jsp/
        //spring.view.suffix=.jsp
        registry!!.jsp("/WEB-INF/", ".jsp") // springboot约定目录
//        //jsp
//        val jspResolver = InternalResourceViewResolver()
//        jspResolver.setPrefix("/WEB-INF/")
//        jspResolver.setSuffix(".jsp")
//        registry!!.viewResolver(jspResolver)

//        //velocity
//        val vmResolver = VelocityViewResolver()
//        vmResolver.setPrefix("/WEB-INF/")
//        vmResolver.setSuffix(".vm")
//        registry.viewResolver(vmResolver)
//        //freemarker
//        val freemarkerResolver = FreeMarkerViewResolver()
//        freemarkerResolver.setPrefix("/WEB-INF/")
//        freemarkerResolver.setSuffix(".ftl")
//        registry.viewResolver(freemarkerResolver)

    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }


}
