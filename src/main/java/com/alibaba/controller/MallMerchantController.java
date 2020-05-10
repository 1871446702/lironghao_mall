package com.alibaba.controller;

import com.alibaba.entity.MallMerchant;
import com.alibaba.service.MallMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desc
 * @Author 阿里P10大神退退
 * @date 2020/5/10 15:21
 */
@RestController
@RequestMapping("merchant")
public class MallMerchantController {

    @Autowired
    private MallMerchantService mallMerchantService;

    /**
     * 查找所有的商户列表
     * @return
     */
    @RequestMapping("findAll")
    public List<MallMerchant> findAll() {
        return mallMerchantService.findAll();
    }

    /**
     * 根据经营范围查找
     * @return
     */
    @RequestMapping("findByMerchandise")
    public List<MallMerchant> findByMerchandise() {
        return mallMerchantService.findByMerchandise();
    }

    /**
     * 根据经营范围查找
     * @return
     */
    @RequestMapping("insert")
    public String insert() {
        return mallMerchantService.insert();
    }
}
