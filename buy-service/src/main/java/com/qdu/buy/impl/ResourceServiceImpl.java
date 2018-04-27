package com.qdu.buy.impl;

import com.bwton.dist.constant.Constants;
import com.bwton.dist.core.data.vo.DataResponse;
import com.bwton.dist.core.service.BaseService;
import com.bwton.dist.exception.BusinessException;
import com.qdu.buy.ResourceService;
import com.qdu.buy.dao.ResourceDao;
import com.qdu.buy.domain.dto.ResourceDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Arrays;
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
public class ResourceServiceImpl extends BaseService implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;
    /*
    @Autowired
    private CommonService commonService;*/

//    @Value("${ad.AccessKey}")
//    String AccessKey;
//
//    @Value("${ad.SecretKey}")
//    String SecretKey;
//
//    @Value("${ad.area}")
//    String area;
//
//    @Value("${ad.bucketname}")
//    String bucketname;
    @Override
    public Long insert(ResourceDto resourceDto) {
        resourceDto.setCreateTime(new Date());
        resourceDto.setCreateUser(this.getCurrentUser().getUserName());
        resourceDto.setUpdateTime(new Date());
        resourceDto.setUpdateUser(this.getCurrentUser().getUserName());
        resourceDao.insert(resourceDto);
        return resourceDto.getId();
    }

    @Override
    public Long uploadFile(MultipartFile resource, HttpServletRequest request)throws BusinessException{
        String[] types=Constants.IMGTYPEARRAY;
        String fileName = resource.getOriginalFilename();//获取文件名
        String extension= FilenameUtils.getExtension(fileName);//获取后缀 .jpg .png ....
        String filePath = "";
        String newName= UUID.randomUUID().toString().substring(0,32)+"."+extension;
        //密钥配置
//        Auth auth= Auth.create(AccessKey,SecretKey);
        try {

           /* //创建上传对象  获取上传空间所属zone
            Configuration cfg= new Configuration(Zone.zone0());
            UploadManager uploadManager= new UploadManager(cfg);
            //指定保存到七牛云上的文件路径
            Response res = uploadManager.put(resource.getBytes(),newName, auth.uploadToken(bucketname));
            //打印返回的信息
            if (res.isOK() && res.isJson()) {
                //上传成功
                log.info("下载签名"+auth.privateDownloadUrl(area+"/"+newName));
                log.info(area+"/"+ JSONObject.parseObject(res.bodyString()).get("key")+"上传成功");
            } else{
                log.error("七牛异常1:"+ res.bodyString());
                //抛出异常信息
                throw new BusinessException(DataResponse.ERRCODE_UNDEFINED,res.bodyString());
            }*/
        } catch (Exception e) {
            throw new BusinessException(DataResponse.ERRCODE_UNDEFINED,e.getMessage());
        }

        //持久层添加 插入资源信息到资源表中去
        ResourceDto resourceDto=new ResourceDto();

        try {
            InputStream iis = resource.getInputStream();
            BufferedImage bi = ImageIO.read(iis);
            int width = bi.getWidth();
            int height = bi.getHeight();
            resourceDto.setResourceWidth(width);
            resourceDto.setResourceHeight(height);
            resourceDto.setResourceType(Arrays.asList(types).contains("."+extension)?Constants.Ad.ResourceTypeEnum.Img.getValue():Constants.Ad.ResourceTypeEnum.Video.getValue());
            resourceDto.setResourceName(fileName);//文件的名字
            resourceDto.setResourceNewName(newName);//保存文件新名字
            //resourceDto.setResourceUploadPath(area+"/"+newName);//直接可以访问的路径
            resourceDto.setCreateTime(new Date());
            resourceDto.setCreateUser(this.getCurrentUser().getUserName());
            resourceDto.setUpdateTime(new Date());
            resourceDto.setUpdateUser(this.getCurrentUser().getUserName());
            resourceDao.insert(resourceDto);
            return resourceDto.getId();
        }catch(Exception e){
            throw new BusinessException(DataResponse.ERRCODE_UNDEFINED,"图片信息获取失败 请重新上传");
        }



    }

}
