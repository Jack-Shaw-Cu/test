package com.test1.mapper;

import com.test1.controller.vo.UserVo;
import com.test1.dao.entity.UserDo;
import com.test1.service.bo.UserBo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author XT
 * @Title: UserMapper
 * @Date: 2024/5/23 22:43
 * @description: userMapper
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * boToDo
     * @param userBo
     * @return
     */
    @Mappings({
            @Mapping(target = "name",source = "userName")
    })
    UserDo boToDo(UserBo userBo);

    /**
     * doToVo
     * @param userDo
     * @return
     */
    UserVo doToVo(UserDo userDo);

    /**
     * dosToVos
     * @param list
     * @return
     */
    List<UserVo> dosToVos(List<UserDo> list);
}
