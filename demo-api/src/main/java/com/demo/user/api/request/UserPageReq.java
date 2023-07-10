package com.demo.user.api.request;


import com.swak.frame.dto.PageInfo;
import lombok.Data;


@Data
public class UserPageReq extends PageInfo {

    private String loginName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 状态
     */
    private String status;
}
