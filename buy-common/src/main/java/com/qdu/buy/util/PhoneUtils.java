package com.qdu.buy.util;

import com.alibaba.fastjson.JSON;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.qdu.buy.lang.Constants;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//手机相关工具类
//验证码
public class PhoneUtils {

    /**
     * 发送验证码
     *
     * @author liuxuanlin
     */
    //发送验证码的请求路径URL
    private static final String
            SERVER_URL = "https://api.netease.im/sms/sendcode.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final int
            appid = Constants.appid;
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String appkey = Constants.appkey;





    public static void main(String[] args) throws Exception {

        try {
            SmsSingleSender sender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = sender.send(0, "86", "15688878453", "【腾讯】验证码测试1234", "", "123");
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}