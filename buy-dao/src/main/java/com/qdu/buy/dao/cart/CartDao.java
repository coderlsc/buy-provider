package com.qdu.buy.dao.cart;

import com.qdu.buy.domain.po.cart.Cart;
import com.qdu.buy.domain.vo.cart.CartInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartDao {
    int deleteByPrimaryKey(Long id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<CartInfo> queryCartListByUserId(@Param("userId") Long userId);

    Cart getCartByUserIdAndItemId(@Param("userId") Long userId,@Param("itemId") Long itemId);
}