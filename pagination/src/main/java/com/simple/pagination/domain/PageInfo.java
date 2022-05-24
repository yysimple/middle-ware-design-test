package com.simple.pagination.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 项目: pagination
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-05-24 17:32
 **/
@Data
public class PageInfo {
    @JsonIgnore
    private Integer pageIndex;
    @JsonIgnore
    private Integer pageSize;
}
