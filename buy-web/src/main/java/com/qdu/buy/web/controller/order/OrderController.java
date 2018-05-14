package com.qdu.buy.web.controller.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import com.qdu.buy.cart.CartService;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.order.Order;
import com.qdu.buy.domain.po.query.ContentPageQuery;
import com.qdu.buy.domain.po.query.OrderPageQuery;
import com.qdu.buy.domain.vo.cart.CartInfo;
import com.qdu.buy.lang.Page;
import com.qdu.buy.order.OrderService;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private CartService cartService;



    @RequestMapping("/user/viewOrders")
    public String getOrderListByUserId(HttpServletRequest request,Model model){
            return "user_order";
    }


    @RequestMapping("/user/queryOrderPage")
    @ResponseBody
    public Page<Order> queryOrderPage(Integer currentPage,
                                    Integer pageSize,
                                    String title,
                                    String status,HttpServletRequest request){
        System.out.println(title);
        Long userId=((Purchaser)request.getSession().getAttribute("user")).getId();
        OrderPageQuery query=new OrderPageQuery();
        query.setTitle(title);
        query.setStatus(status);
        query.setUserId(Long.valueOf(userId));
        query.setPageNo(currentPage);
        query.setPageSize(pageSize);
        Page<Order> result=orderService.getOrderList(query);
        return  result;
    }



    @RequestMapping(value = "/order/saveOrder")
    public String toPay(@RequestParam(name = "items") String items,
                        HttpServletRequest request, Model model){
        JSONObject jsonObject= JSON.parseObject(items);
        List<CartInfo> cartInfoList=  JSON.parseArray(jsonObject.get("cartList")+"",CartInfo.class);
        cartInfoList.forEach(x->x.setTitle(searchService.getIntroduction(x.getItemId()+"").getTitle()));
        cartInfoList.forEach(x->x.setTotalPrice(searchService.getIntroduction(x.getItemId()+"").getPrice()*x.getNumber()));
        cartInfoList.forEach(x->x.setPrice(searchService.getIntroduction(x.getItemId()+"").getPrice()));
        cartInfoList.forEach(x->x.setImage(searchService.getIntroduction(x.getItemId()+"").getImage()));
        Long userId=((Purchaser)request.getSession().getAttribute("user")).getId();
        //循环插入订单表 插入订单明细表  插入订单物流表
        orderService.createOrders(cartInfoList,userId);
        cartService.deleteCartItem(cartInfoList,userId);
        return "pay_success";
    }




}