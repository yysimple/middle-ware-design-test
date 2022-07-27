package com.simple.middle.test.dbrouter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.simple.dbrouter.annotation.DBRouter;
import com.simple.dbrouter.annotation.DbRouterStrategy;
import com.simple.dbrouter.annotation.RouterParam;
import com.simple.middle.test.dbrouter.test.ParamTest;
import org.apache.ibatis.annotations.Mapper;
import com.simple.middle.test.dbrouter.domain.SimpleUserTable;
import org.apache.ibatis.annotations.Param;

/**
* 项目: middle-ware-design-test
*
* 功能描述: 简单的用户表
*
* @author: wuchengxing
* @create: 2022-07-26 23:11:26
**/
@Mapper
@DbRouterStrategy(splitTable = true)
public interface SimpleUserTableMapper extends BaseMapper<SimpleUserTable> {

    @DBRouter(key = "id")
    int insertUser(SimpleUserTable simpleUserTable);

    @DBRouter(key = "id")
    SimpleUserTable findById(@Param("id") Long id);
}