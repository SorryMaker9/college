package com.xqing.persistence.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqing.persistence.entity.User;
import com.xqing.persistence.mapper.UserMapper;
import com.xqing.persistence.service.MpUserService;
import org.springframework.stereotype.Service;

@Service
public class MpUserServiceImpl extends ServiceImpl<UserMapper, User>
        implements MpUserService {
}