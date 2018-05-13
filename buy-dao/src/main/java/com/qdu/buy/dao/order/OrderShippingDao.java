package com.qdu.buy.dao.order;

import com.qdu.buy.domain.po.order.OrderItem;
import com.qdu.buy.domain.po.order.OrderShipping;
import org.apache.ibatis.annotations.Param;

public interface OrderShippingDao {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderShipping record);

    int insertSelective(OrderShipping record);

    OrderShipping selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderShipping record);

    int updateByPrimaryKey(OrderShipping record);

    OrderShipping queryOrderShippingByOrderId(@Param("orderId") String orderId);
}