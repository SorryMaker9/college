package com.demo.user.controller;

import com.demo.user.api.dto.UserVo;
import com.demo.user.api.request.UserCommand;
import com.demo.user.api.request.UserPageReq;
import com.demo.user.api.service.UserService;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 用户管理模块接口
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/system/user")
public class UserController {

    @DubboReference
    private UserService userService;

    /**
     * 分页查询
     * @param query
     * @return
     */
    @GetMapping("/list")
    public Result<Pagination<UserVo>> queryUserList(@ModelAttribute @Validated UserPageReq query) {
        return userService.queryUserList(query);
    }
    /**
     * 新增用户
     */
    @PostMapping("/add")
    public Result<Void> addUser(@RequestBody @Validated UserCommand command) {
      return userService.addUser(command);
    }

    /**
     * 用户修改
     * @param command
     * @return
     */
    @PutMapping("/edit")
    public Result<Void> editUser(@RequestBody @Validated UserCommand command) {
        return userService.updateUser(command);
    }
}
