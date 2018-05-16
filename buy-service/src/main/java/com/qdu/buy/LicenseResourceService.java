package com.qdu.buy;

import com.qdu.buy.domain.po.resource.LicenseResource;
import com.qdu.buy.lang.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/** 文件资源服务接口
 * Created by lsc on 2018/1/24.
 */
public interface LicenseResourceService {

    //添加资源信息
    Long insert(LicenseResource resource);


    //上传资源处理方法
    Long uploadFile(MultipartFile resource,
                    HttpServletRequest request)throws BusinessException;


    //AdResource queryAdResource(String );

}
