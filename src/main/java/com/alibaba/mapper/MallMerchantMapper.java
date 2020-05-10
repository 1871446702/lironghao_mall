package com.alibaba.mapper;

import com.alibaba.entity.MallMerchant;
import com.fasterxml.jackson.databind.JavaType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @Desc
 * @Author 阿里P10大神退退
 * @date 2020/5/10 15:05
 */
@Mapper
public interface MallMerchantMapper {

    List<MallMerchant> findAll();

    void insert(MallMerchant mallMerchant);

    List<MallMerchant> findByMerchandise(@Param("merchandise") List<Integer> merchandise);
}
