package com.qdu.buy.domain.po.query;


import com.qdu.buy.domain.PageQuery;
import lombok.Data;

@Data
public class ItemPageQuery  extends PageQuery{

    private  String title;//
    private String cid;//类别id
}