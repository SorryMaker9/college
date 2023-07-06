package com.xqing.user.converter;

import com.xqing.persistence.entity.User;
import com.xqing.user.api.dto.UserVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserVo entityToVo(User user);
}
