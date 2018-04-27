package com.qdu.buy.web.controller;

import com.bwton.dist.constant.Constants;
import com.bwton.dist.core.data.vo.DataResponse;
import com.bwton.dist.core.web.annotation.OperationLog;
import com.bwton.dist.util.ExcelUtils;
import com.bwton.dist.util.FileUtil;
import com.qdu.buy.ResourceService;
import com.qdu.buy.util.WordUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @Descripition: 资源处理接口层
 * Copyright: Copyright(c)2017
 * Company: 八维通科技有限公司
 * @Author: lsc
 * @Date:  2018/1/29 14:00
 * @Version: 1.0
 */
@RestController
@Api(value = "/resource", description = "资源处理接口")
@RequestMapping("/resource")
@Slf4j
public class ResourceController {

    @Autowired
    private ResourceService adResourceService;

    @Value("${template.filePath}")
    private String filePath;

   /* @Autowired
    private CommonService commonService;*/

    @ApiOperation(value = "添加资源 并且返回资源id", notes = "添加资源 并且返回资源id")
    @PostMapping("/addResource")
    @OperationLog(businFlag = "10551")
    public ModelAndView addResource(@RequestParam("file") MultipartFile resource,
                                    HttpServletRequest request){
        Long resourceid=null;
        try {
            resourceid=adResourceService.uploadFile(resource,request);
            //返回资源id
            return new ModelAndView(Constants.JSONVIEW_KEY, DataResponse.success("resourceId",resourceid));//返回成功标示0000
        } catch (Exception e) {
            return new ModelAndView(Constants.JSONVIEW_KEY, DataResponse.failure("上传失败"+e.getMessage()+" 请稍后..."));
        }

    }

    @RequestMapping(value="/showPic")
    @ApiOperation(value = "显示图片 以二进制流返回", notes = "显示图片 以二进制流返回")
    @OperationLog(businFlag = "10551")
    public @ResponseBody Map<String,Object> showPic(HttpServletRequest request,
                            HttpServletResponse response) throws Exception{
        try{
//            String path = request.getParameter("resourcePath")+"//"+request.getParameter("resourceName");
//            FileInputStream fs = new FileInputStream(path);
//            int b=fs.available(); //得到文件大小
//            byte data[]=new byte[b];
//            fs.read(data);  //读数据
//            response.setContentType("image*//*"); //设置返回的文件类型
//            ServletOutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象
//            toClient.write(data);  //输出数据
//            toClient.flush();
//            toClient.close();
//            fs.close();
            FileUtil.showPic(request,response);
        }catch(Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return null;//不返回 直接以二进制流的形式返回给页面
    }

        @GetMapping(value = "/downloadTemplate")
        public void downloadTemplate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String templatePath = filePath + "授权委托书.doc";
        String fileName = ExcelUtils.processFileName(request, "授权委托书");
        //查询全部
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".doc");
        byte[] buffer = new byte[1024];
        File file = new File(templatePath);
        FileInputStream fis = null; //文件输入流
        BufferedInputStream bis = null;
        OutputStream os = null; //输出流
        try {
            os = response.getOutputStream();
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            log.error("下载授权委托书文件异常", e);
//            return new ModelAndView(Constants.JSONVIEW_KEY, DataResponse.failure(DataResponse.ERRCODE_UNDEFINED,
//                    "未找到授权委托书模板文件"));
        } finally {
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                log.error("下载授权委托书模板文件，IO关闭异常", e);
            }
        }
        response.flushBuffer();
    }



}



