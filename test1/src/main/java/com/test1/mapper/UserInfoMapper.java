package com.test1.mapper;

import com.test1.controller.vo.UserInfoVo;
import com.test1.dao.entity.UserInfoDo;
import com.test1.enums.MyEnum;
import com.test1.service.bo.UserInfoBo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author XT
 * @Title: UserInfoMapper
 * @Date: 2024/5/14 18:34
 * @description: 用户详情mapper
 */
@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    /**
     * boToDo
     * @param userInfoBo
     * @return
     */
    UserInfoDo boToDo(UserInfoBo userInfoBo);

    /**
     * bosToDos
     * @param userInfoBoList
     * @return
     */
    List<UserInfoDo> bosToDos(List<UserInfoBo> userInfoBoList);

    /**
     * switch
     * @param userInfoDo
     * @return
     */
    @Mappings({
            @Mapping(target = "hobby",expression = "java(userInfoDo.getHobby().getTitle())")
    })
    UserInfoVo doToVo(UserInfoDo userInfoDo);

}
