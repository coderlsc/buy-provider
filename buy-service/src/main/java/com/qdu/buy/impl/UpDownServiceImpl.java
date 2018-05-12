package com.qdu.buy.impl;

import com.qdu.buy.UpDownService;
import com.qdu.buy.util.OSSClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class UpDownServiceImpl implements UpDownService {

    @Autowired
    private OSSClientUtil ossClientUtil;

    public String updateHead(MultipartFile file) throws Exception {
        if (file == null || file.getSize() <= 0) {
            throw new Exception("图片不能为空");
        }
        String name = ossClientUtil.uploadImg2Oss(file);
        String imgUrl = ossClientUtil.getImgUrl(name);
        //userDao.updateHead(userId, imgUrl);//只是本地上传使用的
        return imgUrl;
    }
}