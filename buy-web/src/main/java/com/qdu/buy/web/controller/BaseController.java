package com.qdu.buy.web.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qdu.buy.cart.CartService;
import com.qdu.buy.content.ContentService;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.search.ItemCat;
import com.qdu.buy.domain.vo.cart.CartInfo;
import com.qdu.buy.impl.ContentServiceImpl;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
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

    @Autowired
    private ContentService contentService;


    //去登陆页面
    @RequestMapping(value = "toLogin")
    public ModelAndView tologin(){
        log.info("即将转向登录页面================");
        return new ModelAndView("login");
    }


    //去首页
    @RequestMapping(value = "toIndex")
    public ModelAndView toIndex(){
        //携带各种广告去首页显示
        List<Content> broadCasts=contentService.getContentByCid(Long.valueOf(3));
        ModelAndView modelAndView=new ModelAndView("index");
        List<ItemCat> cateList=searchService.queryCateList();
        modelAndView.addObject("broadCasts",broadCasts);
        modelAndView.addObject("cateList",cateList);
        return modelAndView;
    }
    @RequestMapping(value = "/")
    public String showIndex(){
        return "forward:/toIndex";
    }

    //去首页
    @RequestMapping(value = "toRegister")
    public String toRegister(HttpServletRequest request,Model model){
        Content registerContent=contentService.getContentByCid(Long.valueOf(4)).get(0);
        model.addAttribute("registerCast",registerContent);
        return "register";
    }

    @RequestMapping(value="index")
    public String index(){
        return "forward:/toIndex";
    }

    //去认证页面
    @RequestMapping(value = "toConfirm")
    public String toConfirm(@RequestParam("purchaserId")Long purchaserId, HttpServletRequest request,Model model){
        request.setAttribute("purchaserId",purchaserId);
        model.addAttribute("purchaserId",purchaserId);
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
        Double totalPay=0.0;
        List<CartInfo> cartInfoList=  JSON.parseArray(jsonObject.get("cartList")+"",CartInfo.class);
        cartInfoList.forEach(x->x.setTitle(searchService.getIntroduction(x.getItemId()+"").getTitle()));
        cartInfoList.forEach(x->x.setTotalPrice(searchService.getIntroduction(x.getItemId()+"").getPrice()*x.getNumber()));
        cartInfoList.forEach(x->x.setPrice(searchService.getIntroduction(x.getItemId()+"").getPrice()));
        cartInfoList.forEach(x->x.setImage(searchService.getIntroduction(x.getItemId()+"").getImage()));
        request.setAttribute("cartList",cartInfoList);
        model.addAttribute("cartList",cartInfoList);
        for(CartInfo cartInfo:cartInfoList){
                totalPay=totalPay+Double.valueOf(cartInfo.getTotalPrice());
        }
        request.setAttribute("totalPay",totalPay);
        model.addAttribute("totalPay",totalPay);
        return "pay";
    }


    @RequestMapping(value = "/adminLogin")
    public String toBackend(HttpServletRequest request){
        return "admin_login";
    }

    @RequestMapping(value = "/admin/toIndex")
    public String toIndex(HttpServletRequest request){
        return "admin_index";
    }

    @RequestMapping(value = "/user/toPersonCenter")
    public String toPersonCenter( HttpServletRequest request,Model model){
        return "user_index";
    }















}