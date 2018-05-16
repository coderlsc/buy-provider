package com.qdu.buy.impl;

import com.qdu.buy.dao.search.ItemCatMapper;
import com.qdu.buy.dao.search.ItemDao;
import com.qdu.buy.dao.search.ItemDescDao;
import com.qdu.buy.domain.po.query.ItemPageQuery;
import com.qdu.buy.domain.po.query.SearchQuery;
import com.qdu.buy.domain.po.search.Item;
import com.qdu.buy.domain.po.search.ItemCat;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.lang.Page;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {


    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemDescDao itemDescDao;

    @Autowired
    private ItemCatMapper itemCatMapper;


    @Override
    public Page<SearchItemVo> search(String queryString,String cid, int pageNo) throws Exception {
        //根据查询条件拼装查询对象
        //设置查询条件
        SearchQuery searchQuery=new SearchQuery();
        searchQuery.setTitle(queryString);
        searchQuery.setCid("".equals(cid)?null:Long.valueOf(cid));
        searchQuery.setPageNo(pageNo);
        searchQuery.setPageSize(16);
        List<SearchItemVo> result=itemDao.queryItemPage(searchQuery);
        int rowsCount=itemDao.queryCount(searchQuery);
        Page<SearchItemVo> page=new Page<>(rowsCount,searchQuery.getPageNo(),searchQuery.getPageSize(),result);
        page.setTotal(rowsCount);
        return page;
    }

    @Override
    public SearchItemVo getIntroduction(String itemId) {
        SearchItemVo searchItemVo=itemDao.queryIntroduceByItemId(Long.valueOf(itemId));
        return searchItemVo;
    }

    @Override
    public Page<SearchItemVo> queryItemPage(SearchQuery query) {
        List<SearchItemVo> result=itemDao.queryItemPage(query);
        int rowsCount=itemDao.queryCount(query);
        Page<SearchItemVo> page=new Page<>(rowsCount,query.getPageNo(),query.getPageSize(),result);
        page.setTotal(rowsCount);
        return page;
    }




    @Override
    public List<ItemCat> queryCateList() {
    return itemCatMapper.queryCateList();
    }

    @Override
    public void addItem(Item item){
        item.setSaleAmount(0);
        item.setCreateTime(new Date());
        item.setCreateUser("admin");
        item.setUpdateTime(new Date());
        item.setUpdateUser("admin");
        itemDao.insert(item);
    }

}