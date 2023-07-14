package com.demo.converter;

import com.demo.persistence.entity.ChinaSecurities;
import com.demo.persistence.entity.SysUser;
import com.demo.user.api.dto.SecuritiesVo;
import com.demo.user.api.dto.UserVo;
import com.demo.user.api.request.SecuritiesCommand;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecuritiesConverter {
    SecuritiesVo entityToVo(ChinaSecurities securities);

    ChinaSecurities toEntity(SecuritiesCommand command);
}
