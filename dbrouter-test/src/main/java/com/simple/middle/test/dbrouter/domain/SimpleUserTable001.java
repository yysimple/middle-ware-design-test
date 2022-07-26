package com.simple.middle.test.dbrouter.domain;

import lombok.Data;
import java.util.Date;

/**
* 项目: middle-ware-design-test
*
* 功能描述: 简单的用户表
*
* @author: wuchengxing
* @create: 2022-07-26 23:11:26
**/
@Data
public class SimpleUserTable001 {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}