package com.simple.pagination.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

import com.simple.pagination.domain.UserInfo;
import com.simple.pagination.util.Page;

/**
 * 项目: pagination
 * <p>
 * 功能描述: 用户表Service类
 *
 * @author: wuchengxing
 * @create: 2022-05-24 16:23:38
 **/
public interface UserInfoService extends IService<UserInfo> {
    /**
     * 通过ID查询单个用户表
     *
     * @param id ID
     * @return {@link UserInfo}
     */
    UserInfo findUserInfoById(Long id);

    /**
     * 多条件查询UserInfo列表
     *
     * @param userInfo
     * @return java.util.List<UserInfo>
     */
    List<UserInfo> listUserInfo(UserInfo userInfo);

    /**
     * 新增用户表
     *
     * @param userInfo 用户表
     */
    void insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户表
     *
     * @param userInfo 用户表
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 通过ID删除单个用户表
     *
     * @param id ID
     */
    void deleteUserInfoById(Long id);

    /**
     * 分页插件
     *
     * @param userInfo
     * @return
     */
    Page<UserInfo> pageUserInfos(UserInfo userInfo);
}