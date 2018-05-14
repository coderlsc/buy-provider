package com.qdu.buy.search;

import com.qdu.buy.domain.po.query.ItemPageQuery;
import com.qdu.buy.domain.po.query.SearchQuery;
import com.qdu.buy.domain.po.search.ItemCat;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.lang.Page;

import java.util.List;

public interface SearchService {

    Page<SearchItemVo> search(String queryString,String cid, int pageNo) throws Exception;

    SearchItemVo getIntroduction(String itemId);

    Page<SearchItemVo> queryItemPage(SearchQuery query);


    List<ItemCat> queryCateList();
}