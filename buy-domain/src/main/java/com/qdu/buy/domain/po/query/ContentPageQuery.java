package com.qdu.buy.domain.po.query;


import com.qdu.buy.domain.PageQuery;
import lombok.Data;

@Data
public class ContentPageQuery extends PageQuery {

    private String title;//内容标题
    private String categoryId;//类别id



}