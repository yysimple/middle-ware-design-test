package com.simple.middle.test.elk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目: middle-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-09-04 15:21
 **/
@RestController
@RequestMapping("/elk")
@Slf4j
public class ELKController {

    @GetMapping("/test")
    public String test() {
        log.info("我是测试logstash的！！！");
        return "test!!";
    }
}
