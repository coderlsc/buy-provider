package com.qdu.buy.web.controller.search;


import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.query.ItemPageQuery;
import com.qdu.buy.domain.po.query.SearchQuery;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.lang.Page;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;

@Controller
@Slf4j
public class SearchController {

    //搜索商品 （数据库中查询）

    @Autowired
    private SearchService searchService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/search")
    public String search(@RequestParam("queryStr")String queryStr,
                         @RequestParam(defaultValue="1")Integer pageNo, Model model) throws Exception {
        //int a = 1/0;
        //调用服务执行查询
        //把查询条件进行转码，解决get乱码问题
        queryStr = URLDecoder.decode(queryStr,"utf-8");

        Page<SearchItemVo> searchResult = searchService.search(queryStr, pageNo);
        //把结果传递给页面
        model.addAttribute("queryStr", queryStr);
        model.addAttribute("totalPages", searchResult.getTotalPage());
        model.addAttribute("itemList", searchResult.getRows());
        model.addAttribute("pageNo", pageNo);
        //返回逻辑视图
        return "search";
    }

    @RequestMapping("/introduction")
    public String introduction(@RequestParam("itemId")String itemId, Model model) throws Exception {
        //转码 防止乱码
        itemId = URLDecoder.decode(itemId,"utf-8");
        SearchItemVo searchResult=new SearchItemVo();
        try{
            searchResult=(SearchItemVo) redisTemplate.opsForValue().get("item_"+itemId);
            if(searchResult!=null){
                log.info("redis中查询到商品详情数据 不需从mysql中查询");
            }
            else{
                searchResult= searchService.getIntroduction(itemId);
                redisTemplate.opsForValue().set("item_"+itemId,searchResult);
            }
        }catch(Exception e){
            log.error("获取缓存失败"+e.getMessage(),e);
            searchResult= searchService.getIntroduction(itemId);
        }
        model.addAttribute("item",searchResult);
        //把结果传递给页面
        return "introduction";
    }

    @RequestMapping("/queryItemPage")
    @ResponseBody
    public Page<SearchItemVo> queryBooks(Integer currentPage,
                                                     Integer pageSize,
                                                     String name,
                                                     String categoryid){
        SearchQuery query=new SearchQuery();
        query.setTitle(name);
        query.setCid(Long.valueOf(categoryid));
        query.setPageNo(currentPage);
        query.setPageSize(pageSize);
        Page<SearchItemVo> result=searchService.queryItemPage(query);
        return  result;
    }






}