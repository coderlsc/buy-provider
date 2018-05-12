package com.qdu.buy.content;


import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.query.ContentPageQuery;
import com.qdu.buy.lang.Page;

import java.util.List;

//内容管理service层
public interface ContentService {


    //获取所有的轮播图
    List<Content> getAllBroadcast();

    //根据类别id查询
    List<Content> getContentByCid(Long cid);

    Page<Content> getContentPage(ContentPageQuery query);

    Content getContentById(Long id);

    void deleteContentPic(Content content);

    void updateContentPic(Content content);

    void updateContent(Content content);

    void deleteContentById(Long id);

//    //获取所有类别
//    List<Content> getAllContentCate();
}