package com.nowcoder.community.entity;

import com.nowcoder.community.dao.DiscussPostMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Page {
    //当前页面
    private int current = 1;
    //单页上限
    private int limit = 10;
    //总页数
    private int rows;
    //查询路径
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOffset() {
        return (current - 1) * limit;
    }

    public int getTotal() {
        if(rows % limit == 0) {
            return rows / limit;
        }else {
            return rows / limit + 1;
        }
    }

    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
