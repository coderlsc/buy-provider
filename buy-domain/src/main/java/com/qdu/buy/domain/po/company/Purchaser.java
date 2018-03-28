package com.qdu.buy.domain.po.company;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


@Data
@EqualsAndHashCode
@ToString
public class Purchaser {
    private Long id;

    private String companyName;

    private String shortName;

    private String email;

    private String phone;

    private String password;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String status;

}