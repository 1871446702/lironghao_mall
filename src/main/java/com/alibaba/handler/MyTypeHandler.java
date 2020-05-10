package com.alibaba.handler;

import com.google.common.collect.Lists;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc
 * @Author 阿里P10大神退退
 * @date 2020/5/10 16:10
 */
public class MyTypeHandler extends BaseTypeHandler<List<Integer>> {

    private static final Logger LOG = LoggerFactory.getLogger(MyTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<Integer> integers, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        for(Integer integer : integers){
            sb.append(integer).append(",");
        }
        preparedStatement.setString(i, sb.toString().substring(0, sb.toString().length() - 1));
        LOG.info("MyTypeHandler setNonNullParameter 执行...");
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String[] array = resultSet.getString(s).split(",");
        List<Integer> integerList = Lists.newLinkedList();
        try {
            for (String arr : array) {
                integerList.add(Integer.parseInt(arr));
            }
        } catch (NumberFormatException e) {
            LOG.error("MyTypeHandler getNullableResult s 执行时出现异常...");
        }
        LOG.info("MyTypeHandler getNullableResult s 执行...");
        return integerList;
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String[] array = resultSet.getString(i).split(",");
        List<Integer> integerList = Lists.newLinkedList();
        try {
            for (String arr : array) {
                integerList.add(Integer.parseInt(arr));
            }
        } catch (NumberFormatException e) {
            LOG.error("MyTypeHandler getNullableResult i 执行时出现异常...");
        }
        LOG.info("MyTypeHandler getNullableResult i 执行...");
        return integerList;
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String[] array = callableStatement.getString(i).split(",");
        List<Integer> integerList = Lists.newLinkedList();
        try {
            for (String arr : array) {
                integerList.add(Integer.parseInt(arr));
            }
        } catch (NumberFormatException e) {
            LOG.error("MyTypeHandler getNullableResult callableStatement i 执行时出现异常...");
        }
        LOG.info("MyTypeHandler getNullableResult callableStatement i 执行...");
        return integerList;
    }

}
