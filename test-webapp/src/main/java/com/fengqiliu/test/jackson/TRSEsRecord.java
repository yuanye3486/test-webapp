package com.fengqiliu.test.jackson;

import java.util.Map;

/**
 * @athor liufengqi
 * @date 2016/6/12
 * @since 2.0
 */
public class TRSEsRecord {
    private String id;
    private Map<String, Object> map;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
