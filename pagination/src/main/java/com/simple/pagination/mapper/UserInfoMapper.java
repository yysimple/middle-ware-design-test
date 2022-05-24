package com.simple.pagination.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.simple.pagination.domain.UserInfo;
import java.util.List;

/**
* 项目: pagination
*
* 功能描述: 用户表
*
* @author: wuchengxing
* @create: 2022-05-24 16:23:38
**/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
    * 通过ID查询单个用户表
    *
    * @param id ID
    * @return {@link UserInfo}
    */
    UserInfo findUserInfoById(@Param("id") Long id);

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
    void deleteUserInfoById(@Param("id") Long id);

}