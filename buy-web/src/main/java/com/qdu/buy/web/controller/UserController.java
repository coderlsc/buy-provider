package com.qdu.buy.web.controller;


//用户接口层

import com.qdu.buy.domain.po.User;
import com.qdu.buy.user.UserService;
import com.qdu.buy.util.PhoneUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/user", description = "用户管理接口")
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("")
    public ModelAndView index() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index");
        return mv;
    }



    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("login");
    }

    @PostMapping(value = "/login")
    public ModelAndView login(User user, HttpServletRequest request) throws Exception {
        log.info("进入login部分-------------"+user.getUserName()+user.getPassword());
        //获取登录用户名和密码
        String userName = user.getUserName();
        String password = user.getPassword();
        User user1=userService.verifyUser(userName,password);
        ModelAndView result=new ModelAndView();
        HttpSession session=request.getSession();
        if(user1==null){
            result.setViewName("login");
            result.addObject("msg","用户名或密码错误");
        }
        else{
            result.setViewName("redirect:/toIndex");
            result.addObject("user",user1);
            session.setAttribute("user",user);
        }
        return result;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(User user, HttpServletRequest request) throws Exception {
        log.info("进入register部分-------------"+user.getUserName()+user.getPassword());
        //获取登录用户名和密码

        //获取对应的数据  插入到数据库
        String userName = user.getUserName();
        String password = user.getPassword();
        User user1=userService.verifyUser(userName,password);
        ModelAndView result=new ModelAndView();
        HttpSession session=request.getSession();
        if(user1==null){
            result.setViewName("login");
            result.addObject("msg","用户名或密码错误");
        }
        else{
            result.setViewName("redirect:/toIndex");
            result.addObject("user",user1);
            session.setAttribute("user",user);
        }
        return result;
    }

    //验证码校验
    @RequestMapping(value = "validateCode")
    public Map<String,Object> validateCode(@RequestParam(value = "code")String code,HttpServletRequest request){

        HttpSession session=request.getSession();
        String currentCode=(String) session.getAttribute("code");
        Map<String,Object> result=new  HashMap<String,Object>();
        if(!currentCode.equals(code)){
            result.put("success","error");// TODO: 2018/3/30  需要细致考虑各种情况
        }
        else{
            result.put("success","right");
        }
        return result;

    }
    //sendCode验证码发送
    @RequestMapping(value = "sendCode")
    public Map<String,Object> sendCode(){
        try{

        }catch(Exception e){


        }

        return null;
    }



}