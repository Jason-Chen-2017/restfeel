package com.restfeel.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

/**
 * Created by jack on 2017/3/29.
 */

@Configuration
@PropertySource(value = *arrayOf("classpath:common.properties"))
class ApplicationConfig {

    @Bean
    fun myPropertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer();
    }

    //静态类，伴生对象
    companion object {
        /**
         * Properties to support the 'test' mode of operation.
         */
        @Configuration
        @Profile(*arrayOf("devlopment", "default"))
        @PropertySource(value = *arrayOf("classpath:env-development.properties"))
        class Dev {
        }

        /**
         * Properties to support the 'test' mode of operation.
         */
        @Configuration
        @Profile("test")
        @PropertySource(value = *arrayOf("classpath:env-test.properties"))
        class Test {
        }

        /**
         * Properties to support the 'production' mode of operation.
         */
        @Configuration
        @Profile("production")
        @PropertySource(value = *arrayOf("classpath:env-production.properties"))
        class Production {
            // Define additional beans for this profile here
        }
    }


}