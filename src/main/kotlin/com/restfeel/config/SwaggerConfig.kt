package com.restfeel.config

import com.mangofactory.swagger.configuration.SpringSwaggerConfig
import com.mangofactory.swagger.models.dto.ApiInfo
import com.mangofactory.swagger.plugin.EnableSwagger
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by jack on 2017/3/29.
 */
@Configuration
@EnableSwagger
class SwaggerConfig {
    private var springSwaggerConfig: SpringSwaggerConfig? = null

    @Autowired
    fun setSpringSwaggerConfig(springSwaggerConfig: SpringSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig
    }

    @Bean
    fun customImplementation(): SwaggerSpringMvcPlugin {
        return SwaggerSpringMvcPlugin(this.springSwaggerConfig!!).apiInfo(apiInfo()).includePatterns(".*api.*")
    }

    private fun apiInfo(): ApiInfo {
        val apiInfo = ApiInfo("RESTFeel",
                "RESTFeel is an Enterprise-grade API Management Platform for Teams. It helps you design, develop, test and release APIs.", "", "",
                "", "")
        return apiInfo
    }
}
