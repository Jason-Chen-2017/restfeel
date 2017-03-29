package com.restfeel.advice

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.ModelAndView


/**
 * Created by jack on 2017/3/30.
 */
@ControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception::class)
    fun exception(exception: Exception, request: WebRequest): ModelAndView {
        val modelAndView = ModelAndView("jsp/error")//error页面
        modelAndView.addObject("errorMessage", exception.message)
        modelAndView.addObject("stackTrace", exception.stackTrace)
        return modelAndView

    }
}
