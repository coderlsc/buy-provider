package com.qdu.buy.web.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qdu.buy.cart.CartService;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.vo.cart.CartInfo;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//跳转页面
@Controller("baseController")
@Slf4j
public class BaseController {
    @Autowired
    private CartService cartService;

    @Autowired
    private SearchService searchService;


    //去登陆页面
    @RequestMapping(value = "toLogin")
    public ModelAndView tologin(){
        log.info("即将转向登录页面================");
        return new ModelAndView("login");
    }


    //去首页
    @RequestMapping(value = "toIndex")
    public ModelAndView toIndex(){
        ModelAndView modelAndView=new ModelAndView("index");
        return modelAndView;
    }

    //去首页
    @RequestMapping(value = "toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value="index")
    public String index(){
        return "index";
    }

    //去认证页面
    @RequestMapping(value = "toConfirm")
    public String toConfirm(){
        return "detailRegister";
    }


    //去购物车页面
    @RequestMapping(value = "toCart")
    public String toCart(HttpServletRequest request, Model model){
        List<CartInfo> cartList=cartService.getCartItemList(request);
        return "cart";
    }

    @RequestMapping(value = "/toPay")
    public String toPay(@RequestParam(name = "items") String items,
                        HttpServletRequest request,Model model){
        JSONObject jsonObject=JSON.parseObject(items);
        List<CartInfo> cartInfoList=  JSON.parseArray(jsonObject.get("cartList")+"",CartInfo.class);
        cartInfoList.forEach(x->x.setTitle(searchService.getIntroduction(x.getItemId()+"").getTitle()));
        cartInfoList.forEach(x->x.setTotalPrice(searchService.getIntroduction(x.getItemId()+"").getPrice()*x.getNumber()));
        cartInfoList.forEach(x->x.setPrice(searchService.getIntroduction(x.getItemId()+"").getPrice()));
        cartInfoList.forEach(x->x.setImage(searchService.getIntroduction(x.getItemId()+"").getImage()));
        request.setAttribute("cartList",cartInfoList);
        model.addAttribute("cartList",cartInfoList);
        return "pay";
    }











}