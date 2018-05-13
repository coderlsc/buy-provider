package com.qdu.buy.impl;

import com.qdu.buy.dao.order.OrderDao;
import com.qdu.buy.dao.order.OrderItemDao;
import com.qdu.buy.dao.order.OrderShippingDao;
import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.order.Order;
import com.qdu.buy.domain.po.order.OrderItem;
import com.qdu.buy.domain.po.order.OrderShipping;
import com.qdu.buy.domain.po.query.OrderPageQuery;
import com.qdu.buy.domain.vo.cart.CartInfo;
import com.qdu.buy.lang.Page;
import com.qdu.buy.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private OrderShippingDao orderShippingDao;
    @Override
    public Page<Order> getOrderList(OrderPageQuery query) {
        //设置查询条件
        List<Order> list=orderDao.getOrderList(query);
        for(Order order:list){
            order.setOrderItem(orderItemDao.queryOrderItemByOrderId(order.getOrderId()));
            order.setOrderShipping(orderShippingDao.queryOrderShippingByOrderId(order.getOrderId()));
        }
        //返回结果
        int count=orderDao.queryCount(query);
        Page<Order> page=new Page<Order>(count,query.getPageNo(),query.getPageSize(),list);
        page.setTotal(count);
        return page;
    }

    @Transactional
    @Override
    public void createOrders(List<CartInfo> cartInfos,Long userId) {


        for(CartInfo cartInfo:cartInfos) {
            Order order = new Order();
            order.setUserId(userId);
            String orderId = System.currentTimeMillis() + "";
            order.setOrderId(orderId);
            order.setPaymentTime(new Date());
            order.setPaymentType(Integer.valueOf(1));
            order.setPayment(Double.valueOf(cartInfo.getPrice()) * cartInfo.getNumber() + "");
            order.setPostFee(null);
            order.setStatus(Integer.valueOf(3));  //  1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            order.setPaymentTime(new Date());
            order.setBuyerRate(Integer.valueOf(0));
            orderDao.insert(order);//插入顶单表

            OrderItem orderItem=new OrderItem();
            orderItem.setItemId(cartInfo.getItemId()+"");
            orderItem.setTitle(cartInfo.getTitle());
            orderItem.setNum(cartInfo.getNumber());
            orderItem.setOrderId(orderId);
            orderItem.setPicPath(cartInfo.getSmallImage());
            orderItem.setPrice(Long.valueOf(cartInfo.getPrice().substring(0,cartInfo.getPrice().lastIndexOf("."))));
            String totalFee=Double.valueOf(cartInfo.getPrice()) * cartInfo.getNumber()+"";
            orderItem.setTotalFee(Long.valueOf(totalFee.substring(0,totalFee.lastIndexOf("."))));
            orderItemDao.insert(orderItem);//插入订单详情表

            OrderShipping orderShipping=new OrderShipping();
            orderShipping.setOrderId(orderId);
            orderShipping.setCreated(new Date());
            orderShipping.setUpdated(new Date());
            orderShipping.setReceiverAddress("浙江省杭州市滨江区西兴街道");
            orderShipping.setReceiverCity("青岛市");
            orderShipping.setReceiverDistrict("市南区");
            orderShipping.setReceiverMobile("13111111111");
            orderShipping.setReceiverName("测试采购商");
            orderShipping.setReceiverZip("555662");
            orderShipping.setReceiverState("山东省");
            orderShippingDao.insert(orderShipping);//插入订单物流表
        }

    }
}