package com.qdu.buy.web.controller.company;


import com.bwton.dist.constant.Constants;
import com.netflix.discovery.converters.Auto;
import com.qdu.buy.LicenseResourceService;
import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.dao.resource.LicenseResourceDao;
import com.qdu.buy.domain.dto.LicenseResourceDto;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.po.license.PurchaserLicense;
import com.qdu.buy.license.PurchaserLicenseService;
import com.qdu.buy.util.FileUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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
        Long id=null;
        // TODO: 2018/4/29  判断是否是重复注册
        List<Purchaser> purchasers=purchaserService.selectByPhone(purchaser.getPhone());
        if(purchasers!=null&&purchasers.size()!=0){
            id= purchasers.get(0).getId();
        }
        else{
            //添加注册信息
            id= purchaserService.insertSelective(purchaser);
        }
        //跳转到登录页面
        ModelAndView result=new ModelAndView();
        result.addObject("purchaserId",id);//携带采购商id过去
        result.setViewName("forward:/toConfirm");
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
                authorisedId=licenseResourceService.uploadFile(authorised,request);
                purchaserLicenseService.insert(purchaserId,authorisedId,"1");
                businessLicenseId=licenseResourceService.uploadFile(businessLicense,request);
                purchaserLicenseService.insert(purchaserId,businessLicenseId,"2");
                registrationId=licenseResourceService.uploadFile(registration,request);
                purchaserLicenseService.insert(purchaserId,registrationId,"3");
                }catch(Exception ex) {
                log.error("上传文件失败" + ex.getMessage(), ex);
                ModelAndView modelAndView=new ModelAndView("forward:/toConfirm");
                modelAndView.addObject("purchaserId",purchaserId);
                return new ModelAndView("forward:/toConfirm");
            }
        return new ModelAndView("login");
    }




}