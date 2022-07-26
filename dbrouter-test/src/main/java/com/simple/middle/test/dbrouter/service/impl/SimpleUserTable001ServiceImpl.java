package com.simple.middle.test.dbrouter.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;
import com.simple.middle.test.dbrouter.service.SimpleUserTable001Service;
import com.simple.middle.test.dbrouter.mapper.SimpleUserTable001Mapper;
import com.simple.middle.test.dbrouter.domain.SimpleUserTable001;

/**
* 项目: middle-ware-design-test
*
* 功能描述: 简单的用户表ServiceImpl类
*
* @author: wuchengxing
* @create: 2022-07-26 23:11:26
**/
@Service
public class SimpleUserTable001ServiceImpl extends ServiceImpl<SimpleUserTable001Mapper, SimpleUserTable001> implements SimpleUserTable001Service {

}