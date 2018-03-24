package com.qdu.buy.web.controller;


//用户接口层

import com.bwton.dist.annotation.OperationLog;
import com.qdu.buy.domain.UserQuery;
import com.qdu.buy.domain.po.User;
import com.qdu.buy.domain.vo.UserVo;
import com.qdu.buy.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
            result.setViewName("index");
            result.addObject("user",user1);
            session.setAttribute("user",user);
        }
        return result;
    }

}