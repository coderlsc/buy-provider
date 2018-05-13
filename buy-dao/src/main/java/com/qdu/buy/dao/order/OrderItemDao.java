package com.qdu.buy.dao.order;

import com.qdu.buy.domain.po.order.OrderItem;
import org.apache.ibatis.annotations.Param;

public interface OrderItemDao {
    int deleteByPrimaryKey(String id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    OrderItem queryOrderItemByOrderId(@Param("orderId") String orderId);
}