package com.xqing.user.controller;

import com.xqing.user.api.dto.MyWalletVo;
import com.xqing.user.api.dto.UserVo;
import com.xqing.user.api.request.UserReq;
import com.xqing.user.api.service.UserService;
import com.swak.frame.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户管理模块接口
 */
@Slf4j
@Validated
@RestController
public class UserController {

    @DubboReference
    private UserService userService;


    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public Response<UserVo> login(@RequestBody @Validated UserReq request) {
        return userService.getLoginUser(request.getUserName(),request.getPwd());
    }

    /**
     * 我的钱包余额
     *
     * @return
     */
    @GetMapping("/my/wallet")
    public Response<MyWalletVo> getMyWallet() {
        return Response.success();
    }
}
