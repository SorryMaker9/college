package com.demo.converter;

import com.demo.persistence.entity.SysUser;
import com.demo.user.api.dto.UserVo;
import com.demo.user.api.request.UserCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserVo entityToVo(SysUser user);

    SysUser toEntity(UserCommand command);
}

