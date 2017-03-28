package com.restfeel.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jack on 2017/3/28.
 * WebMvcConfig配置总类
 *
 * @author jack
 * @date 2017/03/28
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //等同于在配置文件中配置：
        //spring.view.prefix=/WEB-INF/jsp/
        //spring.view.suffix=.jsp
        registry.jsp("/WEB-INF/jsp/", ".jsp");
        //registry.freeMarker();
        //registry.velocity();
        //registry.groovy();
    }


    @Override
    public void  addViewControllers(ViewControllerRegistry registry){
        //这一段等同于com.restfeel.controller.LoginController，静态资源的拦截处理在com.restfeel.config.security.SecurityConfig设置
        System.out.println("注册Controller： registry.addViewController(\"/login\").setViewName(\"login\")");
        registry.addViewController("/login").setViewName("login");
    }

}
