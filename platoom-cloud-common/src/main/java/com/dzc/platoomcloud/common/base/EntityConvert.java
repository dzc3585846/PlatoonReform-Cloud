package com.dzc.platoomcloud.common.base;

import org.apache.poi.ss.formula.functions.T;

import java.util.Objects;

/**
 * 实体转换器
 * @author dzc
 * @date 2020/7/21
 */
public interface EntityConvert<S,T> {
    default T convert(S source){
        return null;
    }
    default T convertPlus(S source, Objects...objects) {
        return null;
    }
}
