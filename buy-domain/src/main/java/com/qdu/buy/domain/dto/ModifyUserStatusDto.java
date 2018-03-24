package com.qdu.buy.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Descripition:
 * @Author: xiepf
 * @Date: 2017/11/16 15:27
 */
@Data
@ToString
@EqualsAndHashCode
public class ModifyUserStatusDto implements Serializable {

    private static final long serialVersionUID = -5966970423673634177L;
    @NotBlank(message = "用户id不能为空")
    private String id;

    @Length(max = 100, min = 0, message = "最多100个字符")
    private String reason = "";
}