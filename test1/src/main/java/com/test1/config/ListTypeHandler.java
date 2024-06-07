package com.test1.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.poi.ss.formula.functions.T;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author XT
 * @Title: ListTypeHandler
 * @Date: 2024/6/3 16:54
 * @description: 数据库字段类型转换工具类(list - varchar)
 */
@Slf4j
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({List.class})
public class ListTypeHandler implements TypeHandler<List<String>> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,list2String(strings));
    }

    private String list2String(List<String> list){
        if(CollectionUtils.isNotEmpty(list)){
            return StringUtils.join(list,",");
        }
        return null;
    }

    @Override
    public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
        if(StringUtils.isNotBlank(resultSet.getString(s))){
            return Arrays.asList(resultSet.getString(s).split(","));
        }
        return null;
    }


    @Override
    public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
        if(StringUtils.isNotBlank(resultSet.getString(i))){
            return Arrays.asList(resultSet.getString(i).split(","));
        }
        return null;
    }

    @Override
    public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
        if(StringUtils.isNotBlank(callableStatement.getString(i))){
            return Arrays.asList(callableStatement.getString(i).split(","));
        }
        return null;
    }

}
