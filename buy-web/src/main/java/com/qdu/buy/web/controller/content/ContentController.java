package com.qdu.buy.web.controller.content;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qdu.buy.UpDownService;
import com.qdu.buy.content.ContentService;
import com.qdu.buy.domain.po.content.Content;
import com.qdu.buy.domain.po.query.ContentPageQuery;
import com.qdu.buy.lang.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * 内容管理Controller
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@Autowired
	private UpDownService upDownService;



	@RequestMapping("/queryContentPage")
	@ResponseBody
	public Page<Content> queryBooks(Integer currentPage,
									Integer pageSize,
									String name,
									String categoryid){
		System.out.println(name);
		ContentPageQuery query=new ContentPageQuery();
		query.setTitle(name);
		query.setCategoryId(categoryid);
		query.setPageNo(currentPage);
		query.setPageSize(pageSize);
		Page<Content> result=contentService.getContentPage(query);
		return  result;
	}
	@RequestMapping(value="queryContent")
	@ResponseBody
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	public Content queryContent(String id){
		System.out.println(id);
		Content content=contentService.getContentById(Long.valueOf(id));
		return  content;
	}

	@RequestMapping(value="deleteContentPic")
	@ResponseBody
	public Map<String, String> deleteContentPic(String id){
		Content content=new Content();
		content.setId(Long.valueOf(id));
		content.setPic("");
		contentService.deleteContentPic(content);
		Map<String, String> result=new HashMap<String, String>();
		result.put("result", "success");
		return result;
	}

	@RequestMapping(value="changePic")
	@ResponseBody
	public Map<String, Object> changePic(HttpServletRequest request,String id,MultipartFile pic){
		Map<String, Object> value = new HashMap<String, Object>();
		try {
			String head = upDownService.updateHead(pic);
			Content content=new Content();
			content.setPic(head);
			content.setId(Long.valueOf(id));
			contentService.updateContentPic(content);
			value.put("result","success");
		} catch (IOException e) {
			log.error("上传失败"+e.getMessage(),e);
			value.put("result","fail");
		} catch (Exception e) {
			log.error("上传失败"+e.getMessage(),e);
			value.put("result","fail");
		}
		//持久化到数据库中
		return value;
	}

	@RequestMapping(value="updateContent")
	public String update(Content content){
		contentService.updateContent(content);
		return  "advertising";
	}

	@RequestMapping(value="deleteContent")
	@ResponseBody
	public Map<String, String> deleteContent(String ids){
		System.out.println(ids+"=============");
		Map<String,String> result=new HashMap<String, String>();
		String[] bid=ids.split("-");
		for(String id:bid){
			contentService.deleteContentById(Long.valueOf(id));
		}
		result.put("result", "delesuccess");
		return  result;
	}

	
//	@RequestMapping("/queryAllCate")
//	@ResponseBody
//	public List<Content> queryAllCate() {
//		TaotaoResult result = contentService.getAllBroadcast(content);
//		return result;
//	}



}
