package com.qdu.buy.web.controller.admin;


import com.qdu.buy.LicenseResourceService;
import com.qdu.buy.admin.AdminService;
import com.qdu.buy.domain.po.User;
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


    @PostMapping(value = "/register")
    public Map<String,Object> register(@RequestBody Map map) throws Exception {
        log.info("注册------------------");
        Map<String,Object> result=new HashMap<>();
        String userName = map.get("username")+"";
        String password =  map.get("password")+"";
        Admin admin=adminService.queryAdminByUsernameandPwd(userName,password);
        if(admin==null){
            adminService.insert(admin);
            result.put("success","1");
        }
        else{
            result.put("success","0");
        }
        return result;
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


    @RequestMapping(value="admin_info")
    public String v(){
        return "admin_info";
    }


    @RequestMapping(value = "/invalidateAdmin")
    public String invalidateAdmin(HttpServletRequest request){
        HttpSession session=request.getSession();
        Admin admin=(Admin)session.getAttribute("admin");
        if(admin==null){

        }
        else
        {
            session.removeAttribute("admin");//退出账号
        }
        return "forward:/adminLogin";
    }


    @PostMapping(value = "/modifyPwd")
    @ResponseBody
    public Map<String,Object> modifyPwd(String newpwd,String oldpwd, HttpServletRequest request) throws Exception {
        Map<String,Object> map=new HashMap<>();
        //获取登录用户名和密码
        Admin admin=(Admin)request.getSession().getAttribute("admin");
        HttpSession session=request.getSession();
        if(admin==null){
            map.put("result","2");
            map.put("msg","您尚未登录");
        }
        else{
            if(admin.getPassword().equals(oldpwd)){
                map.put("result","0");
                map.put("msg","原密码不正确！");
            }
            else {
                Admin admin1=new Admin();
                admin1.setId(admin.getId());
                admin1.setPassword(newpwd);
                adminService.updateByPrimaryKeySelective(admin1);
                map.put("result","1");
                map.put("msg","修改成功！ 请重新登录");
                session.removeAttribute("admin");
            }

        }
        return map;
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