package com.xqing.user.constants;

import com.swak.frame.enums.IResultCode;

/**
 * 用户的服务接口返回吗
 * @author colley.ma
 * @since 2023/2/9 11:33
 */
public enum UserResultCode implements IResultCode {
	USER_NOT_FOUND(1404,"用户不存在");
	private Integer code;
	private String msg;
	 UserResultCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}

}
