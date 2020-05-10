package com.alibaba.service;

import com.alibaba.entity.MallMerchant;
import com.alibaba.mapper.MallMerchantMapper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Desc
 * @Author 阿里P10大神退退
 * @date 2020/5/10 15:12
 */
@Service
@Transactional
public class MallMerchantService {

    @Autowired
    private MallMerchantMapper mallMerchantMapper;

    private static final Logger LOG = LoggerFactory.getLogger(MallMerchantService.class);

    /**
     * 查找所有的商户列表
     * @return
     */
    public List<MallMerchant> findAll() {
        return mallMerchantMapper.findAll();
    }

    public List<MallMerchant> findByMerchandise() {
        List<Integer> merchandiseList = Lists.newLinkedList();
        merchandiseList.add(new Integer(1));
        merchandiseList.add(new Integer(3));
        merchandiseList.add(new Integer(4));
        return mallMerchantMapper.findByMerchandise(merchandiseList);
    }

    public String insert() {
        String result;
        try {
            List<Integer> merchandiseList = Lists.newLinkedList();
            merchandiseList.add(new Integer(1));
            merchandiseList.add(new Integer(3));
            merchandiseList.add(new Integer(4));
            MallMerchant mallMerchant = new MallMerchant();
            mallMerchant.setMerchandise(merchandiseList);
            mallMerchant.setCreationDate(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            mallMerchant.setCreator(System.getProperty("user.name"));
            mallMerchantMapper.insert(mallMerchant);
            result = "success";
            LOG.info("数据插入成功...");
        } catch (Exception e) {
            result = "failed";
            LOG.error("插入数据时出现异常 --> ", e.getMessage());
        }
        return result;
    }
}
