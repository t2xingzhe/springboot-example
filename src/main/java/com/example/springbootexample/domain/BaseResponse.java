package com.example.springbootexample.domain;

import lombok.Data;

/**
 * <p>Copyright: 版权所有 (c) 2018 - 2023</p>
 * <p>Company: 中体彩</p>
 *
 * @author xingzhe
 * @date 2020/11/25 14:37
 */
@Data
public class BaseResponse<T> {
    /**
     * 是否成功
     */
    private Integer success;

    /**
     * 说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(Integer success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse<T> success(T data) {
        return new BaseResponse<T>(ErrorEnum.SUCCESS.getErrCode(), ErrorEnum.SUCCESS.getErrMsg(), data);
    }

    public BaseResponse<T> create(ErrorEnum errorEnum,T data) {
        return new BaseResponse<T>(errorEnum.getErrCode(), errorEnum.getErrMsg(), data);
    }
}
