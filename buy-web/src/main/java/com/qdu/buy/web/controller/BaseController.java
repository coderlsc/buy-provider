package com.qdu.buy.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("baseController")
@Slf4j
public class BaseController {


    //去登陆页面
    @RequestMapping(value = "toLogin")
    public ModelAndView tologin(){
        log.info("即将转向登录页面================");
        return new ModelAndView("login");
    }


    //去首页
    @RequestMapping(value = "toIndex")
    public ModelAndView toIndex(){
        ModelAndView modelAndView=new ModelAndView("index");
        return modelAndView;
    }

    //去首页
    @RequestMapping(value = "toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value="index")
    public String index(){
        return "index";
    }




}