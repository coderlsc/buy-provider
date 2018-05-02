package com.qdu.buy.domain.po.query;

import com.qdu.buy.domain.PageQuery;
import lombok.Data;

@Data
public class SearchQuery  extends PageQuery{

    private String title;//商品标题

    private Long cid;//分类id

    private String sellPoint;//卖点描述


}