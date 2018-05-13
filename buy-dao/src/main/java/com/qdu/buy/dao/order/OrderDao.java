package com.qdu.buy.dao.order;

import com.qdu.buy.domain.po.order.Order;
import com.qdu.buy.domain.po.query.OrderPageQuery;

import java.util.List;

public interface OrderDao {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> getOrderList(OrderPageQuery query);

    int queryCount(OrderPageQuery query);
}