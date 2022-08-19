package com.simple.middle.test.wx.mp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目: pagination
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-08-19 17:34
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "i'm say hello method!!";
    }
}
