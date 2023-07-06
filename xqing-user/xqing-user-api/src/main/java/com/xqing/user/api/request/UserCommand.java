package com.xqing.user.api.request;

import com.swak.frame.dto.base.Command;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserCommand extends Command {

    @NotNull
    private Long userId;

    @NotBlank
    private String userName;
}
