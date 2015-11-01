package com.fengqiliu.test.misc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonTest {

    public static void main(String[] args) {
        try {
            test();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void test() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"msg\":\"\",\"data\":[[\"collpoint.coll_inc.1hour/drId=52,mt=5,name=3688\u73a9##\u8d44\u8baf\u4e2d\u5fc3_\u8d44\u8baf\",\"GAUGE\",3600]],\"ok\":true}";
        Counter counter = objectMapper.readValue(json, Counter.class);
        System.out.println(counter);

    }

    public class Counter {
        private boolean ok;
        private String msg;
        private List<String[]> data;

        public boolean getOk() {
            return ok;
        }

        public void setOk(boolean ok) {
            this.ok = ok;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<String[]> getData() {
            return data;
        }

        public void setData(List<String[]> data) {
            this.data = data;
        }
    }

}
