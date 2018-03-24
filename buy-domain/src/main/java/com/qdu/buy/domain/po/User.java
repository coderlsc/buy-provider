package com.qdu.buy.domain.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Descripition: 用户po
 * @Author: xiepf
 * @Date: 2017/10/15 18:08
 */
@Data
@ToString
@EqualsAndHashCode
public class User implements Serializable {


    private static final long serialVersionUID = 2588393205358156658L;
    private Long id;

    private Long cityId;

    private String userName;

    private String realName;

    private String password;

    private String salt;

    private String mobile;

    private String phone;

    private String email;

    private String status;

    private String firstLogin;

    private String remark;

    private String reason;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

}
