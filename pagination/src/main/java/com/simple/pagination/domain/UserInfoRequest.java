package com.simple.pagination.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 项目: pagination
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-05-25 10:24
 **/
@Data
public class UserInfoRequest {
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
    private String createTime;
}
