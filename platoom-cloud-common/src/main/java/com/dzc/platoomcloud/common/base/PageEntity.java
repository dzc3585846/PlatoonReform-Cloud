package com.dzc.platoomcloud.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Page对象
 * @author dzc
 * @date 2020/7/21
 */
@Data
public class PageEntity implements Serializable {

    /**
     * 当前页数
     */
    private int page;

    /**
     * 页大小
     */
    private int size;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序类型（0：升序； 1：降序）
     */
    private int sortTyle;


}
