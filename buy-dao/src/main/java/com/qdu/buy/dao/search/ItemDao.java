package com.qdu.buy.dao.search;

import com.qdu.buy.domain.po.query.SearchQuery;
import com.qdu.buy.domain.po.search.Item;
import com.qdu.buy.domain.vo.search.SearchItemVo;

import java.util.List;

public interface ItemDao {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<SearchItemVo> queryItemPage(SearchQuery searchQuery);

    int queryCount(SearchQuery searchQuery);

}