package com.qdu.buy.order;

import com.qdu.buy.domain.po.order.Order;
import com.qdu.buy.domain.po.query.OrderPageQuery;
import com.qdu.buy.domain.vo.cart.CartInfo;
import com.qdu.buy.lang.Page;

import java.util.List;
import java.util.Map;

public interface OrderService {



    Page<Order> getOrderList(OrderPageQuery query);

    void createOrders(List<CartInfo> cartInfos,Long userId);





}