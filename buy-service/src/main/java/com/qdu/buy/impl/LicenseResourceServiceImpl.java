package com.qdu.buy.impl;

import com.bwton.dist.core.data.vo.DataResponse;
import com.bwton.dist.core.service.BaseService;
import com.bwton.dist.exception.BusinessException;
import com.qdu.buy.LicenseResourceService;
//import com.qdu.buy.dao.ResourceDao;
import com.qdu.buy.dao.resource.LicenseResourceDao;
import com.qdu.buy.domain.po.resource.LicenseResource;
import com.qdu.buy.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

//import com.qiniu.api.auth.digest.Mac;
//import com.qiniu.api.config.Config;
//import com.qiniu.api.io.IoApi;
//import com.qiniu.api.io.PutExtra;
//import com.qiniu.api.io.PutRet;
//import com.qiniu.api.rs.PutPolicy;

/**
 * Created by lsc on 2018/1/24.
 */
@Slf4j
@Service
public class LicenseResourceServiceImpl extends BaseService implements LicenseResourceService {

    @Autowired
    private LicenseResourceDao licenseResourceDao;
    /*
    @Autowired
    private CommonService commonService;*/

//    @Value("${ad.AccessKey}")
//    String AccessKey;
//
//    @Value("${ad.SecretKey}")
//    String SecretKey;
//
    @Value("${template.uploadPath}")
    String uploadPath;
//
//    @Value("${ad.bucketname}")
//    String bucketname;
    @Override
    public Long insert(LicenseResource resource) {
        resource.setCreateTime(new Date());
        resource.setCreateUser(this.getCurrentUser().getUserName());
        resource.setUpdateTime(new Date());
        resource.setUpdateUser(this.getCurrentUser().getUserName());
        licenseResourceDao.insert(resource);
        return resource.getId();
    }

    @Override
    public Long uploadFile(MultipartFile resource, HttpServletRequest request)throws BusinessException{
        String fileName = resource.getOriginalFilename();//获取文件名
        String extension= FilenameUtils.getExtension(fileName);//获取后缀 .jpg .png ....
        String newName= UUID.randomUUID().toString().substring(0,32)+"."+extension;
        try {
            FileUtil.uploadFile(resource,newName,uploadPath);
        } catch (Exception e) {
            throw new BusinessException(DataResponse.ERRCODE_UNDEFINED,e.getMessage());
        }

        //持久层添加 插入资源信息到资源表中去
        LicenseResource licenseResource=new LicenseResource();
        try {
            licenseResource.setResourceType("2");
            licenseResource.setResourceName(fileName);//文件的名字
            licenseResource.setResourceNewName(newName);//保存文件新名字
            licenseResource.setResourceUploadPatch(uploadPath+"/"+newName);//直接可以访问的路径
            licenseResource.setCreateTime(new Date());
            licenseResource.setCreateUser(this.getCurrentUser().getUserName());
            licenseResource.setUpdateTime(new Date());
            licenseResource.setUpdateUser(this.getCurrentUser().getUserName());
            licenseResourceDao.insert(licenseResource);
            return licenseResource.getId();
        }catch(Exception e){
            throw new BusinessException(DataResponse.ERRCODE_UNDEFINED,"文件信息存入数据库失败 请重试");
        }



    }

}
