package com.restfeel.advice

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.ModelAndView


/**
 * Created by jack on 2017/3/30.
 *
 * 系统异常全局统一处理
 */
@ControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception::class) //表示捕捉到所有的异常，你也可以捕捉一个你自定义的异常
    fun exception(exception: Exception, request: WebRequest): ModelAndView {
        val modelAndView = ModelAndView("jsp/error")//error页面
        modelAndView.addObject("errorMessage", exception.message)
        modelAndView.addObject("stackTrace", exception.stackTrace)
        return modelAndView

    }
}
