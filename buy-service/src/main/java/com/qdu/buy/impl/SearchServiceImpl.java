package com.qdu.buy.impl;

import com.bwton.dist.lang.Page;
import com.qdu.buy.dao.search.ItemDao;
import com.qdu.buy.dao.search.ItemDescDao;
import com.qdu.buy.domain.po.query.SearchQuery;
import com.qdu.buy.domain.po.search.ItemDesc;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {


    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemDescDao itemDescDao;


    @Override
    public Page<SearchItemVo> search(String queryString, int pageNo) throws Exception {
        //根据查询条件拼装查询对象
        //设置查询条件
        SearchQuery searchQuery=new SearchQuery();
        searchQuery.setTitle(queryString);
        searchQuery.setPageNo(pageNo);
        searchQuery.setPageSize(16);
        List<SearchItemVo> result=itemDao.queryItemPage(searchQuery);
        int rowsCount=itemDao.queryCount(searchQuery);
        Page<SearchItemVo> page=new Page<>(rowsCount,searchQuery.getPageNo(),searchQuery.getPageSize(),result);
        return page;
    }

    @Override
    public SearchItemVo getIntroduction(String itemId) {
        SearchItemVo searchItemVo=itemDao.queryIntroduceByItemId(Long.valueOf(itemId));
        return searchItemVo;
    }
}