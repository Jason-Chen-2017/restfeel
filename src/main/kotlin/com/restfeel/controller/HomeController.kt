package com.restfeel.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by jack on 2017/3/30.
 */

@Controller
class HomeController {
    internal var logger = LoggerFactory.getLogger(AppController::class.java)

    @Value("\${application.message:REST Feel}")
    private val message = "REST Feel"

    @RequestMapping("/")
    fun home(model: MutableMap<String, Any>, request: HttpServletRequest, response: HttpServletResponse): String {
        model.put("time", Date())
        model.put("message", this.message)
        val authentication = SecurityContextHolder.getContext().authentication
        val currentUser  =if (authentication == null) null!! else authentication.principal as UserDetails
        model.put("currentUser", currentUser)

        // put currentUser into session
        request.getSession().setAttribute("currentUser",currentUser)
        return "jsp/home"
    }

    @RequestMapping(value = "/oauth/response", method = arrayOf(RequestMethod.GET))
    fun method(request: HttpServletRequest): String {
        return "jsp/oauth-response"
    }
}
