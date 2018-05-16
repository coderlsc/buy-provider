package com.qdu.buy.domain.vo.search;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class SearchItemVo implements Serializable {

    private String id;
    private String title;
    private String sell_point;
    private Double price;
    private Integer num;
    private String image;
    private String category_name;
    private String item_desc;
    private Date createTime;
    private Integer saleAmount;//销量
    private String dateStr;//日期时间的字符串格式
    private List<String> images;//展示的图片链接集合
    private String smallImage;//小图标
    private String status;//状态
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSell_point() {
        return sell_point;
    }
    public void setSell_point(String sell_point) {
        this.sell_point = sell_point;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public String getItem_desc() {
        return item_desc;
    }
    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }


    public String getDateStr(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(this.createTime);
    }
    public List<String> getImages() {
        List<String> imageList=new ArrayList<>();
        if(this.image==null||"".equals(this.image)){
            this.images=imageList;
            return images;
        }
        String[] imageArray= this.image.split(",");
        imageList=Arrays.asList(imageArray);
        this.images=imageList;
        return images;
    }
    public String getSmallImage(){
        return getImages().get(0);
    }

//    public void setImages(List<String> images) {
//        this.images = images;
//    }

//    public List<String> getImages(){
//        List<String> imageList=new ArrayList<>();
//        if(this.image==null||"".equals(this.image)){
//            this.images=imageList;
//            return images;
//        }
//        String[] imageArray= this.image.split(",");
//        imageList=Arrays.asList(imageArray);
//        this.images=imageList;
//        return images;
//    }
//
//    public void setImages(List<String> images) {
//        List<String> imageList=new ArrayList<>();
//        if(this.image==null||"".equals(this.image)){
//            this.images=imageList;
//        }
//        else{
//            String[] imageArray= this.image.split(",");
//            imageList=Arrays.asList(imageArray);
//            this.images = imageList;
//        }
//    }





}
