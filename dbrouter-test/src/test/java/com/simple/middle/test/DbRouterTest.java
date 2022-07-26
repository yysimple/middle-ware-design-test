package com.simple.middle.test;

import com.simple.middle.test.dbrouter.DbRouterApplication;
import com.simple.middle.test.dbrouter.domain.SimpleUserTable001;
import com.simple.middle.test.dbrouter.mapper.SimpleUserTable001Mapper;
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
    private SimpleUserTable001Mapper mapper;

    @Test
    public void insertTest() {
        SimpleUserTable001 simpleUserTable001 = new SimpleUserTable001();
        for (long i = 0; i < 5; i++) {
            simpleUserTable001.setId(i);
            simpleUserTable001.setAge(10 + (int) i);
            simpleUserTable001.setName("zz" + i);
            simpleUserTable001.setSex((int) i / 2 == 0 ? "男" : "女");
            mapper.insert(simpleUserTable001);
        }
    }

}
