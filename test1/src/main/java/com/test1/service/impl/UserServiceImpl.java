package com.test1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test1.dao.UserDao;
import com.test1.dao.entity.UserDo;
import com.test1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author XT
 * @Title: UserServiceImpl
 * @Date: 2024/5/8 17:45
 * @description: 用户serviceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDo> implements UserService {

    @Override
    public void addUser(UserDo userDo) {
        this.baseMapper.selectList(null);
        this.save(userDo);
    }

    @Override
    public List<UserDo> findAll() {
        this.pageFind();
        QueryWrapper<UserDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","红莲");
        return this.baseMapper.selectList(queryWrapper);
    }

    private void pageFind(){
        Page<UserDo> page = new Page<>(1,2);
        Page<UserDo> userDoPage = this.baseMapper.selectPage(page, null);
        System.out.println(userDoPage.getPages() + "页数");
        System.out.println(userDoPage.getTotal() + "条");
        userDoPage.getRecords().forEach(System.out::println);
    }


}
