package com.qdu.buy.domain.po.query;

import com.qdu.buy.domain.PageQuery;
import lombok.Data;

@Data
public class OrderPageQuery extends PageQuery {

    private  String orderId;//订单id
    private  Long userId;//userid
    private  String status;//订单状态

    private String title;//商品标题



}