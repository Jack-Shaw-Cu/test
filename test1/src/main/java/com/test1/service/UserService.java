package com.test1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test1.dao.entity.UserDo;

import java.util.List;

/**
 * @author XT
 * @Title: UserService
 * @Date: 2024/5/8 17:44
 * @description: 用户service
 */
public interface UserService extends IService<UserDo> {

    void addUser(UserDo userDo);

    List<UserDo> findAll();

}
