package com.qdu.buy.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Descripition: 用户DTO
 * @Author: xiepf
 * @Date: 2017/11/14 10:53
 */
@Data
@ToString
@EqualsAndHashCode
public class UserDto implements Serializable {

    private static final long serialVersionUID = 8925589627600059970L;
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, min = 1, message = "用户名最多20个字符")
    private String userName;

    @NotBlank(message = "姓名不能为空")
    @Length(max = 20, min = 1, message = "姓名最多20个字符")
    private String realName;

    @Length(max=11,  min = 11,message = "手机号长度不符合要求")
    private String mobile;

    @Length(max = 20, min = 1, message = "联系电话最多20个字符，最少1个字符")
    private String phone;

    @Length(max = 50, min = 6, message = "邮箱最多50个字符，最少6个字符")
    @Email(message="邮箱格式错误")
    private String email;

    private String status;

    private String firstLogin;

    @Length(max = 100, min = 0, message = "备注信息最多100个字符，最少1个字符")
    private String remark;

    private String reason;

    @NotBlank(message = "所属城市不能为空")
    @Length(max = 20, min = 1, message = "城市最多20个字符")
    private String cityId;

}
