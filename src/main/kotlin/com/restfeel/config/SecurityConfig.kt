package com.restfeel.config

import com.restfeel.security.RfUserDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Created by jack on 2017/3/29.
 */


@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    private val rfUserDetailService: RfUserDetailService? = null

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<RfUserDetailService>(rfUserDetailService).passwordEncoder(this.passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()

        http.authorizeRequests()
                .antMatchers("/api/**", "/about", "/fonts/**", "/css/**", "/img/**", "/js/**", "/less/**",
                        "/scss/**")//默认不拦截静态资源等url pattern
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/login")
                .failureUrl("/login?error").permitAll()

        http.logout().logoutSuccessUrl("/")
    }

}
