package com.qdu.buy.domain.vo.cart;

import com.qdu.buy.domain.po.search.SearchItem;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//购物车数据载体类
@Data
public class CartInfo {
    //商品对象
    private Long id;//主键id
    private Long itemId;//商品id
    private Long userId;//用户id
    private Integer number;//购买数量
    private Double totalPrice;//总价
    private Double price;//单价
    private String title;//标题
    private String image;//商品的图片
    private String smallImage;//缩略图地址

    public String getSmallImage() {
        if(this.image==null||"".equals(this.image)){
            this.smallImage="";
            return smallImage;
        }
        String[] imageArray= this.image.split(",");
        this.smallImage=imageArray[0];
        return smallImage;
    }
    public String getPrice() {
        return price+"";
    }

    public String getTotalPrice() {
        totalPrice=this.number*price;
        return totalPrice+"";
    }

    //    public void setTotalPrice(Integer totalPrice) {
//        this.totalPrice = totalPrice;
//    }
}