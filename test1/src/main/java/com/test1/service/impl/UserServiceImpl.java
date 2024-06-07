package com.test1.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test1.bean.UserExcel;
import com.test1.controller.vo.UserVo;
import com.test1.dao.UserDao;
import com.test1.dao.entity.UserDo;
import com.test1.listener.UserExcelListener;
import com.test1.mapper.UserMapper;
import com.test1.service.UserService;
import com.test1.service.bo.UserBo;
import com.test1.util.ValidatedUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author XT
 * @Title: UserServiceImpl
 * @Date: 2024/5/8 17:45
 * @description: 用户serviceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDo> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(UserBo userBo) {
        UserDo userDo = this.userMapper.boToDo(userBo);
        this.save(userDo);
    }

    @Override
    public List<UserVo> findAll() {
        return this.userMapper.dosToVos(this.baseMapper.selectList(null));
    }

    @Override
    public UserVo findById(Long id) {
        return this.userMapper.doToVo(this.getById(id));
    }

    private void pageFind(){
        Page<UserDo> page = new Page<>(1,2);
        Page<UserDo> userDoPage = this.baseMapper.selectPage(page, null);
        System.out.println(userDoPage.getPages() + "页数");
        System.out.println(userDoPage.getTotal() + "条");
        userDoPage.getRecords().forEach(System.out::println);
    }

    @Override
    public List<UserExcel> importExcel(MultipartFile file) {
        List<UserExcel> list = null;
        List<UserExcel> failList = new ArrayList<>();
        try {
            list = EasyExcel.read(file.getInputStream(),UserExcel.class,new UserExcelListener()).sheet().doReadSync();
            list.forEach(data -> {
                Set<ConstraintViolation<UserExcel>> validate = ValidatedUtils.getValidator().validate(data);
                if(validate.size() > 0){
                    failList.add(data);
                }
            });
            list.removeAll(failList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }



}
