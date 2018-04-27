package com.qdu.buy.web.controller.company;


import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.po.resource.LicenseResource;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
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
import java.util.UUID;


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

    @RequestMapping(value="/addPurchaserProves")
    public String addPurchaserProves(
            @RequestParam(value="prove") MultipartFile[] pic,
            HttpSession session,
            HttpServletRequest request,@RequestParam(value = "purchaserId") String purchaserId) throws IOException{


           Long proveResourceid=null;
        //licenseResourceid=licenseService.uploadFile(resource,request);
//        System.out.println(purchaserId+"====================");
//        //添加采购商
//
//        //循环上传所有证明文件
//        if(pic.length!=0&&pic!=null){
//            int i=0;
//            for(MultipartFile file:pic){
//                //上传文件 返回license_resource_id 资源id 给
//                //uploadProves(file,purchaserId,"purchaser");
//
//                String name=file.getName();
//                String originalName=file.getOriginalFilename();
//                String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
//                String newname= UUID.randomUUID().toString()+"."+suffix;
//                String path=request.getServletContext().getRealPath("/image/"+newname);
//                String savepath="/image/"+newname;
//                log.info("文件保存路径是："+path);
//                InputStream is=file.getInputStream();
//                OutputStream os=new FileOutputStream(new File(path));
//                int length=0;
//                byte[] data=new byte[1024<<3];
//                while((length=is.read(data))!=-1){
//                    os.write(data,0, length);
//                }
//                os.close();
//                is.close();
//                //持久化到数据库中  添加公司文件对象记录到数据库中
//                LicenseResource bookPic=new LicenseResource();
////                bookPic.setBookid(bookid);
////                bookPic.setFm(i==(Integer.parseInt(fm))?"1":"0");
////                bookPic.setSavepath(savepath);
////                bookPic.setShowname(originalName);
////                picService.addBookPic(bookPic);
//                i++;
//            }
//        }
//        //重定向到首页
//        return "redirect:/addbook.jsp";
        return null;
    }




}