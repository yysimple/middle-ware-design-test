package com.simple.schedule.test;

import com.simple.schedule.annotation.EnableSimpleSchedule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目: pagination
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-07-12 16:53
 **/
@SpringBootApplication
@EnableSimpleSchedule
public class SimpleScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleScheduleApplication.class, args);
    }
}
