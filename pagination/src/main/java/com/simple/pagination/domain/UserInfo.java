package com.simple.pagination.domain;

import com.simple.pagination.util.Pageable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
* 项目: pagination
*
* 功能描述: 用户表
*
* @author: wuchengxing
* @create: 2022-05-24 16:23:38
**/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UserInfo对象", description="UserInfo基本信息表")
public class UserInfo extends PageInfo {
    /**
    *
    */
    @ApiModelProperty(value = "")
    private Long id;
    /**
    * 
    */
    @ApiModelProperty(value = "")
    private String name;
    /**
    * 当前创建时间
    */
    @ApiModelProperty(value = "当前创建时间")
    private Date createTime;
}