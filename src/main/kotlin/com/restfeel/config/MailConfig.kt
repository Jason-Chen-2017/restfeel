package com.restfeel.config

import com.sendgrid.SendGrid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*

/**
 * Created by jack on 2017/3/29.
 */
@Configuration
class MailConfig {
    @Autowired
    private val env: Environment? = null

    @Bean
    fun javaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        val mailProperties = Properties()

        mailSender.protocol = env!!.getProperty("mail.protocol")
        mailSender.host = env?.getProperty("mail.host")
        mailSender.port = Integer.parseInt(env?.getProperty("mail.port"))

        mailSender.username = env?.getProperty("mail.username")
        mailSender.password = env?.getProperty("mail.password")

        mailProperties.put("mail.smtp.auth", env?.getProperty("mail.smtp.auth"))
        mailProperties.put("mail.smtp.starttls.enable", env?.getProperty("mail.smtp.starttls.enable"))
        mailProperties.put("mail.smtp.debug", env?.getProperty("mail.smtp.debug"))

        mailProperties.put("mail.smtp.socketFactory.port", "465")
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")

        mailProperties.put("mail.smtps.ssl.trust", env?.getProperty("mail.smtps.ssl.trust"))
        mailProperties.put("mail.smtps.ssl.checkserveridentity", env?.getProperty("mail.smtps.ssl.checkserveridentity"))

        mailSender.javaMailProperties = mailProperties

        return mailSender
    }

    @Bean
    fun sendGrid(): SendGrid {
        val sendgrid = SendGrid(env!!.getProperty("sendgrid.username"), env?.getProperty("sendgrid.password"))
        return sendgrid
    }
}
