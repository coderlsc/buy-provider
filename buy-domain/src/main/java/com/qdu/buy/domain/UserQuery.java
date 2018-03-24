package com.qdu.buy.domain;

import lombok.Data;

/**
 * @Descripition:
 * @Author: xiepf
 * @Date: 2017/11/14 10:55
 */
@Data
public class UserQuery extends PageQuery {
    private String id;

    private String cityId;

    private String userName;

    private String roleId;

    private String status;

    @Override
    public String toString() {
        return "UserQuery{" +
                "id='" + id + '\'' +
                ", cityId='" + cityId + '\'' +
                ", userName='" + userName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

