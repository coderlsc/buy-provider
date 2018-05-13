package com.qdu.buy.search;

import com.qdu.buy.domain.po.query.ItemPageQuery;
import com.qdu.buy.domain.po.query.SearchQuery;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.lang.Page;

public interface SearchService {

    Page<SearchItemVo> search(String queryString, int pageNo) throws Exception;

    SearchItemVo getIntroduction(String itemId);

    Page<SearchItemVo> queryItemPage(SearchQuery query);
}