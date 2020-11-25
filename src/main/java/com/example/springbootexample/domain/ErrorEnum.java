package com.example.springbootexample.domain;

import lombok.Data;

/**
 * <p>Copyright: 版权所有 (c) 2018 - 2023</p>
 * <p>Company: 中体彩</p>
 *
 * @author xingzhe
 * @date 2020/11/25 14:38
 */
public enum ErrorEnum {
    /**
     * 成功
     */
    SUCCESS(0,"请求成功"),

    /**
     * 系统内部异常
     */
    COMMON_ERROR(1,"系统异常，请排查"),

    /**
     * 业务异常
     */
    BUSINESS_ERROR(2,"业务异常"),

    /**
     * 参数异常
     */
    PARAM_ERROR(3,"参数异常");

    /**
     * @param errCode
     * @param errMsg
     */
    ErrorEnum(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * 错误码
     */
    private int errCode;

    /**
     * 错误描述
     */
    private String errMsg;

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
