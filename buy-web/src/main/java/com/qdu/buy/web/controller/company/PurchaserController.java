package com.qdu.buy.web.controller.company;


import com.qdu.buy.LicenseResourceService;
import com.qdu.buy.UpDownService;
import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.license.PurchaserLicenseService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;


//采购商控制层
@RestController
@Api(value = "/purchaser", description = "采购商接口层")
@RequestMapping("/purchaser")
@Slf4j
public class PurchaserController {

    @Autowired
    private PurchaserService purchaserService;

    @Autowired
    private LicenseResourceService licenseResourceService;

    @Autowired
    private PurchaserLicenseService purchaserLicenseService;

    @Autowired
    private UpDownService upDownService;


    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(Purchaser purchaser, HttpServletRequest request) throws Exception {
        log.info("进入采购商login部分-------------"+purchaser.toString());
        //获取登录用户名和密码
        Map<String,Object> result=new HashMap<>();
        String phone = purchaser.getPhone();
        String password = purchaser.getPassword();
        Purchaser purchaser1=purchaserService.selectByPhoneAndPassword(phone,password);
        HttpSession session=request.getSession();
        if(purchaser1==null){
            result.put("result","0");
            result.put("msg","用户名或密码错误");
        }
        else{
            if(purchaser1.getStatus().equals("0")){
                result.put("result","2");
                result.put("msg","您还尚未进行企业信息认证 是否现在认证?");
                result.put("id",purchaser1.getId());
            }
            else{
                result.put("result","1");
                result.put("msg","登录成功！");
                session.setAttribute("user",purchaser1);
                session.setMaxInactiveInterval(1800);
            }
        }
        return result;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public Map<String,Object> register(Purchaser purchaser, HttpServletRequest request) throws Exception {
        Map<String,Object> result=new HashMap<String,Object>();
        log.info("进入purchaser-register部分-------------"+purchaser.toString());
        Long id=null;
        // TODO: 2018/4/29  判断是否是重复注册
        List<Purchaser> purchasers=purchaserService.selectByPhone(purchaser.getPhone());
        if(purchasers!=null&&purchasers.size()!=0){
                result.put("result","0");
                result.put("msg","手机号已经注册");
        }
        else{
            //添加注册信息
            result.put("result","1");
            id= purchaserService.insertSelective(purchaser);
            result.put("id",id);
        }
        //直接跳去上传相关凭证 执照页面
        return result;
    }

    @RequestMapping(value="/addPurchaserProves")
    public ModelAndView addPurchaserProves(
            @RequestParam(value="authorised") MultipartFile authorised,
            @RequestParam(value="businessLicense") MultipartFile businessLicense,
            @RequestParam(value="registration") MultipartFile registration,
            HttpServletRequest request,@RequestParam(value = "purchaserId") Long purchaserId) throws IOException{
               Long authorisedId=null;
               Long  businessLicenseId=null;
               Long registrationId=null;
            //上传三个文件到指定的路径 并且返回对应的资源id
            try{
                String url1=upDownService.updateHead(authorised);
                String url2=upDownService.updateHead(businessLicense);
                String url3=upDownService.updateHead(registration);
                Purchaser purchaser=new Purchaser();
                purchaser.setId(purchaserId);
                purchaser.setStatus("1");
                purchaserService.updateByPrimaryKeySelective(purchaser);
//                purchaserLicenseService.insert(purchaserId,authorisedId,"1");
                businessLicenseId=licenseResourceService.uploadFile(businessLicense,request);
//                purchaserLicenseService.insert(purchaserId,businessLicenseId,"2");
//                registrationId=licenseResourceService.uploadFile(registration,request);
//                purchaserLicenseService.insert(purchaserId,registrationId,"3");
                }catch(Exception ex) {
                    log.error("上传文件失败" + ex.getMessage(), ex);
                    ModelAndView modelAndView=new ModelAndView("forward:/toConfirm");
                    modelAndView.addObject("purchaserId",purchaserId);
                    return new ModelAndView("forward:/toConfirm");
            }
        return new ModelAndView("login");
    }




}