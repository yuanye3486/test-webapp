package com.fengqiliu.test.mybatis;

import java.util.List;

/**
 * @athor liufengqi
 * @date 2016/7/6
 * @since 2.0
 */
public class InsertClauseHelper {
    /**
     * 表主键
     */
    private Long pkId;

    /**
     * 表主键
     */
    private List<Long> pkIds;

    private List<String> insertValuesClauseList;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public List<Long> getPkIds() {
        return pkIds;
    }

    public void setPkIds(List<Long> pkIds) {
        this.pkIds = pkIds;
    }

    public List<String> getInsertValuesClauseList() {
        return insertValuesClauseList;
    }

    public void setInsertValuesClauseList(List<String> insertValuesClauseList) {
        this.insertValuesClauseList = insertValuesClauseList;
    }
}
