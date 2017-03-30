package com.restfeel.controller

import com.restfeel.entity.Blog
import com.restfeel.service.BlogService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

/**
 * * 注意:
 *      这里要使用@Controller注解
 *      而不要使用@RestController
 *      否则return "index";只是返回字符串"index"， 不能跳转到index.html
 *
 *      @RestController is a stereotype annotation that combines @ResponseBody and @Controller.
 *      @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 */

@Controller
@EnableAutoConfiguration
@ComponentScan
@Transactional(propagation = Propagation.REQUIRES_NEW)
class BlogController(val blogService: BlogService) {
    @GetMapping("/blogs.do")
    fun listAll(model: Model): String {

        val now = Date()
        val initBlog = Blog()
        initBlog.title = "SpringBoot极简教程"
        initBlog.author = "JasonChen"
        initBlog.content = "SpringBoot极简教程 发表时间："+now
        initBlog.gmtCreated = now
        initBlog.gmtModified = now
//        val initBlog = Blog("SpringBoot极简教程", "SpringBoot极简教程" + now, "JasonChen", now, now, 0, now, now.time, 0)
        blogService.save(initBlog)

        val allblogs = blogService.findAll()
        model.addAttribute("blogs", allblogs)
        return "jsp/blog/list"
    }

    @GetMapping("/listblogs")
    @ResponseBody
    fun listblogs(model: Model) = blogService.findAll()

    @GetMapping("/findBlogByTitle")
    @ResponseBody
    fun findBlogByTitle(@RequestParam(value = "title") title: String) = blogService.findByTitle(title)

}
