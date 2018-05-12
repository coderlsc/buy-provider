package com.qdu.buy.dao.content;

import com.qdu.buy.domain.po.content.ContentCat;

public interface ContentCatDao {
    int deleteByPrimaryKey(Long id);

    int insert(ContentCat record);

    int insertSelective(ContentCat record);

    ContentCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContentCat record);

    int updateByPrimaryKey(ContentCat record);
}