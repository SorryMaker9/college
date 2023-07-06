package com.xqing.user.service.impl;

import com.swak.frame.dto.Response;
import com.swak.frame.exception.Assert;
import com.swak.frame.util.DigestUtils;
import com.xqing.persistence.entity.User;
import com.xqing.persistence.service.MpUserService;
import com.xqing.user.api.dto.UserVo;
import com.xqing.user.api.service.UserService;
import com.xqing.user.constants.UserResultCode;
import com.xqing.user.converter.UserConverter;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class UserServiceImpl implements UserService {


    @Resource
    private MpUserService mpUserService;

    @Resource
    private UserConverter userConverter;

    /**
     * 获取登陆用户信息
     *
     * @return
     */
    @Override
    public Response<UserVo> getLoginUser(String userName, String pwd) {
        UserVo user = mpUserService.lambdaQuery().eq(User::getAccount, userName)
                .eq(User::getPassword, DigestUtils.md5(pwd))
                .list().stream().findFirst().map(userConverter::entityToVo).orElse(null);
        Assert.notNull(user, UserResultCode.USER_NOT_FOUND.getMsg());
        return Response.success(user);
    }
}
