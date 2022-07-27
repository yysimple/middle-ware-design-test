package com.simple.middle.test.dbrouter.test;

import java.lang.annotation.*;

/**
 * 项目: middle-ware-design-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-07-27 22:06
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface ParamTest {

    String value();
}
