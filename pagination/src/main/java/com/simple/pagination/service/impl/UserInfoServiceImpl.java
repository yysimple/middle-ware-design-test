package com.simple.pagination.service.impl;

import com.simple.pagination.util.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;
import java.util.List;
import com.simple.pagination.domain.UserInfo;
import com.simple.pagination.service.UserInfoService;
import com.simple.pagination.mapper.UserInfoMapper;

/**
* 项目: pagination
*
* 功能描述: 用户表ServiceImpl类
*
* @author: wuchengxing
* @create: 2022-05-24 16:23:38
**/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
    * 通过ID查询单个用户表
    *
    * @param id ID
    * @return {@link UserInfo}
    */
    @Override
    public UserInfo findUserInfoById(Long id) {
        return userInfoMapper.findUserInfoById(id);
    }

    /**
    * 多条件查询UserInfo列表
    *
    * @param userInfo
    * @return java.util.List<UserInfo>
    */
    @Override
    public List<UserInfo> listUserInfo(UserInfo userInfo) {
        return userInfoMapper.listUserInfo(userInfo);
    }

    /**
    * 新增用户表
    *
    * @param userInfo 用户表
    */
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        userInfoMapper.insertUserInfo(userInfo);
    }

    /**
    * 修改用户表
    *
    * @param userInfo 用户表
    */
    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }

    /**
    * 通过ID删除单个用户表
    *
    * @param id ID
    */
    @Override
    public void deleteUserInfoById(Long id) {
        userInfoMapper.deleteUserInfoById(id);
    }

    @Override
    public Page<UserInfo> pageUserInfos(UserInfo userInfo) {
        List<UserInfo> userInfos = userInfoMapper.listUserInfo(userInfo);
        return Page.of(userInfos, userInfo.getPageIndex(), userInfo.getPageSize());
    }
}