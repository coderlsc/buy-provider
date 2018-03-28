package com.qdu.buy.web.controller.company;


import com.qdu.buy.company.SupplierService;
import com.qdu.buy.domain.po.User;
import com.qdu.buy.domain.po.company.Supplier;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//供应商控制层
@RestController
@Api(value = "/supplier", description = "供应商接口层")
@RequestMapping("/supplier")
@Slf4j
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping(value = "/login")
    public ModelAndView login(Supplier supplier, HttpServletRequest request) throws Exception {
        log.info("进入供应商login部分-------------"+supplier.getEmail()+supplier.getPassword());
        //获取登录用户名和密码
        String userName = supplier.getEmail();
        String password = supplier.getPassword();
        //User user1=companyService.verifyUser(userName,password);
        ModelAndView result=new ModelAndView();
        HttpSession session=request.getSession();
        if(supplier==null){
            result.setViewName("login");
            result.addObject("msg","用户名或密码错误");
        }
        else{
            result.setViewName("redirect:/toIndex");
            result.addObject("user",supplier);
            session.setAttribute("supplier",supplier);
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
//        User user1=userService.verifyUser(userName,password);
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