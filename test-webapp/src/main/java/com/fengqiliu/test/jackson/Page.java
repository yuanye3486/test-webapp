package com.fengqiliu.test.jackson;

import java.io.Serializable;

/**
 * 分页查询条件
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageNo = 1;
    private int pageSize = 20;
    private boolean useHasNext = true;
    private boolean pagingEnable = true;

    public Page(int pageNo, int pageSize, boolean useHasNext) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.useHasNext = useHasNext;
    }

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page() {
    }

    /**
     * 返回页码
     *
     * @return
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置页码
     *
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 每页条数
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页条数
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 是否还有下一页
     *
     * @return
     */
    public boolean getUseHasNext() {
        return useHasNext;
    }

    /**
     * 设置是否还有下一页
     *
     * @param isUseHasNext
     */
    public void setUseHasNext(boolean isUseHasNext) {
        this.useHasNext = isUseHasNext;
    }

    /**
     * 是否启用分页
     *
     * @return
     */
    public boolean getPagingEnable() {
        return pagingEnable;
    }

    /**
     * 设置是否启用分页
     *
     * @param pagingEnable
     */
    public void setPagingEnable(boolean pagingEnable) {
        this.pagingEnable = pagingEnable;
    }

    @Override
    public String toString() {
        return "PageArgs{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", useHasNext=" + useHasNext +
                ", pagingEnable=" + pagingEnable +
                '}';
    }
}
