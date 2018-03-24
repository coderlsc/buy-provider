package com.qdu.buy.domain;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 查询过滤器
 * User: Saintcy
 * Date: 2015/8/24
 * Time: 11:01
 */
public class Query implements Serializable {
    private static final long serialVersionUID = -750741055329991259L;
    protected String fields;//返回的字段集合，多个用逗号隔开
    protected String[] orderBy;//排序字段

    public String[] getOrder_by() {
        return orderBy;
    }

    public void setOrder_by(String[] order_by) {
        this.orderBy = order_by;
    }

    //*******************--兼容驼峰模式--********************//

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String[] getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String[] orderBy) {
        this.orderBy = orderBy;
    }

    public void reset() {
        try {
            BeanUtils.copyProperties(this.getClass().newInstance(), this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Query{" +
                "fields='" + fields + '\'' +
                ", orderBy=" + Arrays.toString(orderBy) +
                '}';
    }
}
