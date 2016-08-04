package com.fengqiliu.test.jackson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果集
 *
 * @author liufengqi
 * @version 2.0.0
 */
public class PageResultSet<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总条目数
     */
    private int totalItemNum;

    /**
     * 总页数
     */
    private int totalPageNum;

    /**
     * 每页条目数
     */
    private int pageSize;

    /**
     * 当前页码
     */
    private int pageNo;

    /**
     * 分页数据
     */
    private List<T> page;

    /**
     * 是否有下一页
     */
    private boolean hasNext;

    public PageResultSet() {
    }

    public PageResultSet(Page info, int totalItemNum, List<T> page) {
        this.totalItemNum = totalItemNum;

        if (info.getPageSize() > 0) {
            this.pageSize = info.getPageSize();
        } else {
            this.pageSize = 20;
        }

        this.totalPageNum = totalItemNum / this.pageSize;
        if (totalItemNum % this.pageSize > 0) {
            this.totalPageNum++;
        }

        if (info.getPageNo() > 0 && totalPageNum != 0) {
            this.pageNo = info.getPageNo() > this.totalPageNum ? this.totalPageNum : info.getPageNo();
        } else {
            this.pageNo = 1;
        }

        if (page != null) {
            this.page = page;
        } else {
            this.page = new ArrayList<T>();
        }

        if (info.getUseHasNext()) {
            this.hasNext = this.totalPageNum > this.pageNo;
        } else {
            this.hasNext = false;
        }
    }

    /**
     * 查询结果集总数量
     *
     * @return 查询结果集总数量
     */
    public int getTotalItemNum() {
        return totalItemNum;
    }

    /**
     * 查询结果集总数量
     *
     * @param totalItemNum 查询结果集总数量
     */
    public void setTotalItemNum(int totalItemNum) {
        this.totalItemNum = totalItemNum;
    }

    /**
     * 查询结果集总页数
     *
     * @return 查询结果集总页数
     */
    public int getTotalPageNum() {
        return totalPageNum;
    }

    /**
     * 查询结果集总页数
     *
     * @param totalPageNum 查询结果集总页数
     */
    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    /**
     * 每分页记录条数
     *
     * @return 每分页记录条数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 每分页记录条数
     *
     * @param pageSize 每分页记录条数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 请求的页号
     *
     * @return 请求的页号
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 请求的页号
     *
     * @param pageNo 请求的页号
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 请求页的返回内容
     *
     * @return 请求页的返回内容
     */
    public List<T> getPage() {
        return page;
    }

    /**
     * 请求页的返回内容
     *
     * @param page 请求页的返回内容
     */
    public void setPage(List<T> page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PageResultSet{" +
                "totalItemNum=" + totalItemNum +
                ", totalPageNum=" + totalPageNum +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", page=" + page +
                '}';
    }
}
