package com.qdu.buy.dao.search;

import com.qdu.buy.domain.po.search.ItemCat;

import java.util.List;

public interface ItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    ItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCat record);

    int updateByPrimaryKey(ItemCat record);

    List<ItemCat> queryCateList();
}