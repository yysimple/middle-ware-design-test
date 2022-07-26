package com.simple.middle.test.dbrouter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.dbrouter.annotation.DbRouterStrategy;
import org.apache.ibatis.annotations.Mapper;
import com.simple.middle.test.dbrouter.domain.SimpleUserTable001;

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
public interface SimpleUserTable001Mapper extends BaseMapper<SimpleUserTable001> {

}