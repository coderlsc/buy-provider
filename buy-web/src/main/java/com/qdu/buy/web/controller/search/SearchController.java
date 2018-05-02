package com.qdu.buy.web.controller.search;


import com.bwton.dist.lang.Page;
import com.qdu.buy.domain.vo.search.SearchItemVo;
import com.qdu.buy.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLDecoder;

@Controller
@Slf4j
public class SearchController {

    //搜索商品 （数据库中查询）

    @Autowired
    private SearchService searchService;

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






}