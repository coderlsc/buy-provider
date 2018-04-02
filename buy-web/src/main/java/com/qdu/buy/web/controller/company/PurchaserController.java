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
        String phone = purchaser.getPhone();
        String password = purchaser.getPassword();
        Purchaser purchaser1=purchaserService.selectByPhoneAndPassword(phone,password);
        ModelAndView result=new ModelAndView();
        HttpSession session=request.getSession();
        if(purchaser1==null){
            result.setViewName("login");
            result.addObject("msg","用户名或密码错误");
        }
        else{
            result.setViewName("redirect:/toIndex");
            result.addObject("purchaser",purchaser1);
            session.setAttribute("purchaser",purchaser1);
        }
        return result;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(Purchaser purchaser, HttpServletRequest request) throws Exception {
        log.info("进入purchaser-register部分-------------"+purchaser.toString());

        //添加注册信息
       Long id= purchaserService.insertSelective(purchaser);

        //跳转到登录页面
        ModelAndView result=new ModelAndView();
        result.addObject("purchaserId",id);//携带采购商id过去
        result.setViewName("forward:/toConfirm");
        //直接跳去上传相关凭证 执照页面
        return result;
    }




}