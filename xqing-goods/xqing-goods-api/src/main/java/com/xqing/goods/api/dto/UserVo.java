package com.xqing.goods.api.dto;

import com.swak.frame.dto.base.VO;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements VO {
	/**
	 * 登陆账号
	 */
	private String account;

	/**
	 * 邮件
	 */
	private String email;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 电话
	 */
	private String phone;
}
