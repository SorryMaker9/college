package com.xqing.user.api.dto;

import com.swak.frame.dto.base.VO;
import lombok.Data;

@Data
public class UserVo implements VO {
	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 用户ID
	 */
	private Long userId;
}
