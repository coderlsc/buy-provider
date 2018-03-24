package com.qdu.buy.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Descripition:
 * @Author: xiepf
 * @Date: 2017/11/16 12:46
 */
@Data
@EqualsAndHashCode
@ToString
public class UserVo implements Serializable{

    private static final long serialVersionUID = -233881536212827722L;
    
    private String id;

    private String cityId;

    private String cityName;

    private String userName;

    private String realName;

    private String roleName;

    private String roleId;

    private String roleNo;

    private String mobile;

    private String phone;

    private String email;

    private String status;

    private String statusDesc;

    private String firstLogin;

    private String remark;

    private String reason;

}
