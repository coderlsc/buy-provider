package com.qdu.buy.web.controller.company;


import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.domain.po.company.Purchaser;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//采购商控制层
@RestController
@Api(value = "/purchaser", description = "采购商接口层")
@RequestMapping("/purchaser")
@Slf4j
public class PurchaserController {

    @Autowired
    private PurchaserService purchaserService;


    @PostMapping(value = "/login")
    public ModelAndView login(Purchaser purchaser, HttpServletRequest request) throws Exception {
        log.info("进入采购商login部分-------------"+purchaser.toString());
        //获取登录用户名和密码
        String userName = purchaser.getEmail();
        String password = purchaser.getPassword();
        //User user1=companyService.verifyUser(userName,password);
        ModelAndView result=new ModelAndView();
        HttpSession session=request.getSession();
        if(purchaser==null){
            result.setViewName("login");
            result.addObject("msg","用户名或密码错误");
        }
        else{
            result.setViewName("redirect:/toIndex");
            result.addObject("user",purchaser);
            session.setAttribute("user",purchaser);
        }
        return result;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(Purchaser purchaser, HttpServletRequest request) throws Exception {
        log.info("进入register部分-------------"+purchaser.toString());
        //获取登录用户名和密码

        //获取对应的数据  插入到数据库
        String email = purchaser.getEmail();
        String password = purchaser.getPassword();
//        User user1=purchaserService.verifyUser(userName,password);
        ModelAndView result=new ModelAndView();
        HttpSession session=request.getSession();
//        if(user1==null){
//            result.setViewName("login");
//            result.addObject("msg","用户名或密码错误");
//        }
//        else{
//            result.setViewName("redirect:/toIndex");
//            result.addObject("user",user1);
//            session.setAttribute("user",user);
//        }
        return result;
    }




}