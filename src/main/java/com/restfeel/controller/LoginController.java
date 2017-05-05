///*
// * Copyright 2014 Ranjan Kumar
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.restfeel.controller;
//
//import java.util.Map;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@EnableAutoConfiguration
//@ComponentScan
//public class LoginController {
//
//    @RequestMapping("/login")
//    public String login(Map<String, Object> model) {
//        return "jsp/login";
//    }
//}

//放在WebMvcConfig类里了：registry!!.addViewController("/login").setViewName("jsp/login")
//
//    override fun addViewControllers(registry: ViewControllerRegistry?) {
//    //这一段等同于com.restfeel.controller.LoginController，静态资源的拦截处理在com.restfeel.config.security.SecurityConfig设置
//    // println("注册Controller： registry.addViewController(\"/login\").setViewName(\"login\")")
//    registry!!.addViewController("/login").setViewName("jsp/login")
//    //写文章RequestMapping
//    registry.addViewController("/addBlog").setViewName("jsp/blog/add")
//    }
