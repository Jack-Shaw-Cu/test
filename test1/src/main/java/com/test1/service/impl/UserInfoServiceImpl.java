package com.test1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test1.bean.BizException;
import com.test1.bean.Constant;
import com.test1.controller.query.UserInfoQuery;
import com.test1.controller.vo.UserInfoVo;
import com.test1.dao.UserInfoDao;
import com.test1.dao.entity.UserInfoDo;
import com.test1.enums.MyEnum;
import com.test1.mapper.UserInfoMapper;
import com.test1.service.UserInfoService;
import com.test1.service.bo.UserBo;
import com.test1.service.bo.UserInfoBo;
import com.test1.util.RedisUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author XT
 * @Title: UserInfoServiceImpl
 * @Date: 2024/5/14 18:52
 * @description: 用户详情serviceImpl
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoDo> implements UserInfoService {

    @Resource
    private RedisUtils redisUtils;

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
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public void addUserInfo(List<UserInfoBo> userInfoBoList) {
        if(CollectionUtils.isNotEmpty(userInfoBoList)){
            for (UserInfoBo userInfoBo : userInfoBoList) {
                userInfoBo.setHobby(MyEnum.getByNumber(userInfoBo.getHobbyNumber()));
            }
            this.saveBatch(this.userInfoMapper.bosToDos(userInfoBoList));
        }
        throw new BizException("添加数据错误！");
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
        if(Objects.nonNull(userInfoQuery.getAge())){
            queryWrapper.eq("age",userInfoQuery.getAge());
        }
        if(StringUtils.isNotBlank(userInfoQuery.getHobby())){
            queryWrapper.like("hobby",userInfoQuery.getHobby());
        }
        return this.baseMapper.findByConditionPage(new Page<>(userInfoQuery.getCurrent(), userInfoQuery.getSize()), queryWrapper);
    }

    @Override
    public List<UserInfoDo> findAll() {
//        if(this.redisUtils.hasKey(Constant.HOT_USER)){
//            return (List<UserInfoDo>) this.redisUtils.get(Constant.HOT_USER);
//        }
        List<UserInfoDo> list = this.baseMapper.selectList(null);
        this.redisUtils.set(Constant.HOT_USER,list);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(Long id, UserInfoBo userInfoBo) throws Exception{
        UserInfoDo userInfoDo = this.getById(id);
        if(Objects.isNull(userInfoDo)){
            throw new Exception("查无此人！");
        }
        userInfoBo.setHobby(MyEnum.getByNumber(userInfoBo.getHobbyNumber()));
        userInfoDo  = this.userInfoMapper.boToDo(userInfoBo);
        userInfoDo.setId(id);
        this.updateById(userInfoDo);
    }


}
