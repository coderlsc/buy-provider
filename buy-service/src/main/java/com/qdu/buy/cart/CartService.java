package com.qdu.buy.cart;

import com.qdu.buy.domain.po.cart.Cart;
import com.qdu.buy.domain.vo.cart.CartInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CartService {

    List<CartInfo> getCartItemList(HttpServletRequest request) ;

    //添加购物车商品
    void addCart(Cart cart);

    void updateCart(Cart cart);

//    CartInfo getCartByUserIdAndItemId(Long itemId,Long userId);

    void refreshCart(Long itemId,Long userId,Integer number);


    void deleteCartItem(List<CartInfo> list,Long userId);

    void deleCartItem(Long itemId,Long userId);





}