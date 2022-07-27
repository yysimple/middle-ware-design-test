package com.simple.middle.test;

import com.simple.middle.test.dbrouter.DbRouterApplication;
import com.simple.middle.test.dbrouter.domain.SimpleUserTable;
import com.simple.middle.test.dbrouter.mapper.SimpleUserTableMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 项目: middle-ware-design-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-07-26 22:53
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DbRouterApplication.class)
public class DbRouterTest {

    @Resource
    private SimpleUserTableMapper mapper;

    @Test
    public void insertTest() {
        SimpleUserTable simpleUserTable = new SimpleUserTable();
        for (long i = 1; i <= 5; i++) {
            simpleUserTable.setId(11L + i);
            simpleUserTable.setAge(10 + (int) i);
            simpleUserTable.setName("zz" + i);
            simpleUserTable.setSex((int) i / 2 == 0 ? "男" : "女");
            mapper.insertUser(simpleUserTable);
        }
    }

}
