package com.qdu.buy.dao.content;

import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.query.ContentPageQuery;
import com.qdu.buy.domain.po.query.ContentQuery;

import java.util.List;

public interface ContentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);

    //根据条件查询符合条件的记录数
    Integer queryCount(ContentPageQuery query);


    //查询显示内容 可以按照条件
    List<Content> getAllBroadcast(ContentQuery query);

    //查询显示内容 可以按照条件
    List<Content> queryContentPage(ContentPageQuery query);
}