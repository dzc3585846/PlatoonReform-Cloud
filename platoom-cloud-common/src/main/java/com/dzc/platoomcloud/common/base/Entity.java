package com.dzc.platoomcloud.common.base;

import lombok.Data;

import java.util.Date;

/**
 * 基类
 * @author dzc
 * @date 2020/7/21
 */
@Data
public class Entity {
    /**
     * 新增时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
