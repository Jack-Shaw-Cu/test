package com.test1.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test1.dao.entity.UserInfoDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author XT
 * @Title: UserInfo
 * @Date: 2024/5/14 17:52
 * @description: 用户详情
 */
public interface UserInfoDao extends BaseMapper<UserInfoDo> {

    /**
     * findByConditionPage
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select({
        "SELECT * FROM `test_user_info` ${ew.customSqlSegment}"
    })
    IPage<UserInfoDo> findByConditionPage(Page<UserInfoDo> page, @Param(Constants.WRAPPER) QueryWrapper<UserInfoDo> queryWrapper);
}
