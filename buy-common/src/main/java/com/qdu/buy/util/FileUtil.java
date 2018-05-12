package com.qdu.buy.util;

import jdk.internal.util.xml.impl.Input;
import jdk.nashorn.internal.objects.Global;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @Descripition: File工具类
 * Copyright: Copyright(c)2017
 * Company: 八维通科技有限公司
 * @Author: lsc
 * @Date: 2018/2/25 16:10
 * @Version: 1.0
 */

@Slf4j
public class FileUtil {
    /**
     * Description: 向FTP服务器上传文件
     * @return 成功返回true，否则返回false
     */

    //文件传静态方法 暂定这个方法
    public static void uploadFile(MultipartFile resource,String newname,String uploadPath) throws Exception {
        String fileName = resource.getOriginalFilename();//获取文件名
        String extension= FilenameUtils.getExtension(fileName);//获取后缀 .jpg .png ....
        String filePath = "";
        //密钥配置
        try {
            InputStream is=resource.getInputStream();
            OutputStream os=new FileOutputStream(new File(uploadPath+"/"+newname));
            int length=0;
            byte[] data=new byte[1024<<3];
            while((length=is.read(data))!=-1){
                os.write(data,0, length);
            }
            os.close();
            is.close();
        } catch (Exception e) {
            throw new IOException();
        }
    }










}