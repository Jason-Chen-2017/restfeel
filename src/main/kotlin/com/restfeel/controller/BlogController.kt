package com.restfeel.controller

import com.restfeel.entity.Blog
import com.restfeel.service.BlogService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*
import javax.servlet.http.HttpServletRequest

/**
 * 文章列表，写文章的Controller
 * @author Jason Chen  2017/3/31 01:10:16
 */

@Controller
@EnableAutoConfiguration
@ComponentScan
@Transactional(propagation = Propagation.REQUIRES_NEW)
class BlogController(val blogService: BlogService) {
    @GetMapping("/blogs.do")
    fun listAll(model: Model): String {
        val authentication = SecurityContextHolder.getContext().authentication
        model.addAttribute("currentUser", if (authentication == null) null else authentication.principal as UserDetails)
        val allblogs = blogService.findAll()
        model.addAttribute("blogs", allblogs)
        return "jsp/blog/list"
    }

    @PostMapping("/saveBlog")
    @ResponseBody
    fun saveBlog(blog: Blog, request: HttpServletRequest):Blog {
        blog.author = (request.getSession().getAttribute("currentUser") as UserDetails).username
        return blogService.save(blog)
    }

    @GetMapping("/goEditBlog")
    fun goEditBlog(@RequestParam(value = "id") id: String, model: Model): String {
        model.addAttribute("blog", blogService.findOne(id))
        return "jsp/blog/edit"
    }

    @PostMapping("/editBlog")
    @ResponseBody
    fun editBlog(blog: Blog, request: HttpServletRequest) :Blog{
        blog.author = (request.getSession().getAttribute("currentUser") as UserDetails).username
        blog.gmtModified = Date()
        blog.version = blog.version + 1
        return blogService.save(blog)
    }

    @GetMapping("/blog")
    fun blogDetail(@RequestParam(value = "id") id: String, model: Model): String {
        model.addAttribute("blog", blogService.findOne(id))
        return "jsp/blog/detail"
    }

    @GetMapping("/listblogs")
    @ResponseBody
    fun listblogs(model: Model) = blogService.findAll()

    @GetMapping("/findBlogByTitle")
    @ResponseBody
    fun findBlogByTitle(@RequestParam(value = "title") title: String) = blogService.findByTitle(title)

}
