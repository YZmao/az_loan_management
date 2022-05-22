package com.myz.azloanmanage.util;

import lombok.Data;

@Data
public class QueryInfo {

    /**
     * 第几页
     */
    private Integer pageNumber;
    /**
     * 一页多少条数据
     */
    private Integer pageSize;
    /**
     * 查询内容
     */
    private String queryString;
}
