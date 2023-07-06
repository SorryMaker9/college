package com.xqing.core.enums;


import com.swak.frame.enums.IResultCode;
import org.springframework.http.HttpStatus;

/**
 * BasicErrCode 的扩展
 */
public enum ResultCode implements IResultCode {

    //
    IMPORT_EXCEL_ERR(70000, "excel导入异常"),
    INTERNAL_SERVER_ERROR(50001, "内部服务异常，请稍后再试"),
    ;

    private Integer code;
    private String msg;


    private ResultCode(Integer code, String msg) {
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
