package com.fengqiliu.test.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @athor liufengqi
 * @date 2016/6/12
 * @since 2.0
 */
public class JacksonTest {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        enumTest();
    }

    private static class Inner {
        enum E {
            A("A"), B("B"), C("C");
            String val;

            E(String val) {
                this.val = val;
            }
        }

        enum EN {
            A, B, C
        }

        private E e1 = E.A;
        private EN en = EN.B;

        public E getE1() {
            return e1;
        }

        public void setE1(E e1) {
            this.e1 = e1;
        }

        public EN getEn() {
            return en;
        }

        public void setEn(EN en) {
            this.en = en;
        }
    }

    public static void enumTest() throws IOException {
        Inner inner = new Inner();
        String json = objectMapper.writeValueAsString(inner);
        System.out.println(json);

        Inner inner2 = objectMapper.readValue(json, Inner.class);
        System.out.println(inner2);

    }

    public static void es() throws JsonProcessingException {
        List<TRSEsRecord> list = new ArrayList<>();
        TRSEsRecord record = new TRSEsRecord();
        record.setId("1");
        Map<String, Object> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        record.setMap(map);

        list.add(record);
        PageResultSet<TRSEsRecord> pageResultSet = new PageResultSet(new Page(), 1, list);

        String json = objectMapper.writeValueAsString(new ResponseResult<PageResultSet>(pageResultSet, true, 0, "", ""));
        System.out.println(json);
    }
}
