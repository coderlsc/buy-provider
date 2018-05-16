package com.qdu.buy.impl;

import com.qdu.buy.cart.CartService;
import com.qdu.buy.dao.cart.CartDao;
import com.qdu.buy.dao.search.ItemDao;
import com.qdu.buy.domain.po.cart.Cart;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.po.search.Item;
import com.qdu.buy.domain.vo.cart.CartInfo;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.lang.Constants;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private SearchService searchService;

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<CartInfo> getCartItemList(HttpServletRequest request) {
            //先从redis中拿取当前用户的购物车列表数据
            List<CartInfo> cartList=new ArrayList<>();
            Purchaser purchaser=(Purchaser) request.getSession().getAttribute("user");
                cartList=cartDao.queryCartListByUserId(purchaser.getId());
                return cartList;
    }

    @Transactional
    @Override
   public void addCart(Cart cart){
        cart.setCreateTime(new Date());
        cart.setUpdateTime(new Date());
       cartDao.insert(cart);
   }

    @Transactional
    @Override
    public void updateCart(Cart cart){
        cart.setUpdateTime(new Date());
        cartDao.updateByPrimaryKeySelective(cart);
    }

    @Transactional
    @Override
    public void refreshCart(Long itemId,Long userId,Integer number){
        //先根据用户id和商品id 获取对应的购物车对象 然后修改其数量和 总价
        Cart cart=cartDao.getCartByUserIdAndItemId(userId,itemId);
        cart.setNumber(number);
        SearchItemVo searchItemVo =searchService.getIntroduction(itemId+"");
        cart.setTotalPrice(searchItemVo.getPrice()*number);
        cartDao.updateByPrimaryKeySelective(cart);
    }

    @Transactional
    @Override
    public void deleteCartItem(List<CartInfo> list,Long userId){
        for(CartInfo cartInfo:list){
            cartDao.deleteCartByUserIdandItemId(cartInfo.getItemId(),userId);
            Item item=new Item();
            item.setId(cartInfo.getItemId());
            item.setNum(searchService.getIntroduction(cartInfo.getItemId()+"").getNum()-cartInfo.getNumber());
            itemDao.updateByPrimaryKeySelective(item);
            try{
                redisTemplate.delete("item_"+cartInfo.getItemId());
            }catch(Exception e){
                log.info("删除缓存异常商品id"+cartInfo.getItemId());

            }
        }
//        List<CartInfo> list1=-
//        redisTemplate.opsForValue().
    }


    @Transactional
    @Override
    public void deleCartItem(Long itemId,Long userId){
            cartDao.deleteCartByUserIdandItemId(itemId,userId);
            try{
                redisTemplate.delete("item_"+itemId);
            }catch(Exception e){
                log.info("删除缓存异常商品id"+itemId);

            }
        }
//        List<CartInfo> list1=-
//        redisTemplate.opsForValue().
    }


