package com.qdu.buy.lang;


import com.qdu.buy.util.EnumUtils;

//常量类
public class Constants {


    public static final String NeteaseAppKey="f97ed456401e416ba728d9f9bb8900f6";//网易云appkey
    public static final String APP_SECRET="fc274728ae204ce9a36645049f529290";//网易云密钥

    public static final int appid=1400079190;//腾讯appid

    public static final String appkey="0e38f39aba97234ff2c44637fa40eea4";//腾讯appkey

    public static class Purchaser {

        public enum StatusEnum implements EnumUtils.ValueEnum {

            live("1"), dead("0");

            String value;

            StatusEnum(String value) {
                this.value = value;
            }

            @Override
            public String getValue() {
                return value;
            }
        }
    }

}