package com.test1.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test1.controller.query.UserInfoQuery;
import com.test1.controller.query.UserQuery;
import com.test1.controller.vo.UserInfoVo;
import com.test1.dao.entity.UserInfoDo;
import com.test1.service.bo.UserBo;
import com.test1.service.bo.UserInfoBo;

import java.util.List;

/**
 * @author XT
 * @Title: UserInfoService
 * @Date: 2024/5/14 18:47
 * @description: 用户详情service
 */
public interface UserInfoService extends IService<UserInfoDo> {

    /**
     * addUserInfo
     * @param userInfoBo
     */
    void addUserInfo(UserInfoBo userInfoBo);

    /**
     * addUserInfo
     * @param userInfoBoList
     */
    void addUserInfo(List<UserInfoBo> userInfoBoList);

    /**
     * findById
     * @param id
     * @return
     */
    UserInfoVo findById(Long id);

    /**
     * findByConditionPage
     * @param userInfoQuery
     * @return
     */
    IPage<UserInfoDo> findByConditionPage(UserInfoQuery userInfoQuery);

    /**
     * findAll
     * @return
     */
    List<UserInfoDo> findAll();

    /**
     * updateUserInfo
     * @param id
     * @param userInfoBo
     */
    void updateUserInfo(Long id, UserInfoBo userInfoBo) throws Exception;
}
