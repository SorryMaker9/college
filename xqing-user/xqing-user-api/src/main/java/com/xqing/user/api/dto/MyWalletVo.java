package com.xqing.user.api.dto;

import com.swak.frame.dto.base.VO;
import lombok.Data;

@Data
public class MyWalletVo implements VO {

    /**
     * 钱包余额
     */
    private Double walletBalance;
}
