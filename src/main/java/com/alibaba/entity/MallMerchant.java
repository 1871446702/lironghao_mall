package com.alibaba.entity;

import lombok.Data;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Desc 商户类
 * @Author 阿里P10大神退退
 * @date 2020/5/10 15:05
 */
@Data
public class MallMerchant {

    private Integer id;

    /**
     * 经营的商品
     */
    private List<Integer> merchandise;

    /**
     * 注册日期
     */
    private String creationDate;

    /**
     * 注册人
     */
    private String creator;
}
