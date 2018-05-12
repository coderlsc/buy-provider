package com.qdu.buy.lang;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Title: 分页
 *
 * @author Saintcy Don
 * @version 1.0
 */
@Data
public class Page<T> implements Serializable {
    private int totalCount;//总条数
    private int total;

    private int pageNo;//当前页码,从1开始
    private int pageSize = 10;//每页记录数
    private int totalPage;//总页数
    private List<T> rows;//记录列表

    public Page() {
    }

    public Page(int totalCount, int pageNo, int pageSize, List<T> rows) {
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1 ;
        this.rows = rows;
    }

//    public T getRow(int i) {
//        if (rows != null) {
//            return rows.get(i);
//        } else {
//            return null;
//        }
//    }

//    public T getFirstRow() {
//        return isEmpty() ? null : getRow(0);
//    }
//
//    public T getLastRow() {
//        return getRow(rows == null ? 0 : rows.size());
//    }

    public boolean isEmpty() {
        return rows == null || rows.size() == 0;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                '}';
    }
}
