package com.qdu.buy.lang;

import java.lang.annotation.*;

/**
 * @Descripition: 操作日志注解
 * Copyright: Copyright(c)2017
 * Company: 八维通科技有限公司
 * @Author: xiepf
 * @Date: 2018/1/20 12:45
 * @Version: 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /**
     * 要执行的操作类型
     **/
    public String businFlag() default "";

    /**
     * 要执行的具体操作比如：添加用户
     **/
    public String operContent() default "";
}
