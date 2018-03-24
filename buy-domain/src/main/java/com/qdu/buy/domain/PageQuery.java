package com.qdu.buy.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询条件
 * User: Saintcy
 * Date: 2015/7/9
 * Time: 13:02
 */
@Data
public class PageQuery extends Query implements Serializable {
    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private Integer startRowNo = (pageNo - 1) * pageSize;
    public PageQuery(){}

    public PageQuery(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 查询一行，用于查找唯一匹配的数据
     */
    public void one() {
        this.pageNo = 1;
        this.pageSize = 1;
    }

    /**
     * 当前页的第一条记录
     */
    public int getStartRowNo() {
        return (this.pageNo - 1) * this.pageSize;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
