package com.simple.schedule.test.task;

import com.simple.schedule.annotation.SimpleSchedule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 项目: pagination
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-07-12 17:01
 **/
@Component
public class DemoTaskOne {

    @Value("${server.port}")
    private Integer port;

    @SimpleSchedule(cron = "0/3 * * * * *", desc = "01定时任务执行测试：taskMethod01", autoStartup = true)
    public void taskMethod01() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        System.out.println("port: " + port + "==01定时任务执行测试：taskMethod01");
    }
}
