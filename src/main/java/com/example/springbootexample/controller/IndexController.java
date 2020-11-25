package com.example.springbootexample.controller;

import com.example.springbootexample.domain.BaseResponse;
import com.example.springbootexample.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>Copyright: 版权所有 (c) 2018 - 2023</p>
 * <p>Company: 中体彩</p>
 *
 * @author xingzhe
 * @date 2020/11/25 13:40
 */
@Api(value = "首页controller", tags = "测试")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "请求已完成"),
        @ApiResponse(code = 201, message = "资源成功被创建"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 403, message = "服务器接受请求，但是拒绝处理"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器出现异常")}
)
@RestController
public class IndexController {

    @ApiOperation(value = "首页", notes = "首页测试接口")
    @RequestMapping(value="/index", method= RequestMethod.GET)
    public Object hello(@ApiParam(value = "desc of param", required = true) @RequestParam String name) {
        return "Hello " + name + "!";
    }

    @ApiOperation(value = "添加用户，注解校验", notes = "可以自动校验参数是否合法")
    @RequestMapping(value="/addUser", method= RequestMethod.POST)
    public Object addUser(@RequestBody @Valid User user) {

        return "success";
    }

    @ApiOperation(value = "查询用户，restful", notes = "查询用户信息")
    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    public BaseResponse<User> addUser(@PathVariable Long id) {
        User user = new User();
        user.setAccount("tom");
        user.setPassword("xxx");
        user.setId(id);
        user.setEmail("123@fsd.com");
        return new BaseResponse<User>().success(user);
    }
}
