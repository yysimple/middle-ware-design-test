package com.simple.middle.test.dbrouter.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.middle.test.dbrouter.service.SimpleUserTableService;
import com.simple.middle.test.dbrouter.mapper.SimpleUserTableMapper;
import com.simple.middle.test.dbrouter.domain.SimpleUserTable;

/**
* 项目: middle-ware-design-test
*
* 功能描述: 简单的用户表ServiceImpl类
*
* @author: wuchengxing
* @create: 2022-07-26 23:11:26
**/
@Service
public class SimpleUserTableServiceImpl extends ServiceImpl<SimpleUserTableMapper, SimpleUserTable> implements SimpleUserTableService {

}