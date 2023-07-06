package com.xqing.user.api.service;

import com.xqing.user.api.dto.UserVo;
import com.swak.frame.dto.Response;

/**
 * @author colley.ma
 * @since 2023/2/9 11:31
 */
public interface UserService {

	/**
	 * 获取登陆用户信息
	 * @return
	 */
	Response<UserVo> getLoginUser(String userName,String pwd);

}
