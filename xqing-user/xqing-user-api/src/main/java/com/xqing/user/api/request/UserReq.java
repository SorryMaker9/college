package com.xqing.user.api.request;


import com.swak.frame.dto.base.Query;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserReq extends Query {

    /**
     * 用户名称
     */
    @NotBlank
    private String userName;

    /**
     * 登录密码
     */
    @NotBlank
    private String pwd;
}
