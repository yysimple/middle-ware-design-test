package com.simple.pagination.controller;

import javax.annotation.Resource;

import com.simple.pagination.domain.UserInfoRequest;
import com.simple.pagination.util.Page;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import com.simple.pagination.domain.UserInfo;
import com.simple.pagination.domain.SimpleResponse;
import com.simple.pagination.service.UserInfoService;

/**
 * 项目: pagination
 * <p>
 * 功能描述: 用户表Controller类
 *
 * @author: wuchengxing
 * @create: 2022-05-24 16:23:38
 **/
@RestController
@RequestMapping("/userInfo")
@Api(tags = "UserInfo 接口")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 通过ID查询单个用户表
     *
     * @param id ID
     * @return {@link UserInfo}
     */
    @ApiOperation(value = "通过Id查询UserInfo信息")
    @GetMapping("/findUserInfoById")
    public SimpleResponse<UserInfo> findUserInfoById(@RequestParam("id") Long id) {
        return new SimpleResponse<>(userInfoService.findUserInfoById(id));
    }

    /**
     * 多条件查询UserInfo列表
     *
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "多条件查询UserInfo列表")
    @PostMapping("/listUserInfo")
    public SimpleResponse<List<UserInfo>> listUserInfo(@RequestBody UserInfo userInfo) {
        return new SimpleResponse<>(userInfoService.listUserInfo(userInfo));
    }

    @ApiOperation(value = "多条件分页查询UserInfo列表")
    @PostMapping("/pageUserInfos")
    public SimpleResponse<Page<UserInfo>> pageUserInfos(@RequestBody UserInfoRequest userInfoRequest, Integer pageIndex, Integer pageSize) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserInfo userInfo = new UserInfo();
        userInfo.setPageIndex(pageIndex);
        userInfo.setPageSize(pageSize);
        userInfo.setId(userInfoRequest.getId());
        userInfo.setName(userInfoRequest.getName());
        if (!Objects.isNull(userInfoRequest.getCreateTime())) {
            userInfo.setCreateTime(dateFormat.parse(userInfoRequest.getCreateTime()));
        }
        return new SimpleResponse<>(userInfoService.pageUserInfos(userInfo));
    }

    /**
     * 新增用户表
     *
     * @param userInfo 用户表
     */
    @ApiOperation(value = "新增UserInfo")
    @PostMapping("/insertUserInfo")
    public SimpleResponse<String> insertUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.insertUserInfo(userInfo);
        return new SimpleResponse<>("insert success");
    }

    /**
     * 修改用户表
     *
     * @param userInfo 用户表
     */
    @ApiOperation(value = "更新UserInfo")
    @PostMapping("/updateUserInfo")
    public SimpleResponse<String> updateUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.updateUserInfo(userInfo);
        return new SimpleResponse<>("update success");
    }

    /**
     * 通过ID删除单个用户表
     *
     * @param id ID
     */
    @ApiOperation(value = "新增UserInfo")
    @PostMapping("/deleteUserInfoById")
    public SimpleResponse<String> deleteUserInfoById(@RequestParam("id") Long id) {
        userInfoService.deleteUserInfoById(id);
        return new SimpleResponse<>("delete success");
    }
}