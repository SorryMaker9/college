package com.xqing.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swak.frame.dto.base.Entity;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")
public class User extends Entity {

	@TableId(type = IdType.AUTO)
	private Long id;

	@TableField(value = "account")
	private String account;

	@TableField(value = "phone")
	private String phone;

	@TableField(value = "password")
	private String password;

	@TableField(value = "status")
	private Integer status;

	@TableField(value = "creator_id")
	private String creatorId;

	@TableField(value = "create_time")
	private Date createTime;

	@TableField(value = "modifier_id")
	private String modifierId;

	@TableField(value = "modify_time")
	private Date modifyTime;
}
