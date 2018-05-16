package com.qdu.buy.web.controller.search;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qdu.buy.UpDownService;
import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.query.ItemPageQuery;
import com.qdu.buy.domain.po.query.SearchQuery;
import com.qdu.buy.domain.po.search.Item;
import com.qdu.buy.domain.po.search.ItemCat;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.lang.Page;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.tools.doclint.Entity.image;

@Controller
@Slf4j
public class SearchController {

    //搜索商品 （数据库中查询）

    @Autowired
    private SearchService searchService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private UpDownService upDownService;

    @RequestMapping("/search")
    public String search(@RequestParam(value = "queryStr",defaultValue = "")String queryStr,
                         @RequestParam(defaultValue="1") Integer pageNo,
                         @RequestParam(value = "cid",defaultValue ="")String cid,
                        Model model) throws Exception {
        //int a = 1/0;
        //调用服务执行查询
        //把查询条件进行转码，解决get乱码问题
        queryStr = URLDecoder.decode(queryStr,"utf-8");

        Page<SearchItemVo> searchResult = searchService.search(queryStr, cid,pageNo);
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

    @RequestMapping("/queryCateList")
    @ResponseBody
    public List<ItemCat> queryCateList(){
        List<ItemCat> cateList=searchService.queryCateList();
        return  cateList;
    }




    @RequestMapping("/queryItemPage")
    @ResponseBody
    public Page<SearchItemVo> queryBooks(Integer currentPage,
                                                     Integer pageSize,
                                                     String name,
                                                     String categoryid){
        SearchQuery query=new SearchQuery();
        query.setTitle(name);
        query.setCid("".equals(categoryid)?null:Long.valueOf(categoryid));
        query.setPageNo(currentPage);
        query.setPageSize(pageSize);
        Page<SearchItemVo> result=searchService.queryItemPage(query);
        return  result;
    }


    @RequestMapping("/item/addItem")
    @ResponseBody
    public Map<String,Object> addItem(HttpServletRequest request,Item item,MultipartFile pic){
        Map<String,Object> result=new HashMap<>();
//        log.info(request.getAttribute("item").toString());
        log.info(item.toString());
        try{
//           Item item1= JSON.parseObject(item,Item.class);
           String image1=upDownService.updateHead(pic);
           item.setImage(image1);
           searchService.addItem(item);
            result.put("request","1");
        }catch(Exception e){
            log.error("上传图片失败"+e.getMessage(),e);
            result.put("result","0");
        }
        return result;
    }






}