package com.test1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test1.bean.UserExcel;
import com.test1.controller.vo.UserVo;
import com.test1.dao.entity.UserDo;
import com.test1.service.bo.UserBo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author XT
 * @Title: UserService
 * @Date: 2024/5/8 17:44
 * @description: 用户service
 */
public interface UserService extends IService<UserDo> {

    /**
     * addUser
     * @param userBo
     */
    void addUser(UserBo userBo);

    /**
     * findAll
     * @return
     */
    List<UserVo> findAll();

    /**
     * findById
     * @param id
     * @return
     */
    UserVo findById(Long id);

    /**
     * importExcel
     * @param file
     * @return
     */
    List<UserExcel> importExcel(MultipartFile file);

}
