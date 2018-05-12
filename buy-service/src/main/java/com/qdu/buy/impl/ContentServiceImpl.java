package com.qdu.buy.impl;

import com.bwton.dist.constant.Constants;
import com.qdu.buy.content.ContentService;
import com.qdu.buy.dao.content.ContentCatDao;
import com.qdu.buy.dao.content.ContentDao;
import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.content.ContentCat;
import com.qdu.buy.domain.po.query.ContentPageQuery;
import com.qdu.buy.domain.po.query.ContentQuery;
import com.qdu.buy.lang.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ContentCatDao contentCatDao;


    //获取所有的轮播图
    @Override
    public  List<Content> getAllBroadcast(){
        ContentQuery query=new ContentQuery();
        query.setCategoryId("2");
        List<Content> list=contentDao.getAllBroadcast(query);
        return list;
    }


    @Override
    public List<Content> getContentByCid(Long cid) {
        //先查询缓存
        //添加缓存不能影响正常业务逻辑
        try {
            //查询缓存
            List<Content> list=(List<Content>) redisTemplate.opsForValue().get("index_content:"+cid);
            //查询到结果，把json转换成List返回
            if (list!=null&&list.size()!=0) {
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //缓存中没有命中，需要查询数据库
        //设置查询条件
        ContentQuery query=new ContentQuery();
        query.setCategoryId(cid+"");
        List<Content> list=contentDao.getAllBroadcast(query);
        //把结果添加到缓存
        try {
            redisTemplate.opsForValue().set("index_content:"+cid,list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return list;
    }
    @Override
    public Page<Content> getContentPage(ContentPageQuery query) {
        //设置查询条件
        List<Content> list=contentDao.queryContentPage(query);
        for(Content content:list){
            content.setContentCat(contentCatDao.selectByPrimaryKey(content.getCategoryId()));
        }
        //返回结果
        int count=contentDao.queryCount(query);
        Page<Content> page=new Page<>(count,query.getPageNo(),query.getPageSize(),list);
        page.setTotal(count);
        return page;
    }
    @Override
    public Content getContentById(Long id) {
        Content content=contentDao.selectByPrimaryKey(id);
        content.setContentCat(contentCatDao.selectByPrimaryKey(content.getCategoryId()));
        return content;
    }
    @Override
    public void deleteContentPic(Content content){
        content.setUpdated(new Date());
        contentDao.updateByPrimaryKeySelective(content);
    }
    @Override
    public void updateContentPic(Content content){
        content.setUpdated(new Date());
        contentDao.updateByPrimaryKeySelective(content);
    }
    @Override
    public void updateContent(Content content){
        content.setUpdated(new Date());
        contentDao.updateByPrimaryKeySelective(content);
    }

    @Override
    public void deleteContentById(Long id){
        contentDao.deleteByPrimaryKey(id);
    }

//    //获取所有类别
//    List<Content> getAllContentCate(){
//
//    }
}