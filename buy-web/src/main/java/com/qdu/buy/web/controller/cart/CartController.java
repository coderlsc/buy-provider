package com.qdu.buy.web.controller.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdu.buy.cart.CartService;
import com.qdu.buy.domain.po.cart.Cart;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.vo.cart.CartInfo;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.lang.Constants;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 购物车管理Controller
 * <p>Title: CartController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	@Autowired
	private SearchService searchService;

	@RequestMapping("/add")
	@ResponseBody
	public Map<String,Object> addItemCart(@RequestParam(name = "itemId") String itemId,
						   @RequestParam(defaultValue="1")Integer num, HttpServletRequest request,
						   HttpServletResponse response) {

		Purchaser purchaser=(Purchaser) request.getSession().getAttribute("user");
		//取购物车商品列表
		List<CartInfo> cartList = cartService.getCartItemList(request);

		//判断商品在购物车中是否存在
		boolean flag = false;
		for (CartInfo cartInfo : cartList) {
			if (cartInfo.getItemId().equals(Long.valueOf(itemId))) {
				cartInfo.setNumber(cartInfo.getNumber()+num);
				//如果存在数量相加
				Cart cart1=buildCart(cartInfo.getItemId(),cartInfo.getUserId(),cartInfo.getNumber(),Double.valueOf(cartInfo.getTotalPrice()));
				//添加购物车
				cartService.updateCart(cart1);
				flag = true;
				break;
			}
		}
		//如果不存在，添加一个新的商品
		if (!flag) {
			//需要调用服务取商品信息
			SearchItemVo searchItemVo =searchService.getIntroduction(itemId);
			//设置购买的商品数量
			Cart cart=buildCart(Long.valueOf(searchItemVo.getId()),purchaser.getId(),num,searchItemVo.getPrice()*num);
			cartService.addCart(cart);
		}
		Map<String,Object> result=new HashMap();
		result.put("result","1");
		return result;
	}


	
	@RequestMapping("/toCart")
	public String showCartList(HttpServletRequest request) {
		Purchaser purchaser=(Purchaser) request.getSession().getAttribute("user");
		//从cookie中取购物车列表
		List<CartInfo> cartInfoList = new ArrayList<>();
		 try{
                cartInfoList=(List<CartInfo>) redisTemplate.opsForValue().get(Constants.PREFIX_CART_KEY+purchaser.getId());
            }catch(Exception ex){
                log.error("redis获取购物车失败"+ ex.getMessage(),ex);
            }
            if(cartInfoList==null||cartInfoList.size()==0){
				cartInfoList=cartService.getCartItemList(request);
			}
		//把购物车列表传递给jsp
		request.setAttribute("cartList", cartInfoList);
		//返回逻辑视图
		return "cart";
	}
	
	@RequestMapping("/update/num/{itemId}/{num}")
	@ResponseBody
	public Map<String,Object> updateItemNum(@PathVariable Long itemId, @PathVariable Integer num,
									  HttpServletRequest request, HttpServletResponse response) {
		Purchaser purchaser=(Purchaser) request.getSession().getAttribute("user");
		cartService.refreshCart(itemId,purchaser.getId(),num);
		Map<String,Object> result=new HashMap<>();
		result.put("result","1");
		return result;
	}

	@RequestMapping("/deleCartItem")
	@ResponseBody
	public Map<String,Object> deleCartItem(@RequestParam("itemId") Long itemId,
											HttpServletRequest request, HttpServletResponse response) {
		Purchaser purchaser=(Purchaser) request.getSession().getAttribute("user");
		cartService.deleCartItem(itemId,purchaser.getId());
		Map<String,Object> result=new HashMap<>();
		result.put("result","1");
		return result;
	}
	
//	@RequestMapping("/cart/delete/{itemId}")
//	public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request ,
//			HttpServletResponse response) {
//		//从cookie中取购物车列表
//		List<TbItem> cartItemList = getCartItemList(request);
//		//找到对应的商品
//		for (TbItem tbItem : cartItemList) {
//			if (tbItem.getId() == itemId.longValue()) {
//				//删除商品
//				cartItemList.remove(tbItem);
//				break;
//			}
//		}
//		//把购车列表写入cookie
//		CookieUtils.setCookie(request, response, CART_KEY, JsonUtils.objectToJson(cartItemList),
//				CART_EXPIER, true);
//		//重定向到购物车列表页面
//		return "redirect:/cart/cart.html";
//	}



	public Cart buildCart(Long itemId,Long userId,Integer number,Double totalPrice){
		Cart cart=new Cart();
		cart.setItemId(itemId);
		cart.setUserId(userId);
		cart.setNumber(number);
		cart.setTotalPrice(totalPrice);
		return cart;
	}







}
