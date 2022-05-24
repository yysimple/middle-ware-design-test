package com.simple.pagination.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.pagination.domain.Demo;
import com.simple.pagination.mapper.DemoMapper;
import com.simple.pagination.service.DemoService;
import org.springframework.stereotype.Service;

/**
* 项目: pagination
*
* 功能描述: 业务实现
*
* @author: wuchengxing
* @create: 2022-05-24 16:03:41
**/
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

}