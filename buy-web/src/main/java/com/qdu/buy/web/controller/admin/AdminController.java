package com.qdu.buy.web.controller.admin;


import com.qdu.buy.LicenseResourceService;
import com.qdu.buy.admin.AdminService;
import com.qdu.buy.domain.po.admin.Admin;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


//采购商控制层
@Controller
@Api(value = "/admin", description = "管理员接口层")
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private LicenseResourceService licenseResourceService;


    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(Admin admin, HttpServletRequest request) throws Exception {
        Map<String,Object> map=new HashMap<>();
        log.info("进入管理员login部分-------------"+admin.toString());
        //获取登录用户名和密码
        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin admin1=adminService.queryAdminByUsernameandPwd(username,password);
        ModelAndView result=new ModelAndView();
        HttpSession session=request.getSession();
        if(admin1==null){
            result.setViewName("admin_login");
            result.addObject("msg","用户名或密码错误");
            map.put("result","2");
        }
        else{
            result.setViewName("redirect:/admin/toIndex");
            result.addObject("admin",admin1);
            session.setAttribute("admin",admin1);
            session.setMaxInactiveInterval(1800);
            map.put("result","1");
        }
        return map;
    }



    @RequestMapping(value="home")
    public String home(){
        return "home";
    }


    @RequestMapping(value="advertising")
    public String advertising(){
        return "advertising";
    }

    @RequestMapping(value="addcontent")
    public String addcontent(){
        return "addcontent";
    }

    @RequestMapping(value="user_list")
    public String user_list(){
        return "user_list";
    }


    @RequestMapping(value="item_list")
    public String item_list(){
        return "item_list";
    }

    @RequestMapping(value="add_item")
    public String add_item(){
        return "add_item";
    }



//    @PostMapping(value = "/register")
//    public ModelAndView register(Admin admin, HttpServletRequest request) throws Exception {
//        log.info("进入purchaser-register部分-------------"+admin.toString());
//        Long id=null;
//        // TODO: 2018/4/29  判断是否是重复注册
//        List<Purchaser> purchasers=adminService.queryAdminByUsernameandPwd(admin.getPhone());
//        if(purchasers!=null&&purchasers.size()!=0){
//            id= purchasers.get(0).getId();
//        }
//        else{
//            //添加注册信息
//            id= adminService.insert(admin);
//        }
//        //跳转到登录页面
//        ModelAndView result=new ModelAndView();
//        result.addObject("purchaserId",id);//携带采购商id过去
//        result.setViewName("forward:/toConfirm");
//        //直接跳去上传相关凭证 执照页面
//        return result;
//    }




}