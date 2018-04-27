package com.qdu.buy.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * Created by lsc on 2018/1/24.
 */
@Data
@EqualsAndHashCode
@ToString
public class ResourceDto {

    private Long id;//主键id
    private String  resourceType;//资源类型 1：图片 2 视频
    private Integer resourceWidth;//宽度
    private Integer resourceHeight;//长度
    private String resourceName;//文件名称
    private String resourceNewName;//新名称
    private String resourceUploadPath;//上传路径
    private String createUser;//创建人
    private Date createTime;//创建时间
    private String updateUser;//更新人
    private Date updateTime;//更新时间
}
