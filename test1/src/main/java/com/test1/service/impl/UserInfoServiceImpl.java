package com.test1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test1.controller.query.UserInfoQuery;
import com.test1.controller.vo.UserInfoVo;
import com.test1.dao.UserInfoDao;
import com.test1.dao.entity.UserInfoDo;
import com.test1.enums.MyEnum;
import com.test1.mapper.UserInfoMapper;
import com.test1.service.UserInfoService;
import com.test1.service.bo.UserInfoBo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XT
 * @Title: UserInfoServiceImpl
 * @Date: 2024/5/14 18:52
 * @description: 用户详情serviceImpl
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoDo> implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private UserInfoMapper userInfoMapper;
    @Override
    public void addUserInfo(UserInfoBo userInfoBo) {
        userInfoBo.setHobby(MyEnum.getByNumber(userInfoBo.getHobbyNumber()));
        this.save(this.userInfoMapper.boToDo(userInfoBo));
    }

    @Override
    public void addUserInfo(List<UserInfoBo> userInfoBoList) {
        if(null != userInfoBoList && userInfoBoList.size() > 0){
            for (UserInfoBo userInfoBo : userInfoBoList) {
                userInfoBo.setHobby(MyEnum.getByNumber(userInfoBo.getHobbyNumber()));
            }
            this.saveBatch(this.userInfoMapper.bosToDos(userInfoBoList));
        }
    }

    @Override
    public UserInfoVo findById(Long id) {
        return this.userInfoMapper.doToVo(this.baseMapper.selectById(id));
    }

    @Override
    public IPage<UserInfoDo> findByConditionPage(UserInfoQuery userInfoQuery) {
        QueryWrapper<UserInfoDo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(userInfoQuery.getName())){
            queryWrapper.eq("name",userInfoQuery.getName());
        }
        if(null != userInfoQuery.getAge()){
            queryWrapper.eq("age",userInfoQuery.getAge());
        }
        if(StringUtils.isNotBlank(userInfoQuery.getHobby())){
            queryWrapper.like("hobby",userInfoQuery.getHobby());
        }
        return this.baseMapper.findByConditionPage(new Page<>(userInfoQuery.getCurrent(), userInfoQuery.getSize()), queryWrapper);
    }


}
