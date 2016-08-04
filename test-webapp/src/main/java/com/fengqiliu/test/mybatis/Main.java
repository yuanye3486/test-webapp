package com.fengqiliu.test.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @athor liufengqi
 * @date 2016/6/23
 * @since 2.0
 */
public class Main {
    private SqlSession session;

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Main main = new Main();
        main.session = sqlSessionFactory.openSession();



        main.batchInsert();
    }

    private void batchInsert() {
        InsertClauseHelper insertClauseHelper = new InsertClauseHelper();
        List<String> vals = new ArrayList<>();
        vals.add("'n1'");
        vals.add("'n2'");
        vals.add("'n3'");
        insertClauseHelper.setInsertValuesClauseList(vals);
        session.insert("com.fengqiliu.test.mybatis.User.addByHelper", insertClauseHelper);
        for (Long id : insertClauseHelper.getPkIds()) {
            System.out.println(id);
        }
    }

    private void selectOne() {
        User user = (User) session.selectOne("com.fengqiliu.test.mybatis.User.selectOne", 1);
        System.out.println(user.getComponent().getName());
    }

}
