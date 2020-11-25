package com.example.springbootexample.config;

import com.example.springbootexample.domain.BaseResponse;
import com.example.springbootexample.domain.ErrorEnum;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Copyright: 版权所有 (c) 2018 - 2023</p>
 * <p>Company: 中体彩</p>
 *
 * @author xingzhe
 * @date 2020/11/25 14:18
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({BindException.class})
    public BaseResponse<String> methodArgumentNotValidExceptionHandler(Exception exception,
                                                                       HttpServletRequest request, HttpServletResponse response) {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        StringBuilder sb = new StringBuilder();
        ((BindException) exception).getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            sb.append("[").append(fieldName).append("]").append(error.getDefaultMessage()).append("; ");
        });
        return baseResponse.create(ErrorEnum.PARAM_ERROR, sb.toString());
    }
}
