package com.qdu.buy.search;

import com.bwton.dist.lang.Page;
import com.qdu.buy.domain.vo.search.SearchItemVo;

public interface SearchService {

    Page<SearchItemVo> search(String queryString, int pageNo) throws Exception;

    SearchItemVo getIntroduction(String itemId) throws Exception;
}