package com.myz.azloanmanage.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult<T> extends Result implements Serializable {
    /**
     * 总记录数
     */
    private long total;

    /**
     * 分页数据
     */
    private List<T> rows;


    public PageResult(long total, List<T> rows) {
        super(200, "分页查询成功");
        this.total = total;
        this.rows = rows;
    }


}


