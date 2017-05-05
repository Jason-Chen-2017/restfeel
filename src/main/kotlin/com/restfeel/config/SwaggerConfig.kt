package com.restfeel.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2 //Indicates that Swagger support should be enabled.
class SwaggerConfig {

    /**
     * Docket: Springfox’s, primary api configuration mechanism is initialized for swagger specification 2.0
     *
     * A builder which is intended to be the primary interface into the swagger-springmvc framework.
     * Provides sensible defaults and convenience methods for configuration.
     * @return
     */
    @Bean
    fun myApi(): Docket {

        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.restfeel"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()

    }

    fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
                .title("Spring Boot集成Swagger2构建自动化Rest API文档")
                .description("Spring Boot开发从0到1教程")
                .version("1.0")
                .build()
    }
}


//
//import com.mangofactory.swagger.configuration.SpringSwaggerConfig
//import com.mangofactory.swagger.models.dto.ApiInfo
//import com.mangofactory.swagger.plugin.EnableSwagger
//import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
///**
// * Created by jack on 2017/3/29.
// */
//@Configuration
//@EnableSwagger
//class SwaggerConfig {
//    private var springSwaggerConfig: SpringSwaggerConfig? = null
//
//    @Autowired
//    fun setSpringSwaggerConfig(springSwaggerConfig: SpringSwaggerConfig) {
//        this.springSwaggerConfig = springSwaggerConfig
//    }
//
//    @Bean
//    fun customImplementation(): SwaggerSpringMvcPlugin {
//        return SwaggerSpringMvcPlugin(this.springSwaggerConfig!!).apiInfo(apiInfo()).includePatterns(".*api.*")
//    }
//
//    private fun apiInfo(): ApiInfo {
//        val apiInfo = ApiInfo("RESTFeel",
//                "RESTFeel is an Enterprise-grade API Management Platform for Teams. It helps you design, develop, test and release APIs.", "", "",
//                "", "")
//        return apiInfo
//    }
//}
